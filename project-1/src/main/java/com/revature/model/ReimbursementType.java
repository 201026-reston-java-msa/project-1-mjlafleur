package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ERS_REIMBURSEMENT_TYPE")
public class ReimbursementType {
	
	@Id
	@Column(name="REIMB_TYPE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int typeId;
	
	@Column(name="REIMB_TYPE", length=10)
	private String typeName;
	
	//CONSTRUCTOR//
	public ReimbursementType() {
	}

	public ReimbursementType(int typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}

	//GETTERS & SETTERS//
	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	//ToSTRING//
	@Override
	public String toString() {
		return "ReimbursementType [typeId=" + typeId + ", typeName=" + typeName + "]";
	}
	
}
