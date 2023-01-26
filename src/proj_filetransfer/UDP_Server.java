/*
 * returns Bool for successful transfer of ip address or not
 (if true main program will start a serversocket for listening)
 Requires Threading
 Thread One sends packet in a infinite loop
 Thread Two Waits for a Response From Client in An infinite Loop
 When Thread 2 gets Response, Both Threads are terminated
 */
package proj_filetransfer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Khushi
 * @Date Feb 21, 2017
 */
public class UDP_Server extends Thread {

    static volatile boolean flag = true;
    DatagramSocket ds = null,ds1=null;
    InetAddress ip = null;
    DatagramPacket dp = null,dp1 = null;
    String threadName = null;

    public static void setFlag(boolean flag) {
        UDP_Server.flag = flag;
    }
    
    public UDP_Server(String threadName) {
        super(threadName);
        this.threadName = threadName;
    }

    public void ShutDown() {
        flag = false;
        System.out.println("UDP Server ShutDown : "+flag);
        String str1= new String(dp.getData(),0,dp.getLength());
        System.out.println("UDP SERVER READ DATA :  "+str1 + dp.getAddress());
    }
    public void close()
    {
        flag=false;
    }
    public void readData()
    {   
        try {
            //this.ShutDown();
            ds = new DatagramSocket(6547);
            byte[] buf = new byte[1024];
            dp = new DatagramPacket(buf, 1024);
            ds.receive(dp);
            String str= new String(dp.getData(),0,dp.getLength());
            System.out.println("UDP SERVER READ DATA :  "+str + dp.getAddress());
            

            /*(try (ServerSocket srvr = new ServerSocket(6547)) {
                Socket skt = srvr.accept();
                System.out.print("Server has connected!\n" + skt.getInetAddress());
                //PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
                //String data = "Hey "+ skt.getInetAddress().getHostName();
                //System.out.print("Sending string: '" + data + "'\n");
                //out.print(data);
                //out.close();
                skt.close();
            }*/
        } catch (SocketException ex) {
            Logger.getLogger(TCP_Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UDP_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public void run() {
            
        
        if(Thread.currentThread().getName().equals("Thread1"))
        {
            String str = null;
            try {
                ds = new DatagramSocket();
                str = InetAddress.getLocalHost().toString();
                ip = InetAddress.getByName("255.255.255.255");
                dp = new DatagramPacket(str.getBytes(), str.length(), ip, 3000);
            } catch (SocketException ex) {
                Logger.getLogger(UDP_Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnknownHostException ex) {
                Logger.getLogger(UDP_Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("UDP SERVER RUN : "+dp.getAddress().toString());
            
            
            while(flag)
            {
                try {
                    System.out.println("running 1 "+Thread.currentThread().getName());
                    ds.send(dp);
                    Thread.sleep(100);
                } catch (IOException ex) {
                    Logger.getLogger(UDP_Server.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(UDP_Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
        {
            try {
                ds = new DatagramSocket(6547);
                byte[] buf = new byte[1024];
                dp = new DatagramPacket(buf, 1024);
                   
                while(flag)
                {
                    System.out.println("running 22222222222222222"+Thread.currentThread().getName());
                    ds.receive(dp);
                    //System.out.println("end thread 2");
                    if(dp.getData() != null)
                    {
                        
                        //System.out.println("Exiting Thread 2222222222");
                        //String str1= new String(dp.getData(),0,dp.getLength());
                        this.ShutDown();
                        break;  
                    }
                    Thread.sleep(100);
                }
                
                
            } catch (Exception ex) {
                Logger.getLogger(UDP_Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //this.ShutDown();
        //String str1= new String(dp.getData(),0,dp.getLength());
        //System.out.println("UDP SERVER READ DATA :  "+str1 + dp.getAddress());
        ds.close();
    }
}
