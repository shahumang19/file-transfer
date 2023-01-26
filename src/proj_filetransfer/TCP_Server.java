package proj_filetransfer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ENVY
 */
public class TCP_Server {
    ServerSocket svrsocket = null;
    Socket socket = null;
    
    public TCP_Server(int port) throws IOException {
        svrsocket = new ServerSocket(port);
    }
    
    void start() throws IOException
    {
        socket = svrsocket.accept();
        System.out.print("Server has connected!\n" + socket.getInetAddress());
    }
    Socket GetSocket()
    {
        return socket;
    }
    void closeSocket() throws IOException
    {
        socket.close();
    }
//    public static void main(String[] args) throws IOException {
//        UDP_Server us = new UDP_Server();
//        UDP_Client uc = new UDP_Client();
//        us.start();
//        System.out.println("CLIENT START");
//        uc.start();
//        us.readData(us);
//    }
}
