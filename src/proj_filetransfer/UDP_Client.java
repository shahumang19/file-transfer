/*
 * Create a function to
    Waits for a packet.
    when recieved, it sends back a packet to confirm recieved info.
    Returns Ip of Client
 */

package proj_filetransfer;

import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Khushi
 * @Date Feb 21, 2017
 */
public class UDP_Client {
    DatagramSocket ds = null;
    byte[] buf;
    DatagramPacket dp=null;
    InetAddress ip = null;
    
    void start() throws SocketException
    {
        //System.out.println("client");
        ds = new DatagramSocket(3000);
        //ds.setBroadcast(true);
        buf = new byte[1024];  
        dp = new DatagramPacket(buf, 1024);  
        try {
            ds.receive(dp);
            String str = new String(dp.getData(), 0, dp.getLength());  
            System.out.println("UDP Client Start : "+str);
            ip = dp.getAddress();
            System.out.println("a)    "+ip.toString());
            
            str = "Data Received";
            dp = new DatagramPacket(str.getBytes(), str.length(),ip,6547);
            ds.send(dp);
            System.out.println("UDP Client Start Test : "+str);
            ds.close(); 
            //Socket clientSocket = new Socket(ip,6547);
            
        } catch (IOException ex) {
            Logger.getLogger(UDP_Client.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception e){
            e.printStackTrace();
        }
    //ds.send(dp);
        
    }

    public InetAddress getIp() {
        return ip;
    }
}
