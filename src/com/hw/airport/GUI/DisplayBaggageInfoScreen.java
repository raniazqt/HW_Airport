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

	private javax.swing.JTextField Weight;

	private javax.swing.JLabel Category;
	private javax.swing.JTextField Height;
	private javax.swing.JTextField Width;
	private javax.swing.JComboBox<String> FeesToPay;
	private javax.swing.JTextField Length;
	private javax.swing.JButton Submit;
	private javax.swing.JButton Calc;

	
	private javax.swing.JLabel tleLbl;
	private javax.swing.JLabel lenLbl;
	private javax.swing.JLabel weiLbl;
	private javax.swing.JLabel heiLbl;
	private javax.swing.JLabel feeLbl;
	private javax.swing.JLabel widLbl;
	
	
	private javax.swing.JPanel outPnl;
	private javax.swing.JPanel midPnl;
	private javax.swing.JPanel inPnl;
	
	private static final long serialVersionUID = 1L;

	/**
	 * Creates new form Registration for baggage check in
	 */
	public DisplayBaggageInfoScreen() {

		outPnl = new javax.swing.JPanel();
		midPnl = new javax.swing.JPanel();
		inPnl = new javax.swing.JPanel();

		
		tleLbl = new javax.swing.JLabel();

		lenLbl = new javax.swing.JLabel();
		weiLbl = new javax.swing.JLabel();
		heiLbl = new javax.swing.JLabel();
		widLbl = new javax.swing.JLabel();
		feeLbl = new javax.swing.JLabel();
		
		

		Length = new javax.swing.JTextField();
		Width = new javax.swing.JTextField();
		Height = new javax.swing.JTextField();
		Weight = new javax.swing.JTextField();

		Submit = new javax.swing.JButton();
		Calc = new javax.swing.JButton();

		Category = new javax.swing.JLabel();
		FeesToPay = new javax.swing.JComboBox<>();
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		outPnl.setLayout(null);

		midPnl.setLayout(null);

		// Main panel pale blue background
		inPnl.setBackground(new java.awt.Color(240, 255, 255));
		inPnl.setBorder(javax.swing.BorderFactory.createTitledBorder(null,
				"Please complete the information about your baggage", 0, 0, new java.awt.Font("Helvetica", 1, 14))); // NOI18N

		lenLbl.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
		lenLbl.setText("Length");

		weiLbl.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
		weiLbl.setText("Weight");

		heiLbl.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
		heiLbl.setText("Height");
		
		widLbl.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
		widLbl.setText("Width");

		feeLbl.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
		feeLbl.setText("Fees To Pay (GBP) ");

		
		Length.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
		Width.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
		Height.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
		Weight.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
		
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


		FeesToPay.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Pay Excess Baggage Fees", "No Baggage to Check In" }));

	

		javax.swing.GroupLayout inPnlLayout = new javax.swing.GroupLayout(inPnl);
		inPnl.setLayout(inPnlLayout);
		inPnlLayout.setHorizontalGroup(inPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(inPnlLayout.createSequentialGroup().addGap(191, 191, 191).addGap(62, 62, 62)
						.addGap(0, 0, Short.MAX_VALUE))
				.addGroup(inPnlLayout.createSequentialGroup().addContainerGap()
						.addGroup(inPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(inPnlLayout.createSequentialGroup().addGroup(inPnlLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addGroup(inPnlLayout.createSequentialGroup().addComponent(feeLbl)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(FeesToPay, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(inPnlLayout.createSequentialGroup()
												.addComponent(Calc, javax.swing.GroupLayout.PREFERRED_SIZE, 77,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(173, 173, 173))
										.addGroup(inPnlLayout.createSequentialGroup()
												.addComponent(widLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 49,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(59, 59, 59)
												.addComponent(Width, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGroup(inPnlLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(inPnlLayout.createSequentialGroup().addGap(106, 106, 106)
														
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43,
																Short.MAX_VALUE)
														.addGroup(inPnlLayout
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
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inPnlLayout
														.createSequentialGroup()
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(Submit, javax.swing.GroupLayout.PREFERRED_SIZE,
																77, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(52, 52, 52))))
								.addGroup(inPnlLayout.createSequentialGroup().addGap(33).addComponent(lenLbl)
										.addGap(63, 63, 63)
										.addComponent(
												Length, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(106, 106, 106)
										.addGroup(inPnlLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(inPnlLayout
														.createSequentialGroup().addComponent(heiLbl)
														.addGap(0, 0, Short.MAX_VALUE))
												.addGroup(inPnlLayout.createSequentialGroup().addComponent(weiLbl)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(Weight, javax.swing.GroupLayout.PREFERRED_SIZE,
																200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
						.addContainerGap()));
		
		
		inPnlLayout
				.setVerticalGroup(inPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(inPnlLayout.createSequentialGroup().addGroup(
								inPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(inPnlLayout.createSequentialGroup().addGap(23, 23, 23)))
								.addGroup(inPnlLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(
												inPnlLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
														.addGroup(inPnlLayout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(feeLbl).addComponent(FeesToPay,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 30,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(Category,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 30,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(81, 81, 81))
										.addGroup(inPnlLayout.createSequentialGroup().addGroup(inPnlLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(lenLbl).addComponent(
														Length, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(weiLbl).addComponent(Weight,
														javax.swing.GroupLayout.PREFERRED_SIZE, 32,
														javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(inPnlLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(inPnlLayout.createSequentialGroup()
																.addGap(31, 31, 31)
																.addGroup(inPnlLayout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(widLbl).addComponent(Width,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				32,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(inPnlLayout.createSequentialGroup()
																.addGap(20, 20, 20)
																.addGroup(inPnlLayout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(heiLbl).addComponent(Height,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				32,
																				javax.swing.GroupLayout.PREFERRED_SIZE))))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														144, Short.MAX_VALUE)))
								.addGroup(inPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(Submit, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
										.addComponent(Calc, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
										)
								.addContainerGap()));

		midPnl.add(inPnl);
		inPnl.setBounds(30, 80, 760, 360);

		tleLbl.setBackground(new java.awt.Color(240, 255, 255));
		tleLbl.setFont(new java.awt.Font("Helvetica", 3, 16)); // NOI18N
		tleLbl.setText("Baggage Check In Information");
		midPnl.add(tleLbl);
		tleLbl.setBounds(0, 10, 360, 60);
		
		outPnl.add(midPnl);
		midPnl.setBounds(0, 0, 810, 500);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(outPnl, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(outPnl, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE));

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

				WelcomeWindow obj = new WelcomeWindow();
				obj.setVisible(true);
				this.setVisible(false);

			}

		}

	}// GEN-LAST:event_SubmitActionPerformed

	private void CalcActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_CancelActionPerformed
		// TODO add your handling code here:

	}// GEN-LAST:event_CancelActionPerformed


}
