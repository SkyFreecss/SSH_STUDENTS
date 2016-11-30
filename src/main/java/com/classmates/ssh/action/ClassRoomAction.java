package com.classmates.ssh.action;

import com.classmates.ssh.domain.ClassRoom;
import com.classmates.ssh.domain.PageBean;
import com.classmates.ssh.service.ClassRoomService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 班级管理的业务处理类
 * @author SkyFreecss
 *
 */

public class ClassRoomAction extends ActionSupport implements ModelDriven<ClassRoom>{
    
	//模型驱动使用的对象
	private ClassRoom classroom = new ClassRoom();

	@Override
	public ClassRoom getModel() {
		return classroom;
	}



	//注入专业班级管理的Service
	private ClassRoomService classroomService;
	
	public void setClassroomService(ClassRoomService classroomService) {
		this.classroomService = classroomService;
	}
	
	//分页对象
	private Integer currPage=1;
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	

	
	//提供一个查询方法
	/**
	 * 查询
	 */
	public String findAll()
	{
		System.out.println("findAll执行了。。。");
		PageBean<ClassRoom> pageBean = classroomService.findByPage(currPage);
		
		//将pageBean存入到值栈中。
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	//跳转到添加专业班级的方法。
	public String saveUI()
	{
		return "saveUI";
	}
	
	//添加专业班级方法。
	public String save()
	{
		classroomService.save(classroom);
		return "saveSuccess";
	}

    //编辑专业班级执行的方法。
	public String edit()
	{
		classroom = classroomService.findById(classroom.getCid());
		return "editSuccess";
	}
    
	//修改专业班级的执行方法。
	public String update()
	{
		classroomService.update(classroom);
		return "updateSuccess";
	}


    //删除专业班级的执行方法。
    public String delete()
    {
    	classroom = classroomService.findById(classroom.getCid());
    	classroomService.delete(classroom);
    	return "deleteSuccess";
    }
}
