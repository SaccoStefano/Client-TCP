package client;

import java.awt.event.KeyListener;
import java.util.*;
import java.net.*;
import java.io.*;

public class Pannello extends javax.swing.JFrame{

        int port=2000;
        InetAddress serverAddress;  
        Socket connection;   
        InputStream inSocket; 
        OutputStream outSocket;
        String echo;    
        PrintWriter streamOut;
        Scanner streamIn;
      
    public Pannello(){     
        setLocation(500,300);
        setTitle("TCP Client");      
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Invio = new javax.swing.JTextField();
        Invia = new javax.swing.JButton();
        Cancella = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Ricezione = new javax.swing.JTextArea();
        Maiuscolo = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Invio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InvioActionPerformed(evt);
            }
        });

        Invia.setText("Send");
        Invia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InviaActionPerformed(evt);
            }
        });
        Invia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                InviaKeyPressed(evt);
            }
        });

        Cancella.setText("Delete History");
        Cancella.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancellaActionPerformed(evt);
            }
        });

        jLabel1.setText("Sending");

        jLabel2.setText("Receive ");

        Ricezione.setColumns(20);
        Ricezione.setRows(5);
        jScrollPane2.setViewportView(Ricezione);

        Maiuscolo.setText("Uppercase");
        Maiuscolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaiuscoloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Invio, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Invia, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cancella)
                    .addComponent(Maiuscolo))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Invio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Invia)
                    .addComponent(Cancella))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Maiuscolo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InvioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InvioActionPerformed

    private void InviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InviaActionPerformed
       try{
        serverAddress = InetAddress.getLocalHost();
        connection = new Socket(serverAddress,port); 
        outSocket = connection.getOutputStream();
        streamOut= new PrintWriter(outSocket); 
        String aux;
        
       if(Maiuscolo.isSelected()){
            aux = "x";
            streamOut.println(aux);
            String richiesta = Invio.getText();   
            streamOut.println(richiesta); 
            streamOut.flush();
        }
       else{
            aux = "y";
            streamOut.println(aux);
            String richiesta = Invio.getText();   
            streamOut.println(richiesta); 
            streamOut.flush();
       }
        inSocket = connection.getInputStream();
        streamIn= new Scanner(inSocket);
        String risp= streamIn.nextLine()+"\n";
        Ricezione.append(risp);
        streamIn.close();
        connection.close();
        }catch(IOException e){System.err.println(e);}
    }//GEN-LAST:event_InviaActionPerformed

    private void CancellaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancellaActionPerformed
       Ricezione.setText("");
       Invio.setText("");
    }//GEN-LAST:event_CancellaActionPerformed

    private void InviaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InviaKeyPressed
     
    }//GEN-LAST:event_InviaKeyPressed

    private void MaiuscoloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaiuscoloActionPerformed

    }//GEN-LAST:event_MaiuscoloActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pannello.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pannello.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pannello.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pannello.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pannello().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancella;
    private javax.swing.JButton Invia;
    public javax.swing.JTextField Invio;
    private javax.swing.JCheckBox Maiuscolo;
    private javax.swing.JTextArea Ricezione;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
