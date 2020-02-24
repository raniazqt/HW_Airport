package com.hw.airport.GUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * @author Simon Grange, Safa Al Ameri, 
 */

public class AddPassenger extends javax.swing.JFrame {

    /**
     * Creates new form AddPassenger
     */
	
    public AddPassenger() {

        jPanel1 = new javax.swing.JPanel();
        // 
        jPanel3 = new javax.swing.JPanel();
        //
        jLabel3 = new javax.swing.JLabel();
        // Name button
        jLabel4 = new javax.swing.JLabel();
        //
        jLabel5 = new javax.swing.JLabel();
        // Game 4 button
        Submit = new javax.swing.JButton();
        // Submit button
        jLabel7 = new javax.swing.JLabel();
        //
        Cancel = new javax.swing.JButton();
        //
        jLabel8 = new javax.swing.JLabel();
        //
        Pno = new javax.swing.JTextField();
        //Competitor Number field
        jButton1 = new javax.swing.JButton();
        //
        jComboBox1 = new javax.swing.JComboBox<>();
        //
        jComboBox2 = new javax.swing.JComboBox<>();
        //
        jComboBox3 = new javax.swing.JComboBox<>();
        //
        jComboBox4 = new javax.swing.JComboBox<>();
        // jComboBox5 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        //
        Name = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(240, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add A New Passenger", 0, 0, new java.awt.Font("Helvetica", 1, 14))); // NOI18N
        jPanel3.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel3.setText("Last Name");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(100, 120, 45, 22);
        /*
        jLabel4.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel4.setText("Game 1");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(450, 180, 60, 22);
 		*/ 
      
        jLabel4.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel4.setText("Flight Number");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(450, 180, 60, 22);
        /*
        jLabel5.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel5.setText("PAssenger Q1");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(450, 240, 60, 22); 
       */ 
        jLabel5.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel5.setText("Passenger Q2");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(450, 240, 60, 22);
        
        jLabel5.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel6.setText("Passenger Q3");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(450, 240, 60, 22);
        
        // jLabel5.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        // jLabel6.setText("Passenger Q4");
        // jPanel3.add(jLabel5);
        // jLabel5.setBounds(450, 240, 60, 22);
        
        jLabel7.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel7.setText("Pieces of Baggage");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(100, 230, 143, 22);

        Submit.setText("Add");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });
        jPanel3.add(Submit);
        Submit.setBounds(625, 303, 77, 39);

        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });
        jPanel3.add(Cancel);
        Cancel.setBounds(74, 303, 77, 39);

        jLabel8.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel8.setText("Passenger Booking Number");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(90, 50, 130, 22);

        Pno.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        Pno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CnoActionPerformed(evt);
            }
        });
        jPanel3.add(Pno);
        Pno.setBounds(240, 50, 160, 32);

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(540, 40, 91, 36);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        jPanel3.add(jComboBox1);
        jComboBox1.setBounds(240, 170, 160, 40);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        jPanel3.add(jComboBox2);
        jComboBox2.setBounds(540, 170, 160, 40);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        jPanel3.add(jComboBox3);
        jComboBox3.setBounds(240, 230, 160, 40);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        jPanel3.add(jComboBox4);
        jComboBox4.setBounds(540, 230, 160, 40);

      //  jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
      //  jPanel3.add(jComboBox5);
      //  jComboBox5.setBounds(540, 230, 160, 40);
        
        jLabel6.setFont(new java.awt.Font("Helvetica", 1, 14)); 
        
        // NOI18N
        jLabel6.setText("Class");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(100, 180, 60, 22);

        Name.setEditable(false);
        Name.setFont(new java.awt.Font("Helvetica", 0, 14)); 
        
        // NOI18N
        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });
        jPanel3.add(Name);
        Name.setBounds(400, 120, 190, 32);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(30, 80, 760, 360);
        jPanel3.getAccessibleContext().setAccessibleName("Add New Passenger");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );

        pack();
        
        Submit.setVisible(false);
        
    }

  

    
    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {
    	//	GEN-FIRST:event_SubmitActionPerformed
        // 	Handling code
        
        try{
            
            Integer array[] = {Integer.parseInt(jComboBox1.getSelectedItem().toString()),Integer.parseInt(jComboBox2.getSelectedItem().toString()),Integer.parseInt(jComboBox3.getSelectedItem().toString()),Integer.parseInt(jComboBox4.getSelectedItem().toString())};
                  
                FileWriter fout;

                fout = new FileWriter("PassengersCheckedIn.txt",true); 
                
                fout.write(Pno.getText()+","+Name.getText()+","+array[0]+","+array[1]+","+array[2]+","+array[3]);
                
                fout.write(System.lineSeparator());
                fout.close();

                JOptionPane.showMessageDialog(null, "Added Successfully");

                WelcomeWindow obj = new WelcomeWindow();
                obj.setVisible(true);
                this.setVisible(false);
            
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_SubmitActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        
    	// Handling code
    	
        WelcomeWindow obj = new WelcomeWindow();
        obj.setVisible(true);
        this.setVisible(false);
    }
    //GEN-LAST:event_CancelActionPerformed

    private void CnoActionPerformed(java.awt.event.ActionEvent evt) {
    	//GEN-FIRST:event_CnoActionPerformed
        //Handling code 
    }
    	//GEN-LAST:event_CnoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	//	GEN-FIRST:event_jButton1ActionPerformed
        // 	Handling code 
        
        if(Pno.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Enter Passenger Booking Number");
        }else{
            
             try{
            
            FileReader fr = new FileReader("Passengers.txt");
            BufferedReader br = new BufferedReader(fr);
                    
                String f = null;
                String parts[]=null;
                while((f = br.readLine())!=null){
                    parts = f.split(",");
                    if(parts[0].equals(Pno.getText()))
                        break;
                }
                fr.close();
                br.close();
                if(f==null){
                    JOptionPane.showMessageDialog(null, "No Competitor Found!");
                }else{
                    Name.setText(parts[1]);
                    Pno.setEditable(false);
                    
                    try{
                        
                                            
                    fr = new FileReader("CheckIn.txt");
                    br = new BufferedReader(fr);
                    
                    boolean flag = false;
                    
                while((f = br.readLine())!=null){
                    parts = f.split(",");
                    if(parts[0].equals(Pno.getText())){
                        flag = true;
                        break;
                    }
                }
                fr.close();
                br.close();
                
                if(flag==true){
                    JOptionPane.showMessageDialog(null,"CheckIn already added!");
                    int i = Integer.parseInt(parts[2]);
                    jComboBox1.setSelectedIndex(i);
                    i = Integer.parseInt(parts[3]);
                    jComboBox2.setSelectedIndex(i);
                    i = Integer.parseInt(parts[4]);
                    jComboBox3.setSelectedIndex(i);
                    i = Integer.parseInt(parts[5]);
                    jComboBox4.setSelectedIndex(i);
                }else{
                    
                    Submit.setVisible(true);
                    JOptionPane.showMessageDialog(null,"Enter Scores!");
                }    
                    }catch(Exception ex3){
                                            Submit.setVisible(true);

                        JOptionPane.showMessageDialog(null,"Enter Scores!");

                    }

                }        
                        
            
        }catch(IOException ex1){
                   
                JOptionPane.showMessageDialog(null, "No Competitor Found!");
        }
            
        }
        
    }
    	//GEN-LAST:event_jButton1ActionPerformed

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {
    	//GEN-FIRST:event_NameActionPerformed
        // Handling code 
    	
    }
    	//GEN-LAST:event_NameActionPerformed

    
    	// Variables declaration - do not modify//GEN-BEGIN:variables
    
    private javax.swing.JButton Cancel;
    private javax.swing.JTextField Pno;
    private javax.swing.JTextField Name;
    private javax.swing.JButton Submit;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    //private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    
    // End of variables declaration//GEN-END:variables
}
