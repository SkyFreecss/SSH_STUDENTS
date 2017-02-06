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
 * ѧ��ҵ������
 * @author SkyFreecss
 *
 */
public class StudentsAction extends ActionSupport implements ModelDriven<Students>{
	        
	        /**
	 * 
	 */
	private static final long serialVersionUID = 5794528490771795112L;
	
			//ģ������ʹ�õĶ���
	        private Students student = new Students();
			@Override
			public Students getModel() {
				return student;
			}
			
			
	        //ע��ҵ����� 
			private StudentsService studentsService;
			private ClassRoomService classroomService;
			

			public void setClassroomService(ClassRoomService classroomService) {
				this.classroomService = classroomService;
			}

			public void setStudentsService(StudentsService studentsService) {
				this.studentsService = studentsService;
			}

		/**
	        * ��½  
	        */
           public String login()
           {
        	   System.out.println("ִ����login����������");
        	   Students existStudent = studentsService.login(student);
        	   
        	   if(existStudent == null)
        	   {
        		   //��½ʧ��
        		   this.addActionError("�û������������");
        		   return INPUT;
        	   }
        	   else
        	   {
        		   //��½�ɹ�
        		   ActionContext.getContext().getSession().put("existStudent",existStudent);
        		   return SUCCESS;
        	   }
        	 
           }
           
           //��ҳ����
           private Integer currPage=1;
           

           
           public void setCurrPage(Integer currPage) {
			this.currPage = currPage;
		}

		/**
            * ��ѯ
            */
           public String findAll()
           {
        	   PageBean<Students> pageBean = studentsService.findAll(currPage);
        	   //��pageBean���뵽ֵջ��
        	   ActionContext.getContext().getValueStack().push(pageBean);
			   return "findAll";
           }
           
           /**
            * ��ת�����ѧ��ҳ���ִ�з�����
            */
           public String saveUI()
           {
        	   //��ѯ����רҵ
        	   List<ClassRoom> list = classroomService.findAll();
        	   ActionContext.getContext().getValueStack().set("list",list);//������push��������set��
        	   return "saveUI";
           }
           
           /**
            * ����ѧ����ִ�з���
            */
           
           public String save()
           {
        	   studentsService.save(student);
        	   return "saveSuccess";
           }
           
           /**
            * �༭ѧ����ִ�еķ�����
            */
           public String edit()
           {
        	   //����ѧ��id��ѯѧ��
        	  student =  studentsService.findById(student.getSid());
        	   
        	   //��ѯ����רҵ�༶
        	  List<ClassRoom> list = classroomService.findAll();
              ActionContext.getContext().getValueStack().set("list", list);
              
              return "editSuccess";
           }
           
           /**
            * �޸�ѧ���ķ���
            */
           public String update()
           {
        	   studentsService.update(student);
        	   return "updateSuccess";
           }
           
           /**
            * ɾ��ѧ����ִ�з���
            */
           
           public String delete()
           {
        	   student = studentsService.findById(student.getSid());
               studentsService.delete(student);
               return "deleteSuccess";
           }
}
