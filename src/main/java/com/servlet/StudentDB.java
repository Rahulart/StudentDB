package com.servlet;

public class StudentDB {
	private int id;
	private String uname;
	private String email;
	private int phoneNo;
	private String dept;
	private String gender;
	public StudentDB() {
		//super();
	}
	public StudentDB(int id, String uname, String email, int phoneNo, String dept, String gender) {
		//super();
		this.id = id;
		this.uname = uname;
		this.email = email;
		this.phoneNo = phoneNo;
		this.dept = dept;
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String toString() {
		return this.id+" "+this.uname+" "+this.email+" "+this.phoneNo+" "+this.dept+" "+this.gender;
	}
}
