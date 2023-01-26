/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_filetransfer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class FileIO implements FileTrans {

    Socket socket = null;
    ArrayList<File> loc = new ArrayList();

    @Override
    public void setSocket(Socket ab) {
        socket = ab;
    }

    @Override
    public void addFile(File fl) {
        loc.add(0, fl);
    }

    @Override
    public boolean RecFile() throws Exception {

        Path p = Paths.get("");
        System.out.println(p.toAbsolutePath().toString());
        String pathToFile = p.toAbsolutePath().toString();

        Socket s = socket;
        //System.out.println(ss.getInetAddress().toString());
        DataInputStream input = new DataInputStream(s.getInputStream());
        //FileOutputStream fileOut = new FileOutputStream("C:\\Users\\ENVY\\Documents\\app_copy.jpg");
        FileOutputStream fileOut = null;
        char c;
        int size, n = 0;
        n = input.read();
        System.out.println("Size:" + n);
        //String fileName = pathToFile + "\\DOWNLOADS\\";
        for (int j = 0; j < n; j++) {
            String temp = "", fileName = loc.get(0).getAbsolutePath(); //"E:\\Umang\\College\\SEM-IV\\CJ\\TW1\\tw1\\Downloads\\"

            while ((c = (char) input.read()) != '|') {
                fileName += c;
                System.out.println(c);
            }
            while ((c = (char) input.read()) != '|') {
                temp += c;
                System.out.print(c);
            }
            size = Integer.parseInt(temp);
            System.out.println("\n" + fileName + "\n Available" + input.available());
            fileOut = new FileOutputStream(fileName);
            byte[] buff = new byte[4096];
            //char c;
            int i = 0;
            int read;
            while (size > 0) {
                System.out.println(size);

                read = input.read(buff, 0, Math.min(buff.length, size));
                size -= read;
                System.out.println("Size : " + size);
                System.out.println("read : " + read);
                fileOut.write(buff, 0, read);

                
                
            }
            i++;
            System.out.print(c);
                System.out.println(i);
                System.out.println("Writing completed...");

                fileOut.close();
        }

        input.close();
        return true;
    }

    @Override
    public boolean SendFile() throws Exception {

        Socket s = socket;

        DataOutputStream output = new DataOutputStream(s.getOutputStream());
        output.write(loc.size());
        output.write(loc.size());
        for (File f : loc) {
            String fname = f.getAbsolutePath();
            FileInputStream fileInput = new FileInputStream(fname);
            byte[] buff = new byte[4096];

            String fileName = f.getName() + "|";
            System.out.println("" + fileName);
            String size = fileInput.available() + "|";
            output.write(fileName.getBytes());
            output.write(size.getBytes());

            while (fileInput.available() > 0) {
                int read = fileInput.read(buff);
                output.write(buff);
                SendAndFileSelectionScreen.x += read;
                System.out.println("X====================" + SendAndFileSelectionScreen.x);
                //output.flush();
            }
            System.out.println("Reading Completed");
            //output.write("HELLO Umang".getBytes());
            
            fileInput.close();
            return true;
        }
        output.close();
        return true;
    }

    @Override
    public long Transize() {
        long j = 0L;
        for (File f : loc) {
            j += f.length();
        }
        return j;
    }
}
