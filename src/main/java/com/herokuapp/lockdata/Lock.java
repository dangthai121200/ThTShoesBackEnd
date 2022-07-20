package com.herokuapp.lockdata;

import java.util.Date;

public class Lock {

	private String idReCord;
	private String username;
	private Date timeOut;

	public Lock() {
		super();
	}

	public Lock(String idReCord, String username, Date timeOut) {
		super();
		this.idReCord = idReCord;
		this.username = username;
		this.timeOut = timeOut;
	}

	public String getIdReCord() {
		return idReCord;
	}

	public void setIdReCord(String idReCord) {
		this.idReCord = idReCord;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Date timeOut) {
		this.timeOut = timeOut;
	}

	@Override
	public int hashCode() {
		return this.idReCord.hashCode() ^ this.username.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Lock lock = (Lock) obj;
		return this.idReCord.equals(lock.getIdReCord()) && this.username.equals(lock.getUsername()) ? true : false;
	}

}
