﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>综合查询客户拜访记录</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/spring/crm/selectVisit"
		method="post">

		<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/img/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/img/new_020.jpg"
						 height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/img/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0 height=545>
			<TBODY>
				<TR>
					<TD width=15 background="${pageContext.request.contextPath }/img/new_022.jpg"><IMG
						src="${pageContext.request.contextPath }/img/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户拜访管理 &gt; 客户拜访记录查询</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
	<tr>
		<td>客户：</td>
		<td colspan="3">
			<select name="custName">
			      <option value="">--请选择--</option>
				<c:forEach items="${listCustomer }" var="customer">
					<option value="${customer.custName}">${customer.custName }</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	
	<tr>
		<td>用户：</td>
		<td colspan="3">
			<select name="username">
			   <option value="">--请选择--</option>
				<c:forEach items="${list}" var="user">
					<option value="${user.username}">${user.username }</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
	  <td>拜访时间：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="vtime">
								
								</td>
	</tr>
							<TR>
								<td>拜访地址：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="vaddress">
								</td>
								<td>拜访内容：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="vcontent">
								
								</td>
							</TR>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value="查询 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/img/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/img/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/img/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/img/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/img/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
