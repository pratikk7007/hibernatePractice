package com.pratik.entities;

import java.io.Serializable;

public class Student implements Serializable{
	
	private int rno; 
	private String name; 
	private double per;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPer() {
		return per;
	}
	public void setPer(double per) {
		this.per = per;
	} 
	
		
	

}
