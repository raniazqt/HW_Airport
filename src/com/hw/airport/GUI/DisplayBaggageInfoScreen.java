package com.hw.airport.GUI;

import java.io.*;
import static java.lang.Integer.parseInt;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Simon Grange, Safa Al Ameri,
 */
@SuppressWarnings("unused")
public class DisplayBaggageInfoScreen extends javax.swing.JFrame {

	/**
	 * DisplayBaggageInfoScreen collects the necessary Baggage Check In Information
	 * for calculation of excess weight or size and so incurring excess charges.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates new form Registration for baggage check in
	 */
	public DisplayBaggageInfoScreen() {

		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jPanel3 = new javax.swing.JPanel();

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();

		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();

		Length = new javax.swing.JTextField();
		Width = new javax.swing.JTextField();
		Height = new javax.swing.JTextField();
		Weight = new javax.swing.JTextField();

		Submit = new javax.swing.JButton();
		Calc = new javax.swing.JButton();

		Category = new javax.swing.JComboBox<>();
		FeesToPay = new javax.swing.JComboBox<>();

		jLabel9 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setLayout(null);

		jPanel2.setLayout(null);

		// Main panel pale blue background
		jPanel3.setBackground(new java.awt.Color(240, 255, 255));
		jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null,
				"Please complete the information about your baggage", 0, 0, new java.awt.Font("Helvetica", 1, 14))); // NOI18N

		jLabel3.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
		jLabel3.setText("Length");

		jLabel4.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
		jLabel4.setText("Weight");

		jLabel5.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
		jLabel5.setText("Height");

		jLabel6.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
		jLabel6.setText("Fees To Pay (GBP) ");

		jLabel7.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
		jLabel7.setText("Width");

		Length.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N

		Width.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N

		Submit.setText("Submit");
		Submit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SubmitActionPerformed(evt);
			}
		});

		Calc.setText("Fee:");
		Calc.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CalcActionPerformed(evt);
			}
		});

		Category.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "First Class", "Business Class", "Economy Class" }));

		FeesToPay.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Pay Excess Baggage Fees", "No Baggage to Check In" }));

		jLabel9.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
		jLabel9.setText("Class");

		Height.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N

		Weight.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addGap(191, 191, 191).addGap(62, 62, 62)

						.addGap(0, 0, Short.MAX_VALUE))
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addGroup(jPanel3Layout.createSequentialGroup().addComponent(jLabel6)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(FeesToPay, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(jPanel3Layout.createSequentialGroup()
												.addComponent(Calc, javax.swing.GroupLayout.PREFERRED_SIZE, 77,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(173, 173, 173).addComponent(jLabel8))
										.addGroup(jPanel3Layout.createSequentialGroup()
												.addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(59, 59, 59)
												.addComponent(Weight, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGroup(jPanel3Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanel3Layout.createSequentialGroup().addGap(106, 106, 106)
														.addComponent(jLabel9)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43,
																Short.MAX_VALUE)
														.addGroup(jPanel3Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(Category,
																		javax.swing.GroupLayout.Alignment.TRAILING,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 200,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(Height,
																		javax.swing.GroupLayout.Alignment.TRAILING,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 200,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout
														.createSequentialGroup()
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(Submit, javax.swing.GroupLayout.PREFERRED_SIZE,
																77, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(52, 52, 52))))
								.addGroup(jPanel3Layout.createSequentialGroup().addGap(33).addComponent(jLabel3)
										.addGap(63, 63, 63)
										.addComponent(
												Length, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(106, 106, 106)
										.addGroup(jPanel3Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanel3Layout
														.createSequentialGroup().addComponent(jLabel5)
														.addGap(0, 0, Short.MAX_VALUE))
												.addGroup(jPanel3Layout.createSequentialGroup().addComponent(jLabel4)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(Width, javax.swing.GroupLayout.PREFERRED_SIZE,
																200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
						.addContainerGap()));
		jPanel3Layout
				.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel3Layout.createSequentialGroup().addGroup(
								jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel3Layout.createSequentialGroup().addGap(23, 23, 23)))
								.addGroup(jPanel3Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(
												jPanel3Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
														.addGroup(jPanel3Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(jLabel6).addComponent(FeesToPay,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 30,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(jLabel9).addComponent(Category,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 30,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(81, 81, 81))
										.addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel3).addComponent(
														Length, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel4).addComponent(Width,
														javax.swing.GroupLayout.PREFERRED_SIZE, 32,
														javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(jPanel3Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(jPanel3Layout.createSequentialGroup()
																.addGap(31, 31, 31)
																.addGroup(jPanel3Layout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(jLabel7).addComponent(Weight,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				32,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(jPanel3Layout.createSequentialGroup()
																.addGap(20, 20, 20)
																.addGroup(jPanel3Layout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(jLabel5).addComponent(Height,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				32,
																				javax.swing.GroupLayout.PREFERRED_SIZE))))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														144, Short.MAX_VALUE)))
								.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(Submit, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
										.addComponent(Calc, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
										.addComponent(jLabel8))
								.addContainerGap()));

		jPanel2.add(jPanel3);
		jPanel3.setBounds(30, 80, 760, 360);

		jLabel2.setBackground(new java.awt.Color(240, 255, 255));
		jLabel2.setFont(new java.awt.Font("Helvetica", 3, 16)); // NOI18N
		jLabel2.setText("Baggage Check In Information");
		jPanel2.add(jLabel2);
		jLabel2.setBounds(0, 10, 360, 60);
		jPanel2.add(jLabel1);
		jLabel1.setBounds(0, 0, 600, 0);

		jPanel1.add(jPanel2);
		jPanel2.setBounds(0, 0, 810, 500);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_SubmitActionPerformed
		// TODO add your handling code here:

		if (Length.getText().isEmpty() || Length.getText().charAt(0) == ' ') {
			JOptionPane.showMessageDialog(null, "Please Enter Baggage Length (cm) ");
		} else if (Width.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Enter Baggage Width (cm) ");
		} else if (Height.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Enter Baggage Height (cm) ");
		} else if (Weight.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Enter Baggage Weight (Kg) ");
		} else {

			boolean flag;
			String c = "";

			// Validation of email and category

			int chk = 0;

			String f = null;

			if (chk == 1) {
				JOptionPane.showMessageDialog(null, "Another Passenger with this Email is already Selected!!");
			}

			else {

				JOptionPane.showMessageDialog(null, "Check-In Successful");

				DisplayWelcomeScreen obj = new DisplayWelcomeScreen();
				obj.setVisible(true);
				this.setVisible(false);

			}

		}

	}// GEN-LAST:event_SubmitActionPerformed

	private void CalcActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_CancelActionPerformed
		// TODO add your handling code here:

	}// GEN-LAST:event_CancelActionPerformed

	
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTextField Weight;

	private javax.swing.JComboBox<String> Category;
	private javax.swing.JTextField Height;
	private javax.swing.JTextField Width;
	private javax.swing.JComboBox<String> FeesToPay;
	private javax.swing.JTextField Length;
	private javax.swing.JButton Submit;
	private javax.swing.JButton Calc;

	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	// End of variables declaration//GEN-END:variables
}
