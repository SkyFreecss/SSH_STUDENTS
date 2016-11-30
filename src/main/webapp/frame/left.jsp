<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<link href="dtree.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="dtree.js"></script>
</head>

<body bgColor=#DDF0FB leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
<table width="90%" border="0" cellspacing="1" cellpadding="2" align="center">
<div class="dtree">
  <script type="text/javascript">
    d=new dTree('d');

    d.add('01','-1','学生管理系统');
    d.add('0101','01','1402班');
    d.add('010101','0101','专业管理','${pageContext.request.contextPath}/classroom_findAll.action','','right');

    d.add('010102','0101','学生管理','${pageContext.request.contextPath}/students_findAll.action','','right');
    document.write(d);
  </script>
</div>
</table>

</body>
</html>