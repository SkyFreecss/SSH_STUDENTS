package com.classmates.ssh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.classmates.ssh.dao.StudentsDao;
import com.classmates.ssh.domain.Students;

/**
 * 学生业务管理实现类
 * @author SkyFreecss
 *
 */
public class StudentsDaoImpl extends HibernateDaoSupport implements StudentsDao{

	
	/**
	 * Dao中根据用户名和密码查询用户的方法。
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


	//Dao中保存员工的方法
	public void save(Students student) {
		this.getHibernateTemplate().save(student);
	}


	//Dao中根据学生id查询学生的方法
	public Students findById(Integer sid) {
		return this.getHibernateTemplate().get(Students.class,sid);
	}


	//Dao中修改学生的方法
	public void update(Students student) {
		this.getHibernateTemplate().update(student);
	}


	//Dao中删除学生的方法
	public void delete(Students student) {
		this.getHibernateTemplate().delete(student);
	}
    
	

}
