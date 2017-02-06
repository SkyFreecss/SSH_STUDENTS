package com.classmates.ssh.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.classmates.ssh.dao.StudentsDao;
import com.classmates.ssh.domain.PageBean;
import com.classmates.ssh.domain.Students;
import com.classmates.ssh.service.StudentsService;

/**
 * ѧ��ҵ���ʵ����
 * @author SkyFreecss
 *
 */
@Transactional
public class StudentsServiceImpl implements StudentsService{
	
	   private StudentsDao studentsDao;

	   public void setStudentsDao(StudentsDao studentsDao) {
		this.studentsDao = studentsDao;
	}

	@Override
	/**
	 * 
	 * ҵ����½����
	 */
	public Students login(Students student) {
		Students existStudent = studentsDao.findByUsernameAndPassword(student);
		return existStudent;
	}
    
	
	
	/**
	 * ҵ����ҳ��ѯ����
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageBean<Students> findAll(Integer currPage) {
		
		PageBean<Students> pageBean = new PageBean();
		
		//��װ��ǰҳ��
		pageBean.setCurrPage(currPage);
		
		//��װÿҳ��ʾ��¼��
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		
		//��װ�ܼ�¼��
		int totalCount = studentsDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		//��װ��ҳ��
		double tc = totalCount;
		Double tpnum = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(tpnum.intValue());
			
		//��װÿҳ��ʾ����
		int begin = (currPage - 1)*pageSize;
		List<Students> list = studentsDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}




	//ҵ��㱣��ѧ���ķ���
	public void save(Students student) {
		studentsDao.save(student);
		
	}

	//ҵ������ѧ��id��ѯѧ���ķ���
	public Students findById(Integer sid) {
		
		return studentsDao.findById(sid);
	}

	
	//ҵ����޸�ѧ���ķ���
	public void update(Students student) {
		studentsDao.update(student);
	}

	//ҵ���ɾ��ѧ���ķ���
	public void delete(Students student) {
		studentsDao.delete(student);
	}

	

	   

}
