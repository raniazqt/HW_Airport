package com.hw.airport.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomeWindow extends JFrame{
	private JButton staffBtn = new JButton();
	private JButton psngrBtn = new JButton();
	private JButton closeBtn = new JButton();
	private JPanel contentPanel = GUIUtil.getContentPanel();

	public WelcomeWindow() {

		ImageIcon image = new ImageIcon("./resources/images/airport_pic.png");
		JLabel label = new JLabel();
		label.setIcon(image);
		contentPanel.add(label);
		label.setBounds(0, 0, image.getIconWidth(), 450);

		staffBtn.setText("Staff");
		

		contentPanel.add(staffBtn);
		staffBtn.setBounds(20, 450, 100, 40);

		psngrBtn.setText("Passenger");
		psngrBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				openSerchWindow(evt);
			}
		});
		contentPanel.add(psngrBtn);
		psngrBtn.setBounds(200, 450, 100, 40);

		closeBtn.setText("Close Program");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				closeActionPerformed(evt);
			}
		});
		contentPanel.add(closeBtn);
		closeBtn.setBounds(320, 450, 140, 40);

		JPanel footer = GUIUtil.getFooterPanel();
		JPanel header = GUIUtil.getHeader();

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(header, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
				.addComponent(footer, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(header, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
						.addComponent(footer, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));

		pack();
		setVisible(true);
	}

	private void openSerchWindow(ActionEvent evt) {
		SearchScreen obj = new SearchScreen();
	}
	private void closeActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

}
