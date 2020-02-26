package com.hw.airport.GUI;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WelcomeWindow extends JFrame {

	private JButton psngrBtn = new JButton();

	private JPanel contentPanel;

	public WelcomeWindow() {

		contentPanel = new javax.swing.JPanel();
		psngrBtn = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		contentPanel.setBackground(new java.awt.Color(240, 255, 255));
		contentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Welcome to the Check In", 0, 0,
				new java.awt.Font("Helvetica", 1, 14))); // NOI18N
		contentPanel.setLayout(null);

		psngrBtn.setText("Check In");
		psngrBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				psngrBtnActionPerformed(evt);
			}
		});
		contentPanel.add(psngrBtn);
		psngrBtn.setBounds(130, 100, 130, 30);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
	}

	private void psngrBtnActionPerformed(ActionEvent evt) {

		SearchScreen obj = new SearchScreen();
		obj.setVisible(true);
		this.setVisible(false);
	}

}
