package com.ctm.bean;

import java.util.Date;

public class CTM {

	private long CTId;
	private Date startTime;
	private Date endTime;
	private ConferenceTrack prev;
	private ConferenceTrack next;
	public long getCTId() {
		return CTId;
	}
	public void setCTId(long cTId) {
		CTId = cTId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public ConferenceTrack getPrev() {
		return prev;
	}
	public void setPrev(ConferenceTrack prev) {
		this.prev = prev;
	}
	public ConferenceTrack getNext() {
		return next;
	}
	public void setNext(ConferenceTrack next) {
		this.next = next;
	}
	
	
}
