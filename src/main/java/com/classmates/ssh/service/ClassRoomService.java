package com.classmates.ssh.service;

import java.util.List;

import com.classmates.ssh.domain.ClassRoom;
import com.classmates.ssh.domain.PageBean;
import com.classmates.ssh.domain.Students;
/**
 * 专业班级业务层接口
 * @author SkyFreecss
 *
 */

@SuppressWarnings("unused")
public interface ClassRoomService {


	PageBean<ClassRoom> findByPage(Integer currPage);

	void save(ClassRoom classroom);


	void update(ClassRoom classroom);

	ClassRoom findById(Integer cid);

	void delete(ClassRoom classroom);


	List<ClassRoom> findAll();





}
