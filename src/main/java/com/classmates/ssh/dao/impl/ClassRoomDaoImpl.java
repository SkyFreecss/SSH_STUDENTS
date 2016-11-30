package com.classmates.ssh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.classmates.ssh.dao.ClassRoomDao;
import com.classmates.ssh.domain.ClassRoom;

/**
 * 专业班级Dao层实现类
 * @author SkyFreecss
 *
 */

public class ClassRoomDaoImpl extends HibernateDaoSupport implements ClassRoomDao {

	@Override
	public int findCount() {
		String hql = "Select count(*)from ClassRoom";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);//注意这里是Long类型。
		if(list.size()>0)
		{
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<ClassRoom> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ClassRoom.class);
		List<ClassRoom> list = (List<ClassRoom>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}

	
	//Dao中保存专业班级的方法
	public void save(ClassRoom classroom) {
		this.getHibernateTemplate().save(classroom);
	}

    //Dao中根据专业id查询专业班级的方法
	public ClassRoom findById(Integer cid) {
		
		return this.getHibernateTemplate().get(ClassRoom.class,cid);
	}
    
	//Dao中修改专业班级的方法
	@Override
	public void update(ClassRoom classroom) {
		
		this.getHibernateTemplate().update(classroom);
	}
    
	//Dao中删除专业班级的方法
	public void delete(ClassRoom classroom) {
		this.getHibernateTemplate().delete(classroom);
	}

	

	//Dao中查询所有专业班级的方法
	public List<ClassRoom> findAll() {
		return (List<ClassRoom>) this.getHibernateTemplate().find("from ClassRoom");
	}
             
}
