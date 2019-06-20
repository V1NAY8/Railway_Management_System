package com.wipro.ttb.bean;

import java.sql.Date;

public class SearchTrainBean {

	public SearchTrainBean() {
		super();
	}

	String src;
	String dest;
	Date date;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
