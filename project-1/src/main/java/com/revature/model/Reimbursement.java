package com.revature.model;

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="reimbursement")
public class Reimbursement {
	
	@Id
	@Column(name="reimbursement_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reimbId;

	@NotNull
	@Column(name="amount")
	private double amount;
	
	@Basic
	@Column(name="submitted")
	private LocalDateTime submitedTime;
	
	@Basic
	@Column(name="resolved")
	private LocalDateTime resolvedTime;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="author_id")
	private User submitter;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="resolver_id")
	private User resolver;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="status_id")
	private ReimbursementStatus status;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="type_id")
	private ReimbursementType type;
	
	//CONSTRUCTOR//
	public Reimbursement() {
	}

	public Reimbursement(int reimbId, double amount, LocalDateTime submitedTime, User submitter, String description,
			ReimbursementType type) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.submitedTime = LocalDateTime.now();
		this.submitter = submitter;
		this.description = description;
		this.type = type;
	}
	
	public Reimbursement(int reimbId, double amount, LocalDateTime submitedTime, User submitter, String description,
			ReimbursementStatus status, ReimbursementType type) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.submitedTime = LocalDateTime.now();
		this.submitter = submitter;
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
		this.submitter = submitter;
		this.resolver = resolver;
		this.description = description;
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

	public User getSubmitter() {
		return submitter;
	}

	public void setSubmitter(User submitter) {
		this.submitter = submitter;
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
				+ ", resolvedTime=" + resolvedTime + ", submitter=" + submitter + ", resolver=" + resolver
				+ ", description=" + description + ", status=" + status + ", type=" + type + "]";
	}
	
}
