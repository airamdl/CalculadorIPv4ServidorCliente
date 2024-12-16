/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CalculadorIPv4Server;

/**
 *
 * @author alumno
 */
import com.mycompany.calculadoripv4.IPv4Address;
import java.io.*;
import java.net.*;
public class CalculadorIPv4Server {
     private ServerSocket serverSocket;
    private final int port;

    public CalculadorIPv4Server(int port) {
        this.port = port;
    }

     public void start() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Servidor de Calculador de redes iniciado en puerto " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
     
     
    private static class ClientHandler implements Runnable {

        private final Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            
                    
                    
        try {
            String ip = getIPField().getText();
            String mask = getMaskField().getText();

            int maskInt;
            if (mask.contains("/")) {
                String[] parts = mask.split("/");
                ip = parts[0];
                mask = parts[1];
                maskInt = Integer.parseInt(mask);
            } else {
                maskInt = Integer.parseInt(mask);
            }

            IPv4Address address = new IPv4Address(ip, maskInt);

            // Mostrar los resultados en el área de texto
            String result = String.format(
                    "Dirección IP: %s (%s)\n"
                    + "Máscara de red: %s (%s)\n"
                    + "Dirección de red: %s\n"
                    + "Dirección de broadcast: %s\n"
                    + "Primer host: %s\n"
                    + "Último host: %s\n"
                    + "Máximo número de hosts: %.0f\n"
                    + "Tipo: %s\n",
                    address.getIPAddress(), address.getBinaryAddress(),
                    address.getDecimalMask(), address.getBinaryMask(),
                    address.getDecimalNetwork(),
                    address.getDecimalBroadcast(),
                    address.getDecimalFirstHost(),
                    address.getDecimalLastHost(),
                    address.getMaxHosts(),
                    address.getType()
            );
                    
                    
                    
                    
                    
                    
                    out.println(result);
                
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        CalculadorIPv4Server server = new CalculadorIPv4Server(5000);
        server.start();
    }

}
