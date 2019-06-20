package com.wipro.ttb.dao;

import java.util.Date;

import com.wipro.ttb.bean.trainBean;

public class trainDAO {
	// Should be returned to Service and hence to be displayed in empty dashboard.
	

	// Get list of available trains between Two stations.
	public void queryTicket(trainBean trainBean) {
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println();
			System.out.println(e);
			
		}
		
	}
	
	public void availablity(int trainID, Date date) {
		// Checks the available tickets for a given day
		
	}
	
	public void updateCount(int trainID, Date date) {
		// Updates the no of tickets.
		// Used for both Booking and Cancelled Tickets.
	}
	
	public void modifyTicket(int PNR,String status) {
		// 1. Cancelled Tickets.
		// 2. Upcoming Tickets.
		// 3. Completed Tickets
		
	}
	
	

}
