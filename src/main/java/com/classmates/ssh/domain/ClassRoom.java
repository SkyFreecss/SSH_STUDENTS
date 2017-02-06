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
 * �༶��
 * @author SkyFreecss
 *
 */
@SuppressWarnings("unused")
@Entity
@Table(name="classroom",schema="ssh")
public class ClassRoom {
       
	   private Integer cid;//�༶���
	   private String cname;//�༶����
	   private String cdesc;//�༶����
	  
	   
	   //ѧ���ļ���
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
