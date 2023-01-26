/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_filetransfer;

import java.io.File;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public interface FileTrans {
    static final int BUFFER = 4096;
    void addFile(File pth);
    void setSocket(Socket ab);
    boolean RecFile() throws Exception;
    boolean SendFile() throws Exception;
    long Transize();
}
