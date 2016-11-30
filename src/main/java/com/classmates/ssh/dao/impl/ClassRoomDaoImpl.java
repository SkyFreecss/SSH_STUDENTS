package com.classmates.ssh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.classmates.ssh.dao.ClassRoomDao;
import com.classmates.ssh.domain.ClassRoom;

/**
 * רҵ�༶Dao��ʵ����
 * @author SkyFreecss
 *
 */

public class ClassRoomDaoImpl extends HibernateDaoSupport implements ClassRoomDao {

	@Override
	public int findCount() {
		String hql = "Select count(*)from ClassRoom";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);//ע��������Long���͡�
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

	
	//Dao�б���רҵ�༶�ķ���
	public void save(ClassRoom classroom) {
		this.getHibernateTemplate().save(classroom);
	}

    //Dao�и���רҵid��ѯרҵ�༶�ķ���
	public ClassRoom findById(Integer cid) {
		
		return this.getHibernateTemplate().get(ClassRoom.class,cid);
	}
    
	//Dao���޸�רҵ�༶�ķ���
	@Override
	public void update(ClassRoom classroom) {
		
		this.getHibernateTemplate().update(classroom);
	}
    
	//Dao��ɾ��רҵ�༶�ķ���
	public void delete(ClassRoom classroom) {
		this.getHibernateTemplate().delete(classroom);
	}

	

	//Dao�в�ѯ����רҵ�༶�ķ���
	public List<ClassRoom> findAll() {
		return (List<ClassRoom>) this.getHibernateTemplate().find("from ClassRoom");
	}
             
}
