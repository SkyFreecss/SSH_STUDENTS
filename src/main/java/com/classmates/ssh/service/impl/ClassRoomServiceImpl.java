package com.classmates.ssh.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.classmates.ssh.dao.ClassRoomDao;
import com.classmates.ssh.domain.ClassRoom;
import com.classmates.ssh.domain.PageBean;
import com.classmates.ssh.service.ClassRoomService;

/**
 * רҵ�༶ҵ���ʵ����
 * @author SkyFreecss
 *
 */

@Transactional
public class ClassRoomServiceImpl implements ClassRoomService {
       
	   private ClassRoomDao classroomDao;

	public void setClassroomDao(ClassRoomDao classroomDao) {
		this.classroomDao = classroomDao;
	}

	/**
	 * ��ҳ��ѯ�ķ���
	 */
	public PageBean<ClassRoom> findByPage(Integer currPage) {
		PageBean<ClassRoom> pageBean = new PageBean();
		
		//��װ��ǰҳ����
		pageBean.setCurrPage(currPage);
		
		//��װÿҳ��ʾ��¼��
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		
		//��װ�ܼ�¼����
		int totalCount = classroomDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		//��װ��ҳ����
		double tc = totalCount;
		Double tpnum = Math.ceil(tc/pageSize);
	    pageBean.setTotalPage(tpnum.intValue());
		
	    //��װÿҳ��ʾ���ݡ�
		int begin = (currPage - 1)*pageSize;
		List<ClassRoom> list = classroomDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	//ҵ��㱣��רҵ�༶�ķ�����
	public void save(ClassRoom classroom) {
		classroomDao.save(classroom);
	}


	
	//ҵ������רҵ�༶id��ѯרҵ�༶�ķ���
	@Override
	public ClassRoom findById(Integer cid) {
		
		return classroomDao.findById(cid);
	}

	
	//ҵ����޸�רҵ�༶�ķ���
	@Override
	public void update(ClassRoom classroom) {
		
		classroomDao.update(classroom);
	}

	//ҵ���ɾ��רҵ�༶�ķ���
	public void delete(ClassRoom classroom) {
		 classroomDao.delete(classroom);
	}
    
	//��ѯ����רҵ�༶�ķ���
	public List<ClassRoom> findAll() {
		
		return classroomDao.findAll();
	}



	   
	   
}
