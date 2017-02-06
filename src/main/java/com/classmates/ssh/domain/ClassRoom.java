package com.classmates.ssh.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 班级类
 * @author SkyFreecss
 *
 */
@SuppressWarnings("unused")
@Entity
@Table(name="classroom",schema="ssh")
public class ClassRoom {
       
	   private Integer cid;//班级编号
	   private String cname;//班级名称
	   private String cdesc;//班级描述
	  
	   
	   //学生的集合
	   private Set<Students> students;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCdesc() {
		return cdesc;
	}
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@JoinColumn(name="cid")
	public Set<Students> getStudents() {
		return students;
	}
	public void setStudents(Set<Students> students) {
		this.students = students;
	}
	
	
}
