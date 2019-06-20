package com.wipro.ttb.bean;

import java.util.Date;

public class TrainBean {
	String trainNo;
	String trainName;
	String trainSrc;
	String trainDest;
	String subStations;
	Date travelDay;
	String availableDays;
	int availableSeats;
	int estimatedTimeTaken;
	String fare;
	
	
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
	public String getTrainSrc() {
		return trainSrc;
	}
	public void setTrainSrc(String trainSrc) {
		this.trainSrc = trainSrc;
	}
	public String getTrainDest() {
		return trainDest;
	}
	public void setTrainDest(String trainDest) {
		this.trainDest = trainDest;
	}
	public String getSubStations() {
		return subStations;
	}
	public void setSubStations(String subStations) {
		this.subStations = subStations;
	}
	public Date getTravelDay() {
		return travelDay;
	}
	public void setTravelDay(Date travelDay) {
		this.travelDay = travelDay;
	}
	public String getAvailableDays() {
		return availableDays;
	}
	public void setAvailableDays(String availableDays) {
		this.availableDays = availableDays;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public int getEstimatedTimeTaken() {
		return estimatedTimeTaken;
	}
	public void setEstimatedTimeTaken(int estimatedTimeTaken) {
		this.estimatedTimeTaken = estimatedTimeTaken;
	}
	public String getFare() {
		return fare;
	}
	public void setFare(String fare) {
		this.fare = fare;
	}
	
	

}
