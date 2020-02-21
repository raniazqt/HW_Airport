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
		

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(240, 255, 255));
		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Welcome to the Check In", 0, 0,
				new java.awt.Font("Helvetica", 1, 14))); // NOI18N
		jPanel1.setLayout(null);

		jButton1.setText("Check In");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});
		jPanel1.add(jButton1);
		jButton1.setBounds(130, 100, 130, 30);

	
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
	 * 
	 * 
	 * private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) { //
	 * GEN-FIRST:event_jButton5ActionPerformed // Handling code here for the
	 * FullDetails object:
	 * 
	 * DisplayPaymentWindow obj = new DisplayPaymentWindow(); obj.setVisible(true);
	 * this.setVisible(false); } // GEN-LAST:event_jButton5ActionPerformed
	 * 
	 * 
	 * 
	 * private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) { //
	 * GEN-FIRST:event_jButton7ActionPerformed // Handling code here for the Manager
	 * object:
	 * 
	 * Manager obj = new Manager(); obj.setVisible(true); this.setVisible(false); }
	 * // GEN-LAST:event_jButton7ActionPerformed
	 */

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new DisplayWelcomeScreen().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	// GEN-BEGIN:variables

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton7;
	private javax.swing.JPanel jPanel1;
	// End of variables declaration
	// GEN-END:variables
}
