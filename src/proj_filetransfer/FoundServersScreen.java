/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_filetransfer;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Poras
 */
public class FoundServersScreen extends javax.swing.JPanel implements Runnable {

    /**
     * Creates new form FoundServersScreen
     */
    volatile UDP_Client Uclient = null;
    TCP_Client Tclient = null;
    volatile ArrayList<String> ar=new ArrayList();
    volatile ArrayList<InetAddress> ip=new ArrayList();
    Thread th=null;
    public FoundServersScreen() {
        initComponents();
        this.setBounds( 0, 0, 640, 360);
        this.setVisible(true);
        th=new Thread(this);
        th.start();
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(6, 231, 236));
        setFont(new java.awt.Font("Transformers Movie", 0, 48)); // NOI18N
        setMaximumSize(new java.awt.Dimension(640, 360));
        setMinimumSize(new java.awt.Dimension(640, 360));
        setPreferredSize(new java.awt.Dimension(640, 360));
        setLayout(null);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Transformers Movie", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(6, 231, 236));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Found");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel1);
        jLabel1.setBounds(120, 50, 290, 40);

        jList1.setBackground(new java.awt.Color(0, 0, 0));
        jList1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jList1.setFont(new java.awt.Font("Transformers Movie", 0, 14)); // NOI18N
        jList1.setForeground(new java.awt.Color(6, 231, 236));
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setSelectionBackground(new java.awt.Color(6, 231, 236));
        jList1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        add(jScrollPane2);
        jScrollPane2.setBounds(30, 90, 580, 250);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proj_filetransfer/refresh3.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        add(jLabel3);
        jLabel3.setBounds(430, 50, 40, 40);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Transformers Movie", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(6, 231, 236));
        jButton1.setText("Connect");
        jButton1.setContentAreaFilled(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(470, 50, 160, 40);

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Transformers Movie", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(6, 231, 236));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proj_filetransfer/back.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(0, 50, 90, 40);

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setFont(new java.awt.Font("Transformers Movie", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(6, 231, 236));
        jButton5.setText("_");
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setMaximumSize(new java.awt.Dimension(45, 29));
        jButton5.setMinimumSize(new java.awt.Dimension(45, 29));
        jButton5.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        add(jButton5);
        jButton5.setBounds(550, 0, 45, 30);

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setFont(new java.awt.Font("Transformers Movie", 0, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(6, 231, 236));
        jButton6.setText("X");
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        add(jButton6);
        jButton6.setBounds(595, 0, 47, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proj_filetransfer/allPageHeader.png"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(130, 0, 370, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:        
    }//GEN-LAST:event_jList1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        
        if(th.getState().equals(Thread.State.TERMINATED))
        {
            th=new Thread(this);
            th.start();
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        int i=jList1.getSelectedIndex();
        if(i==-1)
        {
            System.out.println("Select any Server");
            return;
        }
        
        try {
            Tclient = new TCP_Client(ip.get(i), 6666);
        } catch (IOException ex) {
            Logger.getLogger(FoundServersScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        FileTrans obj=null;
        DataInputStream dis=null;
        byte ab[]=new byte[10];
           String str="";
        try {
            dis=new DataInputStream(Tclient.GetSocket().getInputStream());
            i=dis.read();
            
            System.out.println("int:"+i);
            str+=(char)i;
            System.out.println("String:"+str);
        } catch (IOException ex) {
            Logger.getLogger(FoundServersScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        switch(str)
        {
            case "1":
                System.out.println("FILEIO");
                obj=new FileIO();
                break;
            case "2":
                System.out.println("COMPRESS");
                obj=new Compress();
                break;
            case "3":
                System.out.println("CIPHERIO");
                obj=new Cipher_IO();
                break;
        }
        
        obj.setSocket(Tclient.GetSocket());
            //obj.RecFile();
            
        obj.addFile(new File("D:/"));
        try {
            obj.RecFile();
        } catch (Exception ex) {
            Logger.getLogger(FoundServersScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1MouseClicked

//    public void show()
//    {
//        repaint();
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private volatile javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void run() {
        System.out.println("Start");
            try {
            Uclient=new UDP_Client();
            Uclient.start();
            System.out.println(Uclient.getIp().getHostName());
            ar.add(Uclient.getIp().getHostName());
            ip.add(Uclient.getIp());
            jList1.setListData(new Vector<String>(ar));
                
        } catch (SocketException ex) {
            Logger.getLogger(FoundServersScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("end");
            
    }
}
