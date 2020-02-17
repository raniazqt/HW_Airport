package com.hw.airport.sGUI;

/**
 * @author Simon Grange, Safa Al Ameri,
 */
public class DisplayWelcomeScreen extends javax.swing.JFrame {

	/**
	 * Creates new form Competitor
	 */
	public DisplayWelcomeScreen() {
		jPanel1 = new javax.swing.JPanel();
		jButton1 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jButton7 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(240, 255, 255));
		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Welcome to the Check In", 0, 0,
				new java.awt.Font("Helvetica", 1, 14))); // NOI18N
		jPanel1.setLayout(null);

		/*
		 * jButton1.setText("Check In Baggage"); jButton1.addActionListener(new
		 * java.awt.event.ActionListener() { public void
		 * actionPerformed(java.awt.event.ActionEvent evt) {
		 * jButton1ActionPerformed(evt); } }); jPanel1.add(jButton1);
		 * jButton1.setBounds(60, 140, 130, 30);
		 * 
		 * jButton5.setText("Pay Excess Baggage"); jButton5.addActionListener(new
		 * java.awt.event.ActionListener() { public void
		 * actionPerformed(java.awt.event.ActionEvent evt) {
		 * jButton5ActionPerformed(evt); } }); jPanel1.add(jButton5);
		 * jButton5.setBounds(210, 80, 130, 30);
		 * 
		 */ jButton6.setText("Check In");
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});
		jPanel1.add(jButton6);
		jButton6.setBounds(60, 80, 130, 30);

		/*
		 * jButton7.setText("Home"); jButton7.addActionListener(new
		 * java.awt.event.ActionListener() { public void
		 * actionPerformed(java.awt.event.ActionEvent evt) {
		 * jButton7ActionPerformed(evt); } }); jPanel1.add(jButton7);
		 * jButton7.setBounds(210, 140, 130, 30);
		 */

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
	}


	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		// GEN-FIRST:event_jButton6ActionPerformed
		// Handling code here for the ShortDetails object:

		DisplaySearchScreen obj = new DisplaySearchScreen();
		obj.setVisible(true);
		this.setVisible(false);
	}
	// GEN-LAST:event_jButton6ActionPerformed
	/*

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// GEN-FIRST:event_jButton1ActionPerformed
		// Registration button creates new registrant

		DisplayBaggageInfoScreen obj = new DisplayBaggageInfoScreen();
		obj.setVisible(true);
		this.setVisible(false);

	}// GEN-LAST:event_jButton1ActionPerformed

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		// GEN-FIRST:event_jButton5ActionPerformed
		// Handling code here for the FullDetails object:

		DisplayPaymentWindow obj = new DisplayPaymentWindow();
		obj.setVisible(true);
		this.setVisible(false);
	}
	// GEN-LAST:event_jButton5ActionPerformed

	

	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
		// GEN-FIRST:event_jButton7ActionPerformed
		// Handling code here for the Manager object:

		Manager obj = new Manager();
		obj.setVisible(true);
		this.setVisible(false);
	}
	// GEN-LAST:event_jButton7ActionPerformed
*/




	// Variables declaration - do not modify
	// GEN-BEGIN:variables

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JPanel jPanel1;
	// End of variables declaration
	// GEN-END:variables
}
