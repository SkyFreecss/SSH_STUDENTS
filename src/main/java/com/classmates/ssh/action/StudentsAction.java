package com.classmates.ssh.action;

import java.util.List;

import com.classmates.ssh.domain.ClassRoom;
import com.classmates.ssh.domain.PageBean;
import com.classmates.ssh.domain.Students;
import com.classmates.ssh.service.ClassRoomService;
import com.classmates.ssh.service.StudentsService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 学生业务处理类
 * @author SkyFreecss
 *
 */
public class StudentsAction extends ActionSupport implements ModelDriven<Students>{
	        
	        /**
	 * 
	 */
	private static final long serialVersionUID = 5794528490771795112L;
	
			//模型驱动使用的对象
	        private Students student = new Students();
			@Override
			public Students getModel() {
				return student;
			}
			
			
	        //注入业务层类 
			private StudentsService studentsService;
			private ClassRoomService classroomService;
			

			public void setClassroomService(ClassRoomService classroomService) {
				this.classroomService = classroomService;
			}

			public void setStudentsService(StudentsService studentsService) {
				this.studentsService = studentsService;
			}

		/**
	        * 登陆  
	        */
           public String login()
           {
        	   System.out.println("执行了login方法。。。");
        	   Students existStudent = studentsService.login(student);
        	   
        	   if(existStudent == null)
        	   {
        		   //登陆失败
        		   this.addActionError("用户名或密码错误！");
        		   return INPUT;
        	   }
        	   else
        	   {
        		   //登陆成功
        		   ActionContext.getContext().getSession().put("existStudent",existStudent);
        		   return SUCCESS;
        	   }
        	 
           }
           
           //分页对象
           private Integer currPage=1;
           

           
           public void setCurrPage(Integer currPage) {
			this.currPage = currPage;
		}

		/**
            * 查询
            */
           public String findAll()
           {
        	   PageBean<Students> pageBean = studentsService.findAll(currPage);
        	   //将pageBean存入到值栈中
        	   ActionContext.getContext().getValueStack().push(pageBean);
			   return "findAll";
           }
           
           /**
            * 跳转到添加学生页面的执行方法。
            */
           public String saveUI()
           {
        	   //查询所有专业
        	   List<ClassRoom> list = classroomService.findAll();
        	   ActionContext.getContext().getValueStack().set("list",list);//对象用push，集合用set。
        	   return "saveUI";
           }
           
           /**
            * 保存学生的执行方法
            */
           
           public String save()
           {
        	   studentsService.save(student);
        	   return "saveSuccess";
           }
           
           /**
            * 编辑学生的执行的方法。
            */
           public String edit()
           {
        	   //根据学生id查询学生
        	  student =  studentsService.findById(student.getSid());
        	   
        	   //查询所有专业班级
        	  List<ClassRoom> list = classroomService.findAll();
              ActionContext.getContext().getValueStack().set("list", list);
              
              return "editSuccess";
           }
           
           /**
            * 修改学生的方法
            */
           public String update()
           {
        	   studentsService.update(student);
        	   return "updateSuccess";
           }
           
           /**
            * 删除学生的执行方法
            */
           
           public String delete()
           {
        	   student = studentsService.findById(student.getSid());
               studentsService.delete(student);
               return "deleteSuccess";
           }
}
