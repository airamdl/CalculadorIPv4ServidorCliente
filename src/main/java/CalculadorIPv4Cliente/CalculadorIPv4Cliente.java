/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CalculadorIPv4Cliente;

/**
 *
 * @author alumno
 */

public class CalculadorIPv4Cliente {
   private final String host;
    private final int port;

    public CalculadorIPv4Cliente(String host, int port) {
        this.host = host;
        this.port = port;
    }
    
    public static void main(String[] args) {
        CalculadorIPv4Cliente client = new CalculadorIPv4Cliente("localhost", 5000);
        client.start();
    }
}
