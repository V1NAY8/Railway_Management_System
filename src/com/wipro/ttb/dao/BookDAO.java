package com.wipro.ttb.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.ttb.bean.BookingBean;
import com.wipro.ttb.utils.DBUtil;

public class BookDAO {
	

	
	// Book a New Ticket
	// Should Come here after checking Availability.
	public int bookTicket(BookingBean bookingBean,int trainID,Date date) {
		// 1 for successful cancellation
		// 0 for failure
		System.out.println("Booking a New Ticket  . . . ");
		
		String queryString = "INSERT INTO TTB01_TBL_BOOK VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			Connection connection  = DBUtil.getDBConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(queryString);
			 preparedStatement.setInt(1, bookingBean.getPNR());
			 // Set USER_REF from HttpSession.
			 preparedStatement.setInt(3, bookingBean.getCountPassengers());
			 preparedStatement.setInt(4, bookingBean.getAge());
			 preparedStatement.setString(5, bookingBean.getSrc());
			 preparedStatement.setString(6, bookingBean.getDest());
			 preparedStatement.setDate(7, bookingBean.getBookingDate());
			 preparedStatement.setDate(8, bookingBean.getJourneyDate());
			 preparedStatement.setString(9, bookingBean.getTicketStatus());
			 
			 int rowsAffected  = preparedStatement.executeUpdate();
			 System.out.println(rowsAffected + " Rows Added");
			 
			 TrainDAO trainDAO = new TrainDAO();
			 trainDAO.updateCount(trainID, date, "BOOK_TICKET");
			 System.out.println("Ticket Booked Succesfully");
			 preparedStatement.close();
			 connection.close();
			 return 1;
			 
			 
			
		} catch (Exception e) {
			System.out.println("Booking Ticket Failed");
			System.out.println(e);
			e.printStackTrace();
			
		}
		return 0;
		
		
	}
	
	// Cancel a Ticket
	public int cancelTicket(int PNR) {
		// 1 for successful cancellation
		// 0 for failure.
		System.out.println("Cancelling the Ticket . . .");
		
		String queryString ="UPDATE TTB01_TBL_TTB SET TICKET_STATUS = ? WHERE PNR = ?";
		try {
			Connection connection  = DBUtil.getDBConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(queryString);
			 preparedStatement.setString(1, "CANCELLED");
			 preparedStatement.setInt(2, PNR);
			 preparedStatement.execute();
			 preparedStatement.close();
			 connection.close();
			 return 1;
			
		} catch (Exception e) {
			
			System.out.println("Cancelling the Ticket failed");
			System.out.println(e);
			e.printStackTrace();
			
		}
		return 0;
		
	}
	
	// Get a required Ticket 
	// All these are to be returned to Service and hence to be
	// displayed in Cards in dashboard.
	public ArrayList<BookingBean> queryTicket(int PNR,String ticketStatus) {
		// Input is PNR and output is a Bean.
		System.out.println("Getting the required Ticket");
		Connection connection  = DBUtil.getDBConnection();
		String queryString = "SELECT PNR,PASSENGER_NAME,AGE,TRAIN_NO,TRAIN_NAME,TIME_TAKEN,SRC,DEST,BOOKING_DATE,JOURNEY_DATE,TICKET_STATUS\r\n" + 
				"FROM TTB01_TBL_BOOK BOOK\r\n" + 
				"INNER JOIN\r\n" + 
				"TTB01_TBL_TDT TDT ON TDT.TRAIN_ID = BOOK.TRAIN_ID\r\n" + 
				"WHERE BOOK.PNR = ? AND BOOK.TICKET_STATUS = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setInt(1, PNR);
			preparedStatement.setString(2, ticketStatus);
			ResultSet resultSet = preparedStatement.executeQuery();
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			ArrayList<BookingBean> bookingBeans= new ArrayList<>();
			while(resultSet.next()) {
				BookingBean bookingBean = new BookingBean();
				bookingBean.setPNR(resultSet.getInt("PNR"));
				bookingBean.setPassengerName(resultSet.getString("PASSENGER_NAME"));
				bookingBean.setAge(resultSet.getInt("AGE"));
				bookingBean.setTrainNo(resultSet.getString("TRAIN_NO"));
				bookingBean.setTrainName(resultSet.getString("TRAIN_NAME"));
				bookingBean.setSrc(resultSet.getString("SRC"));
				bookingBean.setDest(resultSet.getString("DEST"));
				bookingBean.setEstimatedTimeTaken(resultSet.getString("TIME_TAKEN"));
				bookingBean.setCountPassengers(resultSetMetaData.getColumnCount());
				bookingBean.setBookingDate(resultSet.getDate("BOOKING_DATE"));
				bookingBean.setJourneyDate(resultSet.getDate("JOURNEY_DATE"));
				bookingBean.setTicketStatus(resultSet.getString("TICKET_STATUS"));
				bookingBean.setFare(resultSet.getString("FARE"));
				bookingBeans.add(bookingBean);
			}
			preparedStatement.close();
			connection.close();
			
			return bookingBeans;
			
			
		} catch (Exception e) {
			
			System.out.println("Getting Required Ticket Failed . . .");
			System.out.println(e);
			e.printStackTrace();
			
		}
		return null;
		
	}
	
	public void modifyTicket(int PNR,String status) {
		// 1. Cancel Tickets.
		// 2. Upcoming Tickets / Booked Ticket.
		// 3. Completed Tickets
		System.out.println("Modifiying Ticket Status . . . ");
		Connection con = DBUtil.getDBConnection();
		String queryString = "UPDATE TTB01_TBL_BOOK SET TICKET_STATUS = ? WHERE PNR = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(queryString);
			preparedStatement.setString(1, status);
			preparedStatement.setInt(2, PNR);
			
			preparedStatement.execute();
			preparedStatement.close();
			con.close();
			System.out.println("Modified your ticket status to " + status);
		} catch (SQLException e) {
			System.out.println("Modifiying Ticket Status Failed");
			System.out.println(e);
			e.printStackTrace();
		}

	}
}
