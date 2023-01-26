/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_filetransfer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author ENVY
 */
public class TCP_Client {
    Socket socket = null;
    InetAddress ip = null;

    public TCP_Client(InetAddress ip , int port) throws IOException {
        this.ip = ip;
        socket = new Socket(ip,port);
    }
    Socket GetSocket()
    {
        return socket;
    }
    void testConnection()
    {
        System.out.println(ip.getAddress().toString());
    }
    
    
}
