package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ERS_REIMBURSEMENT_STATUS")
public class ReimbursementStatus {

	@Id
	@Column(name="REIMB_STATUS_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int statusId;
	
	@Column(name="REIMB_STATUS", length=10)
	private String statusName;
	
	//CONSTRUCTOR//
	public ReimbursementStatus() {
	}

	public ReimbursementStatus(int statusId, String statusName) {
		super();
		this.statusId = statusId;
		this.statusName = statusName;
	}

	//GETTERS & SETTERS//
	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	//ToSTRING//
	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", statusName=" + statusName + "]";
	}
	
	
	
}
