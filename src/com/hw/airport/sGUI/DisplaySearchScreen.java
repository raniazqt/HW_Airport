package com.hw.airport.sGUI;

import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author simon grange
 */
public class DisplaySearchScreen extends javax.swing.JFrame {

	/**
	 * Creates new form ShortDetails
	 */
	public DisplaySearchScreen() {

		JPanel1 = new javax.swing.JPanel();
		jPanel3 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		Name = new javax.swing.JTextField();
		PassengerCheckedIn = new javax.swing.JTextField();
		Submit = new javax.swing.JButton();
		jLabel8 = new javax.swing.JLabel();
		Pno = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		JPanel1.setLayout(null);

		jPanel3.setBackground(new java.awt.Color(240, 255, 255));
		jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Check In Here", 0, 0,
				new java.awt.Font("Helvetica", 1, 14))); // NOI18N

		jLabel3.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
		jLabel3.setText("Last Name");

		jLabel4.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
		jLabel4.setText("Flight Number");

		Name.setEditable(false);
		Name.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
		Name.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				NameActionPerformed(evt);
			}
		});

		PassengerCheckedIn.setEditable(false);
		PassengerCheckedIn.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
		PassengerCheckedIn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CheckInActionPerformed(evt);
			}
		});
		/*
		 * SHould point to the DisplayBaggageInfoScreen ? make actionPerformed PRIVATE
		 * as this class only
		 */
		Submit.setText("Next");
		Submit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SubmitActionPerformed(evt);
			}
		});

		jLabel8.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
		jLabel8.setText("Passenger Booking Number");

		Pno.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
		Pno.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CnoActionPerformed(evt);
			}
		});

		jButton1.setText("Search");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(jPanel3Layout.createSequentialGroup().addGap(115, 115, 115).addComponent(jLabel8))
						.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(jLabel3)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60,
										Short.MAX_VALUE)
								.addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel3Layout.createSequentialGroup().addGap(62, 62, 62)
										.addComponent(Pno, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59,
												Short.MAX_VALUE)
										.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(20, 20, 20))
								.addGroup(jPanel3Layout.createSequentialGroup().addGap(85, 85, 85).addComponent(jLabel4)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33,
												Short.MAX_VALUE)
										.addComponent(PassengerCheckedIn, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap())))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(Submit,
								javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(329, 329, 329)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jLabel8)
								.addComponent(Pno, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
								.addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(68, 68, 68)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3).addComponent(jLabel4).addComponent(PassengerCheckedIn,
										javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(38, 38, 38).addComponent(Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(47, Short.MAX_VALUE)));

		JPanel1.add(jPanel3);
		jPanel3.setBounds(30, 80, 820, 280);

		jLabel2.setBackground(new java.awt.Color(240, 255, 255));
		jLabel2.setFont(new java.awt.Font("Helvetica", 3, 36));
		// jLabel2.setFont(new java.awt.Color(0, 139, 139); // NOI18N
		jLabel2.setText("Welcome to Scotia Air");
		JPanel1.add(jLabel2);
		jLabel2.setBounds(200, 10, 400, 60);
		JPanel1.add(jLabel1);
		jLabel1.setBounds(0, 0, 600, 0);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 830, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(JPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 810,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 440, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(JPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 418,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));

		pack();
	}

	private void NameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_NameActionPerformed
		// TODO add your handling code here:

	}// GEN-LAST:event_NameActionPerformed

	private void CheckInActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ScoreActionPerformed
		// Handling code here:

	}// GEN-LAST:event_ScoreActionPerformed

	private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_SubmitActionPerformed
		// Handling code here:
		DisplayBaggageInfoScreen obj = new DisplayBaggageInfoScreen();
		obj.setVisible(true);
		this.setVisible(false);

	}// GEN-LAST:event_SubmitActionPerformed

	private void CnoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_CnoActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_CnoActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:

		if (Pno.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Enter Passenger Booking Number");
		} else {

			/*
			 * PassengerSubClass obj = new PassengerSubClass(); obj =
			 * obj.getShortDetails(Pno.getText()); if(obj==null){
			 * 
			 * }else{ Integer c = obj.pno; Pno.setText(c.toString());
			 * Name.setText(obj.name);
			 * 
			 * Double overallScore = obj.getOverallScore(obj.score);
			 * PassengerCheckedIn.setText(overallScore.toString());
			 */

		}

	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTextField Pno;
	private javax.swing.JPanel JPanel1;
	private javax.swing.JTextField Name;
	private javax.swing.JTextField PassengerCheckedIn;
	private javax.swing.JButton Submit;
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JPanel jPanel3;
	// End of variables declaration//GEN-END:variables
}