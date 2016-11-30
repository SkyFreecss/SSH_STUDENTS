package com.classmates.ssh.domain;

import java.util.Date;

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

/**
 * 学生类
 * @author SkyFreecss
 *
 */
@Entity
@Table(name="students",schema="ssh")
public class Students {
       

	   private Integer sid;//id
	   

	   private String sname;//名字
	   

	   private String sgender;//性别
	   private Date birthday;//生日
	   

	   private String sno;//编号
	   

	   private String username;//用户名
	   

	   private String password;//密码
	   
	   //学生所属班级
	   private ClassRoom classroom;
	   

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	
	@Column(length=20)
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	@Column(length=20)
	public String getSgender() {
		return sgender;
	}
	public void setSgender(String sgender) {
		this.sgender = sgender;
	}
	
	@Column(length=20)
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Column(length=20)
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	
	@Column(length=20)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(length=20)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="cid",referencedColumnName="cid")   
	public ClassRoom getClassroom() {
		return classroom;
	}
	public void setClassroom(ClassRoom classroom) {
		this.classroom = classroom;
	}
	
	      
}