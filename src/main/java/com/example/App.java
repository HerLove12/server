package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            System.out.println("Server avviato");
            ServerSocket server = new ServerSocket(3000);

            Socket s = server.accept();
            System.out.println("in client si è connesso");

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            
            String risposta = "";
            while(risposta != "q"){
            risposta = in.readLine();
            System.out.println("il client ha inviato: " + risposta);

            String stringaModificata = risposta.toUpperCase();
            out.writeBytes(stringaModificata + "\n");
            }
            server.close();
            s.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
