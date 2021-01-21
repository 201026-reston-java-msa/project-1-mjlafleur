package com.revature.model;

import java.sql.Blob;
import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.type.BlobType;

import com.sun.istack.NotNull;

@Entity
@Table(name="ERS_REIMBURSEMENT")
public class Reimbursement {
	
	@Id
	@Column(name="REIMB_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reimbId;

	@NotNull
	@Column(name="REIMB_AMOUNT")
	private double amount;
	
	@Basic
	@Column(name="REIMB_SUBMITTED")
	private LocalDateTime submitedTime;
	
	@Basic
	@Column(name="REIMB_RESOLVED")
	private LocalDateTime resolvedTime;
	
	@Column(name="REIMB_DESCRIPTION",length=250)
	private String description;
	
	//////////////////////////////BLOB Binary Large Object
	@Lob
	@Column(name="REIMB_RECEIPT")
	private Blob receipt;
	////////////////////////////////
	

	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="REIMB_AUTHOR")
	private User author;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="REIMB_RESOLVER")
	private User resolver;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="REIMB_STATUS_ID")
	private ReimbursementStatus status;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="REIMB_TYPE_ID")
	private ReimbursementType type;
	
	
	
	//CONSTRUCTOR//
	public Reimbursement() {
	}

	public Reimbursement(int reimbId, double amount, LocalDateTime submitedTime, User author, String description,
			ReimbursementType type) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.submitedTime = LocalDateTime.now();
		this.author = author;
		this.description = description;
		this.type = type;
	}
	
	public Reimbursement(int reimbId, double amount, LocalDateTime submitedTime, User author, String description,
			ReimbursementStatus status, ReimbursementType type) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.submitedTime = LocalDateTime.now();
		this.author = author;
		this.description = description;
		this.status = status;
		this.type = type;
	}

	public Reimbursement(int reimbId, double amount, LocalDateTime submitedTime, LocalDateTime resolvedTime,
			User submitter, User resolver, String description, ReimbursementStatus status, ReimbursementType type) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.submitedTime = submitedTime;
		this.resolvedTime = resolvedTime;
		this.author = submitter;
		this.resolver = resolver;
		this.description = description;
		this.status = status;
		this.type = type;
	}
	
	

	public Reimbursement(int reimbId, double amount, LocalDateTime submitedTime, LocalDateTime resolvedTime,
			String description, Blob receipt, User author, User resolver, ReimbursementStatus status,
			ReimbursementType type) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.submitedTime = submitedTime;
		this.resolvedTime = resolvedTime;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}

	//GETTERS AND SETTERS//
	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getSubmitedTime() {
		return submitedTime;
	}

	public void setSubmitedTime(LocalDateTime submitedTime) {
		this.submitedTime = submitedTime;
	}

	public LocalDateTime getResolvedTime() {
		return resolvedTime;
	}

	public void setResolvedTime(LocalDateTime resolvedTime) {
		this.resolvedTime = resolvedTime;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public User getResolver() {
		return resolver;
	}

	public void setResolver(User resolver) {
		this.resolver = resolver;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ReimbursementStatus getStatus() {
		return status;
	}

	public void setStatus(ReimbursementStatus status) {
		this.status = status;
	}
	
	public Blob getReceipt() {
		return receipt;
	}

	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}


	public ReimbursementType getType() {
		return type;
	}

	public void setType(ReimbursementType type) {
		this.type = type;
	}

	//ToSTRING//
	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", amount=" + amount + ", submitedTime=" + submitedTime
				+ ", resolvedTime=" + resolvedTime + ", author=" + author + ", resolver=" + resolver
				+ ", description=" + description + ", status=" + status + ", type=" + type + "]";
	}
	
}
