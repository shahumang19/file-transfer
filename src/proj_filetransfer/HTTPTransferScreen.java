/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_filetransfer;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Poras
 */
public class HTTPTransferScreen extends javax.swing.JPanel {

    /**
     * Creates new form HTTPTransferScreen
     */
    HttpHost obj=new HttpHost();
    public HTTPTransferScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(6, 231, 236));
        setFont(new java.awt.Font("Transformers Movie", 1, 24)); // NOI18N
        setMaximumSize(new java.awt.Dimension(640, 360));
        setMinimumSize(new java.awt.Dimension(640, 360));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(6, 231, 236));
        jPanel1.setFont(new java.awt.Font("Transformers Movie", 0, 14)); // NOI18N
        jPanel1.setMaximumSize(new java.awt.Dimension(640, 360));
        jPanel1.setMinimumSize(new java.awt.Dimension(640, 360));
        jPanel1.setLayout(null);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBackground(new java.awt.Color(0, 0, 0));
        jTable1.setFont(new java.awt.Font("Transformers Movie", 0, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(6, 231, 236));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Image1", "E:\\",  new Long(24456), "Transferring"},
                    {"Audio1", "D:\\",  new Long(2233456), "Waiting"},
                        {"Video1", "C:\\",  new Long(12233456), "Done"}
                        },
                        new String [] {
                            "Filename", "Location", "FileSize(KB)", "Status"
                        }
                    ) {
                        Class[] types = new Class [] {
                            java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class
                        };
                        boolean[] canEdit = new boolean [] {
                            false, false, false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                            return types [columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit [columnIndex];
                        }
                    });
                    jTable1.setGridColor(new java.awt.Color(6, 231, 236));
                    jTable1.setInheritsPopupMenu(true);
                    jTable1.setMaximumSize(new java.awt.Dimension(300, 64));
                    jTable1.setMinimumSize(new java.awt.Dimension(300, 64));
                    jTable1.setSelectionBackground(new java.awt.Color(6, 231, 236));
                    jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
                    jScrollPane1.setViewportView(jTable1);

                    jPanel1.add(jScrollPane1);
                    jScrollPane1.setBounds(190, 110, 390, 150);

                    jCheckBox1.setBackground(new java.awt.Color(0, 0, 0));
                    jCheckBox1.setFont(new java.awt.Font("Transformers Movie", 0, 18)); // NOI18N
                    jCheckBox1.setForeground(new java.awt.Color(6, 231, 236));
                    jCheckBox1.setText("Send Compressed");
                    jPanel1.add(jCheckBox1);
                    jCheckBox1.setBounds(10, 200, 180, 33);

                    jCheckBox2.setBackground(new java.awt.Color(0, 0, 0));
                    jCheckBox2.setFont(new java.awt.Font("Transformers Movie", 0, 18)); // NOI18N
                    jCheckBox2.setForeground(new java.awt.Color(6, 231, 236));
                    jCheckBox2.setText("Send Encrypted");
                    jPanel1.add(jCheckBox2);
                    jCheckBox2.setBounds(10, 170, 180, 33);

                    jButton3.setBackground(new java.awt.Color(0, 0, 0));
                    jButton3.setFont(new java.awt.Font("Transformers Movie", 0, 24)); // NOI18N
                    jButton3.setForeground(new java.awt.Color(6, 231, 236));
                    jButton3.setText("ADD FILES");
                    jButton3.setBorderPainted(false);
                    jButton3.setContentAreaFilled(false);
                    jButton3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton3ActionPerformed(evt);
                        }
                    });
                    jPanel1.add(jButton3);
                    jButton3.setBounds(10, 100, 170, 50);

                    jButton4.setBackground(new java.awt.Color(0, 0, 0));
                    jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proj_filetransfer/delete.png"))); // NOI18N
                    jButton4.setBorderPainted(false);
                    jButton4.setContentAreaFilled(false);
                    jPanel1.add(jButton4);
                    jButton4.setBounds(580, 110, 50, 30);

                    jButton5.setBackground(new java.awt.Color(0, 0, 0));
                    jButton5.setFont(new java.awt.Font("Transformers Movie", 1, 36)); // NOI18N
                    jButton5.setForeground(new java.awt.Color(6, 231, 236));
                    jButton5.setText("P h o t o n i f y");
                    jButton5.setToolTipText("");
                    jButton5.setBorderPainted(false);
                    jButton5.setContentAreaFilled(false);
                    jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            jButton5MouseClicked(evt);
                        }
                    });
                    jButton5.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton5ActionPerformed(evt);
                        }
                    });
                    jPanel1.add(jButton5);
                    jButton5.setBounds(190, 280, 390, 60);

                    jButton1.setBackground(new java.awt.Color(0, 0, 0));
                    jButton1.setFont(new java.awt.Font("Transformers Movie", 0, 18)); // NOI18N
                    jButton1.setForeground(new java.awt.Color(6, 231, 236));
                    jButton1.setText("_");
                    jButton1.setBorderPainted(false);
                    jButton1.setContentAreaFilled(false);
                    jButton1.setMaximumSize(new java.awt.Dimension(45, 29));
                    jButton1.setMinimumSize(new java.awt.Dimension(45, 29));
                    jButton1.setPreferredSize(new java.awt.Dimension(45, 29));
                    jButton1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
                    jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton1ActionPerformed(evt);
                        }
                    });
                    jPanel1.add(jButton1);
                    jButton1.setBounds(550, 0, 45, 30);

                    jButton2.setBackground(new java.awt.Color(0, 0, 0));
                    jButton2.setFont(new java.awt.Font("Transformers Movie", 0, 24)); // NOI18N
                    jButton2.setForeground(new java.awt.Color(6, 231, 236));
                    jButton2.setText("X");
                    jButton2.setBorderPainted(false);
                    jButton2.setContentAreaFilled(false);
                    jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton2ActionPerformed(evt);
                        }
                    });
                    jPanel1.add(jButton2);
                    jButton2.setBounds(595, 0, 47, 40);

                    jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proj_filetransfer/allPageHeader.png"))); // NOI18N
                    jPanel1.add(jLabel4);
                    jLabel4.setBounds(130, 0, 370, 40);

                    jButton6.setBackground(new java.awt.Color(0, 0, 0));
                    jButton6.setFont(new java.awt.Font("Transformers Movie", 0, 24)); // NOI18N
                    jButton6.setForeground(new java.awt.Color(6, 231, 236));
                    jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proj_filetransfer/back.png"))); // NOI18N
                    jButton6.setBorderPainted(false);
                    jButton6.setContentAreaFilled(false);
                    jButton6.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton6ActionPerformed(evt);
                        }
                    });
                    jPanel1.add(jButton6);
                    jButton6.setBounds(0, 50, 90, 40);

                    add(jPanel1);
                    jPanel1.setBounds(0, 0, 640, 360);
                }// </editor-fold>//GEN-END:initComponents
    ArrayList<File> ar=new ArrayList();
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        for (File f : ar) {
                obj.addFile(f);
            }
        try {
            obj.Start();
        } catch (Exception ex) {
            Logger.getLogger(HTTPTransferScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        //        int tmp= JOptionPane.showConfirmDialog(this, null, "Are you sure you want to go?"
            //                            + " \n you will lose connection", JOptionPane.YES_NO_OPTION);
        //        if(tmp == JOptionPane.YES_OPTION)
        obj.close();
        this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseClicked
    int FileCount = 0;
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        JFileChooser j1= new JFileChooser();
        j1.setMultiSelectionEnabled(true);
        if(JFileChooser.APPROVE_OPTION == j1.showOpenDialog(this))
        {
            int i=0;
            for(File f:j1.getSelectedFiles())
            {
                ar.add(f);
                FileCount++;

            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
