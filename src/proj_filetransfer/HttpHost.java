/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_filetransfer;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class HttpHost implements FileTrans {
    Socket socket;
    ArrayList<File> loc=new ArrayList();
    @Override
    public void addFile(File pth) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        loc.add(pth);
    }

    @Override
    public void setSocket(Socket ab) {
        socket=ab;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args)throws Exception {
        HttpHost obj=new HttpHost();
        InetAddress ad[]= InetAddress.getAllByName("localhost");
        for(InetAddress tp:ad)
        {
            System.out.println(tp.toString());
        }
        
        obj.addFile(new File("D:/vlc-2.2.4-win32.exe"));
        obj.addFile(new File("D:/cs_1.6_AdrenaLine_setup.exe"));
        obj.addFile(new File("D:/gog.zip"));
        obj.Start();
       
    }
    HttpServer ss=null;
    void Start()
    {
        
        InetAddress ad[] = null;
        try {
            ad = InetAddress.getAllByName("localhost");
        } catch (UnknownHostException ex) {
            Logger.getLogger(HttpHost.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(InetAddress tp:ad)
        {
            System.out.println(tp.toString());
        }
        try {
            ss=HttpServer.create(new InetSocketAddress(8000), 0);
        } catch (IOException ex) {
            Logger.getLogger(HttpHost.class.getName()).log(Level.SEVERE, null, ex);
        }
        ss.createContext("/info", new InfoHandler(loc));
        for(File f:loc)
        {
            System.out.println(f.getName());
            ss.createContext("/"+f.getName(), new FileHandler(f));
            
        }
        ss.setExecutor(null); // creates a default executor
        ss.start();
    }

    @Override
    public long Transize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    static class InfoHandler implements HttpHandler {
        ArrayList<File> loc=null;
        public InfoHandler(ArrayList<File> ar) {
            loc=ar;
        }
        
        public void handle(HttpExchange t) throws IOException {
          String response = "Use Folling links to download\n";
          for(File f:loc)
        {
            response+="/"+f.getName()+"\n";
            
        }
          t.sendResponseHeaders(200, response.length());
          OutputStream os = t.getResponseBody();
          os.write(response.getBytes());
          os.close();
        }//response.setHeader("Content-Disposition", "attachment; filename=\"" + "test.zip" + "\"");
        //response.setHeader("Content-Type", "application/zip");
    }
    static class FileHandler implements HttpHandler {
        File file=null;
        public FileHandler(File f) {
            this.file=f;
        }
        
        public void handle(HttpExchange t) throws IOException {
            Headers h = t.getResponseHeaders();
            h.add("Content-Type", "application/octet-stream");

            // a PDF (you provide your own!)
            byte [] bytearray  = new byte [(int)file.length()];
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            int ab=bis.read(bytearray, 0, bytearray.length);

            // ok, we are ready to send the response.
            t.sendResponseHeaders(200, file.length());
            OutputStream os = t.getResponseBody();
            os.write(bytearray, 0, ab);
            os.close();
            //response.setHeader("Content-Disposition", "attachment; filename=\"" + "test.zip" + "\"");
            //response.setHeader("Content-Type", "application/zip");
        }
    }
    public void close()
    {
        if(ss!=null)ss.stop(2);
    }
    @Override
    public boolean RecFile() throws Exception {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean SendFile() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
