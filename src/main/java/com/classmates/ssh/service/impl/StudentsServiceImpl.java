package com.classmates.ssh.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.classmates.ssh.dao.StudentsDao;
import com.classmates.ssh.domain.PageBean;
import com.classmates.ssh.domain.Students;
import com.classmates.ssh.service.StudentsService;

/**
 * 学生业务层实现类
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
	 * 业务层登陆方法
	 */
	public Students login(Students student) {
		Students existStudent = studentsDao.findByUsernameAndPassword(student);
		return existStudent;
	}
    
	
	
	/**
	 * 业务层分页查询方法
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageBean<Students> findAll(Integer currPage) {
		
		PageBean<Students> pageBean = new PageBean();
		
		//封装当前页数
		pageBean.setCurrPage(currPage);
		
		//封装每页显示记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		
		//封装总记录数
		int totalCount = studentsDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		//封装总页数
		double tc = totalCount;
		Double tpnum = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(tpnum.intValue());
			
		//封装每页显示数据
		int begin = (currPage - 1)*pageSize;
		List<Students> list = studentsDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}




	//业务层保存学生的方法
	public void save(Students student) {
		studentsDao.save(student);
		
	}

	//业务层根据学生id查询学生的方法
	public Students findById(Integer sid) {
		
		return studentsDao.findById(sid);
	}

	
	//业务层修改学生的方法
	public void update(Students student) {
		studentsDao.update(student);
	}

	//业务层删除学生的方法
	public void delete(Students student) {
		studentsDao.delete(student);
	}

	

	   

}
