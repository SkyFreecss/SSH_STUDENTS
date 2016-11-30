package com.classmates.ssh.service;

import com.classmates.ssh.domain.PageBean;
import com.classmates.ssh.domain.Students;

/**
 * 学生业务层接口
 * @author SkyFreecss
 *
 */
public interface StudentsService {

	Students login(Students student);

	PageBean<Students> findAll(Integer currPage);

	void save(Students student);

	Students findById(Integer sid);

	void update(Students student);

	void delete(Students student);


}
