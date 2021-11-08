package com.exemple.views;

import java.awt.Color;

/**
 *
 * @author Minh Triet
 */
public class ChaoJDialog extends javax.swing.JDialog {

    public ChaoJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    public void init() {
        setLocationRelativeTo(null);
        Thread t = new Thread() {
            int i = -1;
            @Override
            public void run() {
                while (true) {
                    try {
                        i++;
                        prgLoad.setValue(i);
                        if (i == 10) {
                            lblStatus.setForeground(Color.MAGENTA);
                            lblStatus.setText("   Xin chào quý khách...");
                        }
                        if (i == 30) {
                            lblStatus.setForeground(Color.ORANGE);
                            lblStatus.setText("   Phần mềm quản lý khách sạn...");
                        }
                        if (i == 60) {
                            lblStatus.setForeground(Color.green);
                            lblStatus.setText("   Đang kết nối CSDL...");
                        }
                        if (i == 90) {
                            lblStatus.setForeground(Color.RED);
                            lblStatus.setText("   Chuẩn bị vào chương trình...");
                        }
                        if (i == 100) {
                            ChaoJDialog.this.dispose();   
                            break;
                        }
                        Thread.sleep(20); 
                    } catch (InterruptedException ex) {
                        break;
                    }
                }
            }
        };
        t.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        prgLoad = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new java.awt.BorderLayout());
        jPanel2.add(lblLogo, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.BorderLayout());

        lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(51, 51, 255));
        lblStatus.setText("   Khởi động ứng dụng...");
        jPanel1.add(lblStatus, java.awt.BorderLayout.PAGE_START);

        prgLoad.setBackground(new java.awt.Color(255, 102, 0));
        prgLoad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        prgLoad.setStringPainted(true);
        jPanel1.add(prgLoad, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChaoJDialog dialog = new ChaoJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JProgressBar prgLoad;
    // End of variables declaration//GEN-END:variables
}
