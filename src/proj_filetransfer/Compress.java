/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_filetransfer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.zip.*;

/**
 *
 * @author ENVY
 */
public class Compress implements FileTrans {

    private ZipInputStream zis = null;
    private ZipOutputStream zos = null;
    private InputStream is = null;
    private OutputStream os = null;
    Socket socket=null;
    ArrayList<File> loc=new ArrayList();

    @Override
    public void addFile(File fl) {
        loc.add(fl); //To change body of generated methods, choose Tools | Templates.
    }
    byte buff[] = new byte[BUFFER];

    @Override
    public boolean SendFile() throws Exception {
        //FileOutputStream fos = new FileOutputStream("D:\\gog.zip");

        BufferedOutputStream bs = new BufferedOutputStream(os);
        zos = new ZipOutputStream(bs);//socket.getOutputStream()
        zos.setMethod(ZipOutputStream.DEFLATED);
        zos.setLevel(Deflater.BEST_COMPRESSION);
        for (File s : loc) {
            System.out.println("String: " +s.getAbsolutePath());

            FileInputStream fs = new FileInputStream(s);
            BufferedInputStream bis = new BufferedInputStream(fs, BUFFER);
            
            System.out.println("Filename:" + s.getName());
            ZipEntry ze = new ZipEntry(s.getName());
            zos.putNextEntry(ze);
            int cnt = 0;
            while ((cnt = bis.read(buff, 0,
                    BUFFER)) != -1) {
                zos.write(buff, 0, cnt);
            }
            zos.closeEntry();
            bis.close();
            fs.close();

        }
        zos.flush();
        zos.finish();
        bs.flush();
        bs.close();
        System.out.println("Writen");
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean RecFile() throws Exception {
        BufferedOutputStream bos = null;
        //vlc-2.2.4-win32.exe
        //DataInputStream dis=new DataInputStream(zis);
        BufferedInputStream bis = new BufferedInputStream(is);
        ZipInputStream zis = new ZipInputStream(bis);
        ZipEntry entry=null;
        while ((entry = zis.getNextEntry()) != null) {
            System.out.println("Extracting: " + entry);
            int cnt;
            // write the files to the disk
            FileOutputStream fos = new FileOutputStream(loc.get(0)+entry.getName());
            System.out.println(loc.get(0)+entry.getName());
            bos = new BufferedOutputStream(fos, BUFFER);
            while ((cnt = zis.read(buff, 0, BUFFER))
                    != -1) {
                System.out.println("inside" + cnt);
                bos.write(buff, 0, cnt);
                SendAndFileSelectionScreen.x+=cnt;
            }
            bos.flush();
            zis.closeEntry();
            
        }
        bos.flush();
        bos.close();
        zis.close();
        return true; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void setSocket(Socket ab) {

        socket=ab;
        try {
            os=socket.getOutputStream();
            is=socket.getInputStream();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        //To change body of generated methods, choose Tools | Templates.
    }
    public void setOutStream(OutputStream ab) {

        os=ab;
        
        
        //To change body of generated methods, choose Tools | Templates.
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
