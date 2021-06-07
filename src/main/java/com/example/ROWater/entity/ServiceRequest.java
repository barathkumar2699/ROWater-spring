package com.example.ROWater.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class ServiceRequest {

	@Id
	@GeneratedValue
	private Integer referenceNo;
	@NotNull
	private Integer consumerId;
	@NotNull
	private String engineerId;
	private Date requestDate;
	@NotNull
	private String description;
	@NotNull
	private String status;
	public Integer getReferenceNo() {
		return referenceNo;
	}
	public void setReferenceNo(Integer referenceNo) {
		this.referenceNo = referenceNo;
	}
	public Integer getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(Integer consumerId) {
		this.consumerId = consumerId;
	}
	public String getEngineerId() {
		return engineerId;
	}
	public void setEngineerId(String engineerId) {
		this.engineerId = engineerId;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ServiceRequest(Integer referenceNo, @NotNull Integer consumerId, @NotNull String engineerId,
			Date requestDate, @NotNull String description, @NotNull String status) {
		super();
		this.referenceNo = referenceNo;
		this.consumerId = consumerId;
		this.engineerId = engineerId;
		this.requestDate = requestDate;
		this.description = description;
		this.status = status;
	}
	public ServiceRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ServiceRequest [referenceNo=" + referenceNo + ", consumerId=" + consumerId + ", engineerId="
				+ engineerId + ", requestDate=" + requestDate + ", description=" + description + ", status=" + status
				+ "]";
	}
}
