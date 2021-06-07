package com.example.ROWater.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table
@Entity
public class Master {
	
	@Id
	private Integer consumerId;
	@NotNull
	@Size(min=10,max=10)
	private String mobile;
	private String modelNo;
	public Integer getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(Integer consumerId) {
		this.consumerId = consumerId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getModelNo() {
		return modelNo;
	}
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	public Master(Integer consumerId, String mobile, String modelNo) {
		super();
		this.consumerId = consumerId;
		this.mobile = mobile;
		this.modelNo = modelNo;
	}
	public Master() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Master [consumerId=" + consumerId + ", mobile=" + mobile + ", modelNo=" + modelNo + "]";
	}

}
