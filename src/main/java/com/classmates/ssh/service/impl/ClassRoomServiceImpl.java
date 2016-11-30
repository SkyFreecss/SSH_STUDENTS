package com.classmates.ssh.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.classmates.ssh.dao.ClassRoomDao;
import com.classmates.ssh.domain.ClassRoom;
import com.classmates.ssh.domain.PageBean;
import com.classmates.ssh.service.ClassRoomService;

/**
 * 专业班级业务层实现类
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
	 * 分页查询的方法
	 */
	public PageBean<ClassRoom> findByPage(Integer currPage) {
		PageBean<ClassRoom> pageBean = new PageBean();
		
		//封装当前页数。
		pageBean.setCurrPage(currPage);
		
		//封装每页显示记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		
		//封装总记录数。
		int totalCount = classroomDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		//封装总页数。
		double tc = totalCount;
		Double tpnum = Math.ceil(tc/pageSize);
	    pageBean.setTotalPage(tpnum.intValue());
		
	    //封装每页显示数据。
		int begin = (currPage - 1)*pageSize;
		List<ClassRoom> list = classroomDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	//业务层保存专业班级的方法。
	public void save(ClassRoom classroom) {
		classroomDao.save(classroom);
	}


	
	//业务层根据专业班级id查询专业班级的方法
	@Override
	public ClassRoom findById(Integer cid) {
		
		return classroomDao.findById(cid);
	}

	
	//业务层修改专业班级的方法
	@Override
	public void update(ClassRoom classroom) {
		
		classroomDao.update(classroom);
	}

	//业务层删除专业班级的方法
	public void delete(ClassRoom classroom) {
		 classroomDao.delete(classroom);
	}
    
	//查询所有专业班级的方法
	public List<ClassRoom> findAll() {
		
		return classroomDao.findAll();
	}



	   
	   
}
