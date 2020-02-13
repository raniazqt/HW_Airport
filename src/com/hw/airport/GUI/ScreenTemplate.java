package com.hw.airport.GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScreenTemplate extends JFrame implements ActionListener {

	public void welcome(Container pane) {

		JPanel Banner = new JPanel();

		try {
			BufferedImage img = ImageIO.read(
					new File("C:\\Users\\Bruce-Inspiron\\Documents\\MS\\SEM2\\AS\\F21AS_CW\\HW_Airport\\img.png"));
			ImageIcon icon = new ImageIcon(img);
			Banner.add(new JLabel(icon));

		} catch (IOException e) {
			e.printStackTrace();
		}

		Banner.add(new JLabel("Welcome"));

		JPanel button = new JPanel();
		button.add(new JButton("Check In"));

		JPanel top = new JPanel(new CardLayout());
		top.add(Banner);
		JPanel bot = new JPanel();

		bot.add(button);

		pane.add(top, BorderLayout.CENTER);
		pane.add(bot, BorderLayout.PAGE_END);
	}

	public void checkIn(Container pane) {

		JPanel top = new JPanel();
		top.add(new JLabel("Check In"));

		JPanel mid = new JPanel();

		mid.setLayout(new BoxLayout(mid, BoxLayout.Y_AXIS));

		JPanel mid1 = new JPanel(new CardLayout());
		JPanel cen1 = new JPanel();

		cen1.add(new JLabel("Name"));
		cen1.add(new JTextField("Words Go here"));

		mid1.add(cen1);

		JPanel mid2 = new JPanel(new CardLayout());
		JPanel cen2 = new JPanel();

		cen2.add(new JLabel("Booking Reference"));
		cen2.add(new JTextField("Words Go here"));

		mid2.add(cen2);

		mid.add(mid1);
		mid.add(mid2);

		JPanel bot = new JPanel();
		bot.add(new JButton("Baggage Check"));

		pane.add(top, BorderLayout.PAGE_START);

		pane.add(mid, BorderLayout.CENTER);

		pane.add(bot, BorderLayout.PAGE_END);

	}

	public void baggage(Container pane) {

		JPanel top = new JPanel();
		top.add(new JLabel("Baggage Check"));

		JPanel mid = new JPanel();

		mid.setLayout(new BoxLayout(mid, BoxLayout.Y_AXIS));

		JPanel mid1 = new JPanel(new CardLayout());
		JPanel cen1 = new JPanel();

		cen1.add(new JLabel("Weight"));
		cen1.add(new JTextField("Meters"));

		mid1.add(cen1);

		JPanel mid2 = new JPanel(new CardLayout());
		JPanel cen2 = new JPanel();

		cen2.add(new JLabel("Height"));
		cen2.add(new JTextField("Meters"));

		mid2.add(cen2);

		JPanel mid3 = new JPanel(new CardLayout());
		JPanel cen3 = new JPanel();

		cen3.add(new JLabel("Length"));
		cen3.add(new JTextField("Meters"));

		mid3.add(cen3);

		JPanel mid4 = new JPanel(new CardLayout());
		JPanel cen4 = new JPanel();

		cen4.add(new JLabel("Breadth"));
		cen4.add(new JTextField("Meters"));

		mid4.add(cen4);

		mid.add(mid1);
		mid.add(mid2);
		mid.add(mid3);
		mid.add(mid4);

		JPanel bot = new JPanel();
		bot.add(new JButton("Baggage Eval"));

		pane.add(top, BorderLayout.PAGE_START);

		pane.add(mid, BorderLayout.CENTER);

		pane.add(bot, BorderLayout.PAGE_END);

	}

	public void fees(Container pane) {

		JPanel top = new JPanel();
		top.add(new JLabel("Excess Fees"));

		JPanel mid = new JPanel();

		mid.setLayout(new BoxLayout(mid, BoxLayout.Y_AXIS));

		JPanel mid1 = new JPanel(new CardLayout());
		JPanel cen1 = new JPanel();

		cen1.add(new JLabel("Weight Fees"));
		cen1.add(new JLabel("$XX"));

		mid1.add(cen1);

		JPanel mid2 = new JPanel(new CardLayout());
		JPanel cen2 = new JPanel();

		cen2.add(new JLabel("Volume Fees:"));
		cen2.add(new JLabel("$XX"));

		mid2.add(cen2);

		mid.add(mid1);
		mid.add(mid2);

		JPanel bot = new JPanel();
		bot.add(new JButton("Pay"));

		pane.add(top, BorderLayout.PAGE_START);

		pane.add(mid, BorderLayout.CENTER);

		pane.add(bot, BorderLayout.PAGE_END);

	}

	public void end(Container pane) {
		
		JPanel Banner = new JPanel();

		
		try {
			BufferedImage img = ImageIO.read(
					new File("C:\\Users\\Bruce-Inspiron\\Documents\\MS\\SEM2\\AS\\F21AS_CW\\HW_Airport\\img.png"));
			ImageIcon icon = new ImageIcon(img);
			Banner.add(new JLabel(icon));

		} catch (IOException e) {
			e.printStackTrace();
		}

		Banner.add(new JLabel("Welcome"));

		

		JPanel top = new JPanel();
		Banner.setLayout(new BoxLayout(Banner, BoxLayout.Y_AXIS));
		
		top.add(Banner);
		

		pane.add(top, BorderLayout.CENTER);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be invoked
	 * from the event dispatch thread.
	 */
	public static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("Check-In");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		ScreenTemplate demo = new ScreenTemplate();
		demo.end(frame.getContentPane());

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

}
