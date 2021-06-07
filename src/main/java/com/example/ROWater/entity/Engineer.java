package com.example.ROWater.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table
public class Engineer {
	@Id
	@Size(max=10)
	private String engineerId;
	@NotNull
	private String name;
	@NotNull
	@Size(min=10,max=10)
	private String mobile;
	public String getEngineerId() {
		return engineerId;
	}
	public void setEngineerId(String engineerId) {
		this.engineerId = engineerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Engineer(String engineerId, String name, String mobile) {
		super();
		this.engineerId = engineerId;
		this.name = name;
		this.mobile = mobile;
	}
	public Engineer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Engineer [engineerId=" + engineerId + ", name=" + name + ", mobile=" + mobile + "]";
	}

}
