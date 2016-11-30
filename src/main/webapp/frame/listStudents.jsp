<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
        .table1{
            border:1px solid #ddd;
            width:900px;
            
        }
        thead{
            background-color:lightblue;
        }

    </style>
</head>
<body>
<table border="0" width="900px">
<tr>
<td align="center" style="font-size:24px; color:#999"> 学生管理</td>
</tr>
<tr>
<td align="right" > <a href="${pageContext.request.contextPath}/students_saveUI.action">添加</a></td>
</tr>
</table>

<br/>

<table cellspacing="0" border="1" class="table1">
<thead>
   <tr>
   <th width="450">学号</th>
   <th width="450">学生姓名</th>
   <th width="450">性别</th>
   <th width="450">出生日期</th>
   <th width="450">所属专业</th>
   <th  width="450">编辑</th>
   <th  width="450">删除</th></tr>
</thead>
<tbody>

<s:iterator value="list" var="d">
<tr>
<td align="center"><s:property value="#d.sno" /></td>
<td align="center"><s:property value="#d.sname" /></td>
<td align="center"><s:property value="#d.sgender" /></td>
<td align="center"><s:date name="#d.birthday" format="yy-MM-dd"/></td>
<td align="center"><s:property value="#d.classroom.cname" /></td>
<td align="center"><a href="${pageContext.request.contextPath }/students_edit.action?sid=<s:property value="#d.sid" />"><img src="${pageContext.request.contextPath }/images/icon/n.png" /></a></td>
<td align="center"><a href="${pageContext.request.contextPath }/students_delete.action?sid=<s:property value="#d.sid" />"><img src="${pageContext.request.contextPath }/images/trash.gif" /></a></td>
</tr>
</s:iterator>
</tbody>
</table>
<br/>


<table border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>
<td align="right">
   <span>第<s:property value="currPage" />/<s:property value="totalPage" />页</span>&nbsp;&nbsp;
   <span>总记录数：<s:property value="totalCount" />&nbsp;&nbsp;每页显示：<s:property value="pageSize" /></span>
   <span>
   <s:if test="currPage !=1" />
       <a href="${pageContext.request.contextPath }/students_findAll.action?currPage=1">[首页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/students_findAll.action?currPage=<s:property value="currPage-1" />">[上一页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/students_findAll.action?currPage=<s:property value="currPage+1" />">[下一页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/students_findAll.action?currPage=<s:property value="totalPage" />">[尾页]</a>&nbsp;&nbsp;
   </span>
</td>
</tr>
</table>
</body>
</html>