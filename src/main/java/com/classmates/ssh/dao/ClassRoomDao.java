package com.classmates.ssh.dao;

import java.util.List;

/**
 * רҵ�༶Dao��ӿ�
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
