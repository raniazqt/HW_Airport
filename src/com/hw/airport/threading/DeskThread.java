package com.hw.airport.threading;

import com.hw.airport.config.AirportSimulator;
import com.hw.airport.config.AppContainer;
import com.hw.airport.enums.DESK_STATUS;
import com.hw.airport.exception.HWAirportException;
import com.hw.airport.model.Booking;
import com.hw.airport.model.Desk;
import com.hw.airport.service.CheckInSvc;

public class DeskThread extends Thread implements Runnable{

	//private QueueSvc queueSvc = AppContainer.getQueueSvc();
	private CheckInSvc checkinSvc = AppContainer.getCheckinSvc();
	private DeskManager deskManager = AppContainer.getDeskManager();

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
		int simRate = AirportSimulator.getSimExcRate();
		boolean checkinStatus = false;
		Booking passenger = null;
		boolean activeThread = true;
		while (!desk.getStatus().equals(DESK_STATUS.CLOSED) && activeThread) {
			if (checkinSvc.isQueueEmpty()) {
				//close desk & stop thread
				deskManager.closeDesk(this);
				deskManager.checkOtherDesksStatus();
			}else {
				
				try {
					checkinStatus = false;
					passenger = null;

					/* The check in process is broken down into small steps to allow adding delay as per the requirements. 
					 * Before each step, the desk status is updated accordingle and GUI is notified to update the status displayed 
					 * Start the check in process
					 * step#1 - add passenger from the queue to the desk
					 * step#2 - Validate passenger status - any additional checks for user information should happen here
					 * Step#3 - Check if the flight the passenger is checking for is currently boarding and if it still has capacity
					 * Step#4 - calculate any extra charge for baggage weight or volume. update the passenger object with the charges
					 * Step#5 - check if there is any charges, then collect payment.
					 * Step#6 - if we got to this point, then checkin process is completed update the checkinStatus to true	  
					 * Step#7 - passenger and flight information need to be updated after the check in process is completed
					 *  		regardless to the status. The update code is in the "finally" block to gurantee its execution in case of failure.
					 *  		The update is based on the checkinStatus.
					 *  		data to upate:
					 *  			1- add the passenger to the checked in or failed to checkin list based on the status
					 *  			2- if checkin is completed, update the total volume, total weight, total charge and passenger cnt of the active flight list
					 * Step#8 - clear desk to prepare it for next passenger
					 *  
					 *  At any step, if an error happened or the data is not vaild, an excption will be thrown and the check in process will fail.
					 *  The checkinStatus flag will remain as false and the data will be updated accordingly
					 */
					//Step# 1								
					checkinSvc.addPassengerToDesk(desk);
					Thread.sleep(simRate);
					checkinSvc.updateDeskStatus(desk, DESK_STATUS.GET_PASSENGER_FROM_QUEUE);
					System.out.println("Desk - " + desk.getThreadName() + " - processing passenger " 
							+ desk.getPassenger().getFullName());
					passenger = desk.getPassenger();

					//Step# 2
					Thread.sleep(simRate);
					checkinSvc.updateDeskStatus(desk, DESK_STATUS.VALIDATE_PASSENGER_DATA);
					checkinSvc.validatePassengerData(passenger);

					//Step# 3
					Thread.sleep(simRate);
					checkinSvc.updateDeskStatus(desk, DESK_STATUS.CHECK_FLIGHT_STATUS);
					checkinSvc.checkFlightStatus(passenger);

					//Step# 4
					Thread.sleep(simRate);
					checkinSvc.updateDeskStatus(desk, DESK_STATUS.CALCULATE_XTRA_CHARGES);
					passenger = checkinSvc.calculateBaggageXtraCharge(passenger);

					//Step# 5
					Thread.sleep(simRate);
					if (passenger.getXtraBagVolChrg() != 0 || passenger.getXtraBagVolChrg() !=0 ) {
						//passenger needs to pay extra baggage charge
						//TODO: Not sure what to do in this case
						checkinSvc.updateDeskStatus(desk, DESK_STATUS.PROCESS_PAYMENT);
						checkinSvc.processPayment(passenger);
					}

					//Step# 6
					Thread.sleep(simRate);
					checkinStatus = true;
				} catch (HWAirportException e) {
						System.out.println("Exception :" + e.getMessage());
				} catch (InterruptedException e) {
					activeThread = false;
				}finally {
					//Step# 7
					checkinSvc.updateDeskStatus(desk, DESK_STATUS.UPDATE_PASSENGER_FLIGHT_DATA);
					checkinSvc.saveFlightAndPassengerData(checkinStatus, passenger);
					
					if (checkinStatus) {
						System.out.println("Desk - " + desk.getThreadName() + " - processing passenger " 
								+ desk.getPassenger().getFullName() + " check in was completed successfully");
					}else {
						System.out.println("Desk - " + desk.getThreadName() + " - processing passenger " 
								+ desk.getPassenger().getFullName() + "check in was not successfull");
					}

				}

				
				//Step# 8
				checkinSvc.clearDesk(desk);


			}
		}

	}

}
