package com.hw.airport.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import java.awt.Color;
import java.awt.Font;

public class WelcomeWindow extends JFrame {

	private JButton psngrBtn = new JButton();

	private JPanel contentPanel;

	public WelcomeWindow() {

		contentPanel = new JPanel();
		psngrBtn = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		contentPanel.setBackground(new Color(240, 255, 255));
		contentPanel.setBorder(BorderFactory.createTitledBorder(null, "Welcome to the Check In", 0, 0,
				new Font("Helvetica", 1, 14))); // NOI18N
		contentPanel.setLayout(null);

		psngrBtn.setText("Check In");
		psngrBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				psngrBtnActionPerformed(evt);
			}
		});
		contentPanel.add(psngrBtn);
		psngrBtn.setBounds(130, 100, 130, 30);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(
				contentPanel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(
				contentPanel, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE));

		pack();
	}

	private void psngrBtnActionPerformed(ActionEvent evt) {

		SearchScreen obj = new SearchScreen();
		obj.setVisible(true);
		this.setVisible(false);
	}

}
