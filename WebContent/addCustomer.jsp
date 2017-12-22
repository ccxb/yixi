<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="<%=basePath%>/css/Style.css" type=text/css rel=stylesheet>
<LINK href="<%=basePath%>/css/Manage.css" type=text/css
	rel=stylesheet>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="<%=basePath%>/spring/crm/addCustomer"
		method=post>
		

		<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="<%=basePath%>/img/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="<%=basePath%>/img/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="<%=basePath%>/img/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0 height=545>
			<TBODY>
				<TR>
					<TD width=15 background="<%=basePath%>/img/new_022.jpg"><IMG
						src="<%=basePath%>/img/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 添加客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
						  
						    
							<TR>
								<td>客户名称：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custName">
								</td>
								<td>客户状态 ：</td>
								<td>
								<select name="custLevel">								
								<option value="vip客户">vip客户</option>
								<option value="现有客户">现有客户</option>
								<option value="潜在客户">潜在客户</option>
								<option value="已失去客户">已失去客户</option>
								
								</select>
								</td>
							</TR>
							
							<TR>
								
								<td>信息来源 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custSource">
								</td>
								<td>邮箱 ：</td>
								<td>
								<INPUT type="email" class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custEmail">
															                             
								</td>
							</TR>
							
							<TR>
								
								
								<td>固定电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custPhone">
								</td>
								<td>移动电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custMobile">
								</td>
								
								
							</TR>
							
							
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value=" 保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="<%=basePath%>/img/new_023.jpg">
					<IMG src="<%=basePath%>/img/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="<%=basePath%>/img/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="<%=basePath%>/img/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="<%=basePath%>/img/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>