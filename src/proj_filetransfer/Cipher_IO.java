/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_filetransfer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author admin1
 */
public class Cipher_IO implements FileTrans {

    ArrayList<File> loc = new ArrayList();
    Socket socket = null;
    
    

    @Override
    public void addFile(File pth) {
        loc.add(pth);
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSocket(Socket ab) {
        socket = ab;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    String key = "1234567891234567";
    SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");

    @Override
    public boolean SendFile() throws Exception {
        InputStream InputFile;
        CipherInputStream Cinput;
        for (File f : loc) {
            Cipher ctype = Cipher.getInstance("AES"); 
            String NFile = f.getName();
            InputFile = new FileInputStream(f.getAbsolutePath());
            OutputStream Out = socket.getOutputStream();
            //SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
            //javax.crypto.Cipher ctype = javax.crypto.Cipher.getInstance("AES");
            ctype.init(javax.crypto.Cipher.ENCRYPT_MODE, secretKey);
            System.out.println("" + InputFile.available());
            Cinput = new CipherInputStream(InputFile, ctype);
            byte[] data = new byte[4096];
            int read;
            String temp = NFile + "|";
            Out.write(temp.getBytes());
            while ((read = Cinput.read(data)) > 0) {

                System.out.println("Read : " + read);
                Out.write(data, 0, read);
            }
            Out.flush();
            InputFile.close();
            Out.close();
        }
        //To change body of generated methods, choose Tools | Templates.
        return true;
    }

    @Override
    public boolean RecFile() throws Exception {
        InputStream Input=socket.getInputStream();
        CipherInputStream Cinput;
        String OFile = "";
        Cipher ctype = Cipher.getInstance("AES"); 
        ctype.init(javax.crypto.Cipher.DECRYPT_MODE,secretKey);
        System.out.println(""+Input.available());
        Cinput = new CipherInputStream(socket.getInputStream(), ctype);
        //System.out.println(""+Cinput.read());
        char con;
        while((con = (char)Input.read()) != '|')
        {
            if(con != '|')
            OFile += con +"";  
        }
        System.out.println(OFile);
        int read;
        byte data[]=new byte[BUFFER];
        FileOutputStream OutFile=null;
        OutFile = new FileOutputStream(loc.get(0).getAbsolutePath()+"/"+OFile);
        System.out.println(loc.get(0).getAbsolutePath()+OFile);
        while((read = Cinput.read(data))!=-1)
        {
            System.out.println("Read : "+read);
            OutFile.write(data, 0, read);
        }
        Cinput.close();
        OutFile.flush();
        OutFile.close();
        return true;
    }

    @Override
    public long Transize() {
        long j=0L;
        for(File f:loc)
        {
            j+=f.length();
        }
        return j;
    }

}
