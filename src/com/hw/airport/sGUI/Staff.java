package com.hw.airport.sGUI;

/**
*
* @author simon grange
*/
public class Staff extends javax.swing.JFrame {

   /**
    * Creates new form Staff
    */
   public Staff() {

       jButton4 = new javax.swing.JButton();
       jPanel1 = new javax.swing.JPanel();
       jButton1 = new javax.swing.JButton();
       jButton2 = new javax.swing.JButton();
       jButton3 = new javax.swing.JButton();
       jButton5 = new javax.swing.JButton();
       jButton6 = new javax.swing.JButton();
       jButton7 = new javax.swing.JButton();

       jButton4.setText("jButton4");

       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

       jPanel1.setLayout(null);
       jPanel1.setBackground(new java.awt.Color(120, 255, 200));

       jButton1.setText("Add CheckIn");
       jButton1.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton1ActionPerformed(evt);
           }
       });
       jPanel1.add(jButton1);
       jButton1.setBounds(60, 180, 130, 30);

       jButton2.setText("Update CheckIn");
       jButton2.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton2ActionPerformed(evt);
           }
       });
       jPanel1.add(jButton2);
       jButton2.setBounds(220, 180, 130, 30);

       jButton3.setText("Report");
       jButton3.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton3ActionPerformed(evt);
           }
       });
       jPanel1.add(jButton3);
       jButton3.setBounds(380, 180, 130, 30);

       jButton5.setText("Full Details");
       jButton5.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton5ActionPerformed(evt);
           }
       });
       jPanel1.add(jButton5);
       jButton5.setBounds(60, 250, 130, 30);

       jButton6.setText("Short Details");
       jButton6.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton6ActionPerformed(evt);
           }
       });
       jPanel1.add(jButton6);
       jButton6.setBounds(220, 250, 130, 30);

       jButton7.setText("Home");
       jButton7.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               jButton7ActionPerformed(evt);
           }
       });
       jPanel1.add(jButton7);
       jButton7.setBounds(380, 250, 130, 30);

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(0, 0, Short.MAX_VALUE))
       );
       //jPanel1.setBackground(new java.awt.Color(102, 1205, 170));
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(0, 0, Short.MAX_VALUE))
       );

       pack();
   
   }

   

   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // TODO add your handling code here:
       AddPassenger obj = new AddPassenger();
       obj.setVisible(true);
       this.setVisible(false);
   }//GEN-LAST:event_jButton1ActionPerformed

   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       // TODO add your handling code here:
      
      
       this.setVisible(false);
   }//GEN-LAST:event_jButton2ActionPerformed

   private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       // TODO add your handling code here:
       DisplayCheckInConfirmationScreen obj = new DisplayCheckInConfirmationScreen();
       obj.setVisible(true);
       this.setVisible(false);
   }//GEN-LAST:event_jButton3ActionPerformed

   private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       // TODO add your handling code here:
      
   }//GEN-LAST:event_jButton5ActionPerformed

   private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       // TODO add your handling code here:
       DisplaySearchScreen obj = new DisplaySearchScreen();
       obj.setVisible(true);
       this.setVisible(false);
   }//GEN-LAST:event_jButton6ActionPerformed

   private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       // TODO add your handling code here:
       
   }//GEN-LAST:event_jButton7ActionPerformed

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
           java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (javax.swing.UnsupportedLookAndFeelException ex) {
           java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
       //</editor-fold>

       /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
               new Staff().setVisible(true);
           }
       });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton jButton1;
   private javax.swing.JButton jButton2;
   private javax.swing.JButton jButton3;
   private javax.swing.JButton jButton4;
   private javax.swing.JButton jButton5;
   private javax.swing.JButton jButton6;
   private javax.swing.JButton jButton7;
   private javax.swing.JPanel jPanel1;
   // End of variables declaration//GEN-END:variables
}
