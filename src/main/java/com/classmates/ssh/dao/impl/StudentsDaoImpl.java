package com.classmates.ssh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.classmates.ssh.dao.StudentsDao;
import com.classmates.ssh.domain.Students;

/**
 * ѧ��ҵ�����ʵ����
 * @author SkyFreecss
 *
 */
public class StudentsDaoImpl extends HibernateDaoSupport implements StudentsDao{

	
	/**
	 * Dao�и����û����������ѯ�û��ķ�����
	 */
	public Students findByUsernameAndPassword(Students student) {
		
		String hql = "from Students where username = ? and password = ?";
		List<Students> list = (List<Students>) this.getHibernateTemplate().find(hql, student.getUsername(),student.getPassword());
		
		if(list.size()>0)
		{
			return list.get(0);
		}
		
		return null;
	}

	
	@Override
	public int findCount() {
		String hql = "Select Count(*) from Students";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size()>0)
		{
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Students> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Students.class);
		List<Students> list = (List<Students>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}


	//Dao�б���Ա���ķ���
	public void save(Students student) {
		this.getHibernateTemplate().save(student);
	}


	//Dao�и���ѧ��id��ѯѧ���ķ���
	public Students findById(Integer sid) {
		return this.getHibernateTemplate().get(Students.class,sid);
	}


	//Dao���޸�ѧ���ķ���
	public void update(Students student) {
		this.getHibernateTemplate().update(student);
	}


	//Dao��ɾ��ѧ���ķ���
	public void delete(Students student) {
		this.getHibernateTemplate().delete(student);
	}
    
	

}
