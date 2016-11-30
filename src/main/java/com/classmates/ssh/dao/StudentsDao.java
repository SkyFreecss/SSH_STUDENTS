package com.classmates.ssh.dao;

import java.util.List;

import com.classmates.ssh.domain.Students;

/**
 * 学生业务管理接口
 * @author SkyFreecss
 *
 */
public interface StudentsDao {


	Students findByUsernameAndPassword(Students student);

	int findCount();

	List<Students> findByPage(int begin, int pageSize);

	void save(Students student);

	Students findById(Integer sid);

	void update(Students student);

	void delete(Students student);

}
