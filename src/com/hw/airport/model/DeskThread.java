package com.hw.airport.model;

import com.hw.airport.config.AppContainer;
import com.hw.airport.enums.DESK_STATUS;
import com.hw.airport.exception.HWAirportException;
import com.hw.airport.service.CheckInSvc;
import com.hw.airport.service.DeskSvc;
import com.hw.airport.service.QueueSvc;

public class DeskThread extends Thread implements Runnable{

	private DeskSvc deskSvc = AppContainer.getDeskSvc();
	private QueueSvc queueSvc = AppContainer.getQueueSvc();
	private CheckInSvc checkinSvc = AppContainer.getCheckinSvc();
	
	private Desk desk;
	private String deskThreadName;

	 
	public DeskThread(Desk desk, String deskThreadName) {
		super();
		this.desk = desk;
		this.deskThreadName = deskThreadName;
	}
	public String getDeskThreadName() {
		return deskThreadName;
	}

	public void setDeskThreadName(String deskThreadName) {
		this.deskThreadName = deskThreadName;
	}

	public Desk getDesk() {
		return desk;
	}

	public void setDesk(Desk desk) {
		this.desk = desk;
	}


	@Override
	public void run() {
		System.out.println("Desk - " + this.deskThreadName + " - Start processing passengers from queue");
		//deskSvc.processPassengersQueue(desk);
		while (!desk.getStatus().equalsIgnoreCase(DESK_STATUS.CLOSED.toString())) {
			if (queueSvc.getQueueSize() == 0) {
				//close desk & stop thread
			}else {
				try {
					
					deskSvc.loadDesk(desk);
					System.out.println("Desk - " + desk.getThreadName() + " - processing passenger " 
							+ desk.getPassenger().getFullName());
					boolean checkinStatus = checkinSvc.doCheckIn(desk.getPassenger());
					try {
						
					//	Thread.currentThread();
						Thread.sleep(7000);
						if (checkinStatus) {
							System.out.println("Desk - " + desk.getThreadName() + " - processing passenger " 
									+ desk.getPassenger().getFullName() + " check in was completed successfully");
						}else {
							System.out.println("Desk - " + desk.getThreadName() + " - processing passenger " 
									+ desk.getPassenger().getFullName() + "check in was not successfull");
						}
						desk.setStatus(DESK_STATUS.AVAILABLE.toString());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (HWAirportException e) {
					e.printStackTrace();
				}
			}
		}
	
	}

}
