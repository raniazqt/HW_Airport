package com.hw.airport.GUI_S2;

import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hw.airport.config.AppContainer;
import com.hw.airport.config.PassengerPanelSettings;
import com.hw.airport.model.Booking;
import com.hw.airport.service.GUISvc;

public class PassengerPanel extends JPanel implements GUIElement<JPanel>
{
	private PassengerPanelSettings guiSettings;
	private JTable passengerJTable = new JTable();
	private List<Booking> passengersList;
	private GUISvc guiSvc = AppContainer.getGuiSvc();

	final Class[] columnClass = new Class[] {
			String.class, String.class, String.class, Double.class, Double.class
	};
	String[] columnNames = {"Name",
			"Booking#",
			"Flight# ",
			"Bag Weight",
	"Bag Volume"};

	DefaultTableModel model = new DefaultTableModel();
		
	public PassengerPanel(PassengerPanelSettings guiSettings)
	{
		this.guiSettings = guiSettings;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	@Override
	public JPanel getSelf(){
		return this;
	}

	@Override
	public void draw()
	{
	//	getDataModel();

		JScrollPane scrollPane = new JScrollPane(passengerJTable);
		scrollPane.setBorder(guiSettings.BorderType);
		scrollPane.setBackground(guiSettings.LabelColor);
		this.add(scrollPane);

	}

	private void getDataModel() {
		passengersList = guiSvc.getQueuePassengersList();
		synchronized (passengersList) {
			Object[][] data = new Object[passengersList.size()][5];
			int i = 0;
			for(Booking booking : passengersList){
				data[i][0] = booking.getFullName();
				data[i][1] = booking.getRefCode();
				data[i][2] = booking.getFlightCode();
				data[i][3] = booking.getTotalBaggageWeight();
				data[i][4] = booking.getTotalBaggageVolume();
				i++;
			}
			model.setDataVector(data, columnNames);
			
		}
		passengerJTable.setModel(model);

		this.passengerJTable.setBorder(guiSettings.BorderType);
		this.passengerJTable.setBackground(guiSettings.BackGroundColor);
		this.passengerJTable.setFont(guiSettings.LabelFont);
		this.passengerJTable.setForeground(guiSettings.LabelColor);

	}

	@Override
	public void update(Object targetObj){		
		this.getDataModel();
	}

	@Override
	public void refreshGUI(Object targetObj) {
		// TODO Auto-generated method stub

	}

}

