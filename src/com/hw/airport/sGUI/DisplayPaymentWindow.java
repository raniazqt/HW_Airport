package com.hw.airport.sGUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/*
 * @author Simon Grange, Safa Al Ameri, 
 */

	public class DisplayPaymentWindow extends javax.swing.JFrame {

    /**
     * Creates new 'Welcome screen' form FullDetails
     */
    public DisplayPaymentWindow() {
        initPaymentWindow();
    }
    
    public DisplayPaymentWindow(Integer pno) {
        initPaymentWindow();
        
        Pno.setText(pno.toString());
        
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
                    JOptionPane.showMessageDialog(null, "No Passenger Booking Found! Please try again");
                }else{
                    
                    Pno.setText(parts[0]);
                    Name.setText(parts[1]);
                    Email.setText(parts[2]);
                    Weight.setText(parts[3]);
                    Country.setText(parts[4]);
                    Category.setSelectedItem(parts[5]);
                    Level.setSelectedItem(parts[6]);
                    
                    

                }

            }catch(IOException ex1){

                JOptionPane.showMessageDialog(null, "No Passenger Booking Found! This is often a typing error. Please try again");
            }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * The content of this method is always regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Constructor - creating objects for Full details form
    private void initPaymentWindow() {

        JPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Name    = new javax.swing.JTextField();
        Email   = new javax.swing.JTextField();
        Submit  = new javax.swing.JButton();
        db      = new javax.swing.JLabel();
        Category= new javax.swing.JComboBox<>();
        Level   = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        Pno     = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Country = new javax.swing.JTextField();
        jButton1= new javax.swing.JButton();
        Weight     = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(240, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Please Pay Here", 0, 0, new java.awt.Font("Helvetica", 1, 14))); 
        // NOI18N

        jLabel3.setFont(new java.awt.Font("Helvetica", 1, 14)); 
        // NOI18N
        
        jLabel3.setText("Last Name");

        jLabel4.setFont(new java.awt.Font("Helvetica", 1, 14)); 
        // NOI18N
        
        jLabel4.setText("Email");

        jLabel5.setFont(new java.awt.Font("Helvetica", 1, 14)); 
        // NOI18N
        
        jLabel5.setText("Total Charge");

        jLabel6.setFont(new java.awt.Font("Helvetica", 1, 14)); 
        // NOI18N
        
        jLabel6.setText("Baggage Checked In");

        Name.setEditable(false);
        
        Name.setFont(new java.awt.Font("Helvetica", 0, 14)); 
        // NOI18N
        
        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });

        Email.setEditable(false);
        Email.setFont(new java.awt.Font("Helvetica", 0, 14)); 
        // NOI18N
        
        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });

        // Needs to link to screen 2 - 
        Submit.setText("Confirm");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });

        db.setFont(new java.awt.Font("Helvetica", 1, 14)); 
        // NOI18N
        
        db.setText("Weight");

        Category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "First Class", "Business", "Cattle Class" }));
        Category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategorieActionPerformed(evt);
            }
        });

        Level.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Checked In - No Excess Fees", 
        		"Checked In - Paid Excess Fees", "Checked In - Excess Fee to pay at counter ", "Need Assistance", "No Baggage to Check In" 
        		}));

        jLabel8.setFont(new java.awt.Font("Helvetica", 1, 14)); 
        // NOI18N
        
        jLabel8.setText("Passenger Booking Number");

        Pno.setFont(new java.awt.Font("Helvetica", 0, 14)); 
        // NOI18N
        
        Pno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CnoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Helvetica", 1, 14)); 
        // NOI18N
        
        jLabel9.setText("Oversize Baggage");

        Country.setEditable(false);
        
        Country.setFont(new java.awt.Font("Helvetica", 0, 14)); 
        // NOI18N
        
        Country.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CountryActionPerformed(evt);
            }
        });
        

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Weight.setEditable(false);
        Weight.setFont(new java.awt.Font("Helvetica", 0, 14)); 
        // NOI18N
        
        Weight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(jLabel8)
                .addGap(62, 62, 62)
                .addComponent(Pno, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Level, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(db, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(Weight, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Category, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Country, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(63, 63, 63)
                        .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addComponent(Pno, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Country, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(db)
                            .addComponent(Weight, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Level, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(Category, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addComponent(Submit, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        // Competitor Full Details form layout
        JPanel1.add(jPanel3);
        jPanel3.setBounds(0, 80, 1200, 360);

        jLabel2.setBackground(new java.awt.Color(240, 255, 255));
        jLabel2.setFont(new java.awt.Font("Helvetica", 3, 24)); 
        // NOI18N
        
        jLabel2.setText("Excess Baggage Payment Details");
        JPanel1.add(jLabel2);
        jLabel2.setBounds(250, 10, 360, 60);
        JPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 600, 0);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(JPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(JPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }
    	// </editor-fold>//GEN-END:initComponents

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {
    	//	event_NameActionPerformed
        
    }

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // Handling code here:
        
    }
    	//	event_EmailActionPerformed

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        // Handling code here:
        Manager obj = new Manager();
        obj.setVisible(true);
        this.setVisible(false);
        
    }
    	//	event_SubmitActionPerformed

    private void CategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategorieActionPerformed
        // Handling code here:
    }
    	//GEN-LAST:event_CategorieActionPerformed

    private void CnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CnoActionPerformed
        // Handling code here:
    }
    	//GEN-LAST:event_CnoActionPerformed

    private void CountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountryActionPerformed
        // Handling code here:
    }
    	//GEN-LAST:event_CountryActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Handling code here:
        
        if(Pno.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Enter Passenger Booking Number");
        }else{

          /*  PassengerSuperClass obj = new PassengerSuperClass();
            
            obj = obj.getFullDetails(Pno.getText());
            
            if(obj == null){}
            else{
            
            Integer c = obj.pno;
            		Pno.setText(c.toString());
                    Name.setText(obj.name);
                    Email.setText(obj.email);
                    Weight.setText(obj.DOB);
                    Country.setText(obj.country);
                    Level.setSelectedItem(obj.level);
                    Category.setSelectedItem(obj.category);
            
            }*/
        }
        
    }
    	//GEN-LAST:event_jButton1ActionPerformed

    private void AgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgeActionPerformed
        // Handling code here:
    }
    	//GEN-LAST:event_AgeActionPerformed

    	// Variables declaration - do not modify//GEN-BEGIN:variables
    
    private javax.swing.JTextField Weight;
    private javax.swing.JComboBox<String> Category;
    private javax.swing.JTextField Pno;
    private javax.swing.JTextField Country;
    private javax.swing.JTextField Email;
    private javax.swing.JPanel JPanel1;
    private javax.swing.JComboBox<String> Level;
    private javax.swing.JTextField Name;
    private javax.swing.JButton Submit;
    private javax.swing.JLabel db;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
