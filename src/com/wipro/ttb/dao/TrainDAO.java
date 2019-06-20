package com.wipro.ttb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.lang.Exception;


import java.sql.Date;

import com.wipro.ttb.bean.SearchTrainBean;
import com.wipro.ttb.bean.TrainBean;
import com.wipro.ttb.utils.DBUtil;

public class TrainDAO {
	// Should be returned to Service and hence to be displayed in empty dashboard.
	

	public ArrayList<TrainBean> queryTicket(SearchTrainBean searchTrainBean) {
		// If null is returned check condition.
		// Get list of available trains between Two stations.
		System.out.println("Querying Tickets Between two substations . . .");
		Connection con = DBUtil.getDBConnection();
		String queryTrain = "SELECT TRAIN_NO,TRAIN_NAME,TRAIN_CITIES,TIME_TAKEN,TRAIN_SRC,TRAIN_DEST,TRAVEL_DATE,AVAILABLE_DAY,AVAILABLE_SEATS,FARE FROM\r\n" + 
				"TTB01_TBL_TDT TDT\r\n" + 
				"INNER JOIN\r\n" + 
				"TTB01_TBL_CT CT ON (CT.CITY_ID = TDT.TRAIN_SRC) \r\n" + 
				"INNER JOIN\r\n" + 
				"TTB01_TBL_CT CTI ON (CTI.CITY_ID = TDT.TRAIN_DEST)\r\n" + 
				"INNER JOIN\r\n" + 
				"TTB01_TBL_DTB DTB ON (DTB.TRAIN_ID = TDT.TRAIN_ID)\r\n" + 
				"WHERE (CT.CITY_NAME = ? AND CTI.CITY_NAME = ? AND TRAVEL_DATE = ?)";

		try {	
			PreparedStatement preparedStatement = con.prepareStatement(queryTrain);
			preparedStatement.setString(1, searchTrainBean.getSrc());
			preparedStatement.setString(2, searchTrainBean.getDest());
			preparedStatement.setDate(3, searchTrainBean.getDate());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			
			ArrayList<TrainBean> trainResultList = new ArrayList<>();
			
			while(resultSet.next()) {
				TrainBean trainBean = new TrainBean();
				trainBean.setTrainNo(resultSet.getString("TRAIN_NO"));
				trainBean.setTrainName(resultSet.getString("TRAIN_NAME"));
				trainBean.setSubStations(resultSet.getString("TRAIN_CITIES"));
				trainBean.setEstimatedTimeTaken(resultSet.getInt("TIME_TAKEN"));
				trainBean.setTrainSrc(resultSet.getString("TRAIN_SRC"));
				trainBean.setTrainDest(resultSet.getString("TRAIN_DEST"));
				trainBean.setTravelDay(resultSet.getDate("TRAVEL_DATE"));
				trainBean.setAvailableSeats(resultSet.getInt("AVAILABLE_SEATS"));
				trainBean.setAvailableDays(resultSet.getString("AVAILABLE_DAYS"));
				trainBean.setFare(resultSet.getString("FARE"));
				
				trainResultList.add(trainBean);
				
			}
			System.out.println("Data Fetched from Database");
			preparedStatement.close();
			con.close();
			
			return trainResultList;
			
		} catch (Exception e) {
			System.out.println("Querying Tickets Between two substations Failed");
			System.out.println(e);
			e.printStackTrace();
		}
		return null;
	}
	
	public int availablity(int trainID, Date date) {
		// Checks the available tickets for a given day
		int availableSeats = -1;
		System.out.println("Available Tickets Count . . . ");
		Connection con = DBUtil.getDBConnection();
		String queryNumberString = "SELECT AVAILABLE_SEATS FROM TTB01_TBL_DTB WHERE (TRAIN_ID = ? AND TRAVEL_DATE = ?)";
		try {
		PreparedStatement preparedStatement = con.prepareStatement(queryNumberString);
		preparedStatement.setInt(1,trainID );
		preparedStatement.setDate(2, date);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			availableSeats = resultSet.getInt("AVAILABLE_SEATS");
			return availableSeats;
		}
		preparedStatement.close();
		con.close();
		
		} catch (SQLException e) {
			System.out.println("Available Tickets Count Failed");
			System.out.println(e);
			e.printStackTrace();
		}
		return availableSeats;
		
	}
	
	public void updateCount(int trainID, Date date, String op) {
		// Only Used to Update the no of tickets.
		// Used for both Booking and Cancelled Tickets.
		System.out.println("Updating Ticket Count . . . ");
		Connection con = DBUtil.getDBConnection();
		int tickets = this.availablity(trainID, date);
		String updateSeatsString = "UPDATE TTB01_TBL_DTB SET AVAILABLE_SEATS = ? WHERE (TRAIN_ID = ? AND TRAVEL_DATE = ?)";
		try {
			// Throw Negative number exception along with exception.
			if(tickets == -1) {throw new Exception("Query Failed");}
			// If tickets are zero then you should not book tickets.
			if(tickets == 0) {throw new Exception("No Tickets Available");}
		PreparedStatement preparedStatement = con.prepareStatement(updateSeatsString);
		preparedStatement.setInt(2, trainID);
		preparedStatement.setDate(3, date);
		if(op.equals("BOOK_TICKET")) {
			tickets = tickets - 1;
			preparedStatement.setInt(1, tickets);
			
		}
		else if(op.equals("CANCEL_TICKET")) {
			tickets = tickets + 1;
			preparedStatement.setInt(1, tickets);	
		}
		preparedStatement.execute();
		System.out.println("You have successfully " + op + "the ticket.");
		
		} catch (SQLException e) {
			System.out.println("Updating Ticket Count Failed");
			System.out.println(e);
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Updating Ticket Count Failed");
			System.out.println(e);
			e.printStackTrace();
		}
		
	}
	
	

}


