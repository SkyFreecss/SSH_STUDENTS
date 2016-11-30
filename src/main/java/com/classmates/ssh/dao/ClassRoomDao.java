package com.classmates.ssh.dao;

import java.util.List;

/**
 * 专业班级Dao层接口
 * @author SkyFreecss
 *
 */
import com.classmates.ssh.domain.ClassRoom;

public interface ClassRoomDao {

	int findCount();

	List<ClassRoom> findByPage(int begin, int pageSize);

	void save(ClassRoom classroom);

	ClassRoom findById(Integer cid);

	void update(ClassRoom classroom);

	void delete(ClassRoom classroom);

	List<ClassRoom> findAll();

}
