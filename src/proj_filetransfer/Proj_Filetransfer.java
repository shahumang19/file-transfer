/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_filetransfer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author Khushi
 */
public class Proj_Filetransfer {

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) throws Exception {
//        // création de la socket
//        int port = 1989;
//        ServerSocket serverSocket = new ServerSocket(port);
//        System.err.println("Serveur lancé sur le port : " + port);
//
//        // repeatedly wait for connections, and process
//        while (true) {
//            // on reste bloqué sur l'attente d'une demande client
//            Socket clientSocket = serverSocket.accept();
//            System.err.println("Nouveau client connecté");
//
//            // on ouvre un flux de converation
//            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
//
//            // chaque fois qu'une donnée est lue sur le réseau on la renvoi sur
//            // le flux d'écriture.
//            // la donnée lue est donc retournée exactement au même client.
//            String s;
//            while ((s = in.readLine()) != null) {
//                System.out.println(s);
//                if (s.isEmpty()) {
//                    break;
//                }
//            }
//
//            out.write("HTTP/1.0 200 OK\r\n");
//            out.write("Date: Fri, 31 Dec 1999 23:59:59 GMT\r\n");
//            out.write("Server: Apache/0.8.4\r\n");
//            out.write("Content-Type: text/html\r\n");
//            out.write("Content-Length: 59\r\n");
//            out.write("Expires: Sat, 01 Jan 2000 00:59:59 GMT\r\n");
//            out.write("Last-modified: Fri, 09 Aug 1996 14:21:40 GMT\r\n");
//            out.write("\r\n");
//            out.write("<TITLE>Exemple</TITLE>");
//            out.write("<P>Ceci est une page d'exemple.</P>");
//
//            // on ferme les flux.
//            System.err.println("Connexion avec le client terminée");
//            out.close();
//            in.close();
//            clientSocket.close();
//        }
//    }
    public static void main(String args[]) throws IOException {
        InetAddress add=InetAddress.getByName("0.0.0.0");
        ServerSocket server = new ServerSocket(1989,0,add);
        System.out.println("Listening for connection on port 8080 ....");
        while (true) {
            try (Socket socket = server.accept()) {
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
            }
        }
    }
}
