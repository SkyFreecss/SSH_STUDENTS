package com.classmates.ssh.action;

import com.classmates.ssh.domain.ClassRoom;
import com.classmates.ssh.domain.PageBean;
import com.classmates.ssh.service.ClassRoomService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * �༶�����ҵ������
 * @author SkyFreecss
 *
 */

public class ClassRoomAction extends ActionSupport implements ModelDriven<ClassRoom>{
    
	//ģ������ʹ�õĶ���
	private ClassRoom classroom = new ClassRoom();

	@Override
	public ClassRoom getModel() {
		return classroom;
	}



	//ע��רҵ�༶�����Service
	private ClassRoomService classroomService;
	
	public void setClassroomService(ClassRoomService classroomService) {
		this.classroomService = classroomService;
	}
	
	//��ҳ����
	private Integer currPage=1;
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	

	
	//�ṩһ����ѯ����
	/**
	 * ��ѯ
	 */
	public String findAll()
	{
		System.out.println("findAllִ���ˡ�����");
		PageBean<ClassRoom> pageBean = classroomService.findByPage(currPage);
		
		//��pageBean���뵽ֵջ�С�
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	//��ת�����רҵ�༶�ķ�����
	public String saveUI()
	{
		return "saveUI";
	}
	
	//���רҵ�༶������
	public String save()
	{
		classroomService.save(classroom);
		return "saveSuccess";
	}

    //�༭רҵ�༶ִ�еķ�����
	public String edit()
	{
		classroom = classroomService.findById(classroom.getCid());
		return "editSuccess";
	}
    
	//�޸�רҵ�༶��ִ�з�����
	public String update()
	{
		classroomService.update(classroom);
		return "updateSuccess";
	}


    //ɾ��רҵ�༶��ִ�з�����
    public String delete()
    {
    	classroom = classroomService.findById(classroom.getCid());
    	classroomService.delete(classroom);
    	return "deleteSuccess";
    }
}
