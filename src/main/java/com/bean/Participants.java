package com.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "participants")
public class Participants {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int pid;
	private String fname;
	private String lname;
	private int age;
	private String emailid;
	private String password;
	

	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getPid() {
		return pid;
	}
	public Participants(int pid, String fname, String lname, int age, String emailid, String password) {
	super();
	this.pid = pid;
	this.fname = fname;
	this.lname = lname;
	this.age = age;
	this.emailid = emailid;
	this.password = password;
}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

@Override
public String toString() {
	return "Participants [pid=" + pid + ", fname=" + fname + ", lname=" + lname + ", age=" + age + ", emailid="
			+ emailid + ", password=" + password + "]";
}

	public Participants() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}