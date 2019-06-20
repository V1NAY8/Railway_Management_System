package com.wipro.ttb.bean;

import java.sql.Date;

public class BookingBean {

	public BookingBean() {
		super();
	}

	int PNR;
	String passengerName;
	int age;
	String trainNo;
	String trainName;
	String src;
	String dest;
	String estimatedTimeTaken;
	int countPassengers;
	Date bookingDate;
	Date journeyDate;
	String ticketStatus;
	String fare;

	public int getPNR() {
		return PNR;
	}

	public void setPNR(int pNR) {
		this.PNR = pNR;
	}

	public int getCountPassengers() {
		return countPassengers;
	}

	public void setCountPassengers(int countPassengers) {
		this.countPassengers = countPassengers;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public String getFare() {
		return fare;
	}

	public void setFare(String fare) {
		this.fare = fare;
	}

	public String getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getEstimatedTimeTaken() {
		return estimatedTimeTaken;
	}

	public void setEstimatedTimeTaken(String estimatedTimeTaken) {
		this.estimatedTimeTaken = estimatedTimeTaken;
	}

}
