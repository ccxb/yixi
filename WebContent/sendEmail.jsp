<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>发送邮件给指定用户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/spring/crm/sendEmail"
		method=post>		
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
								<TD class=manageHead>当前位置：客户管理 &gt; 发送邮箱</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<TR>							
								<td>
								<font color="#FF0000">*</font> 收件人：
               <input type="text" name="" size="110" 
style="border-color: #878787; border-style: solid; border-top-width: 0px;border-right-width: 0px; border-bottom-width: 1px; border-left-width: 0px" value="${customer.custName }:${customer.custEmail}" >
					<input type="hidden" name="custEmail" value="${customer.custEmail}">		
								</td>
							</TR>
						
				<TR>							
								<td>
								<font color="#FF0000">*</font> 主 题：
               <input type="text" name="top" size="110" 
style="border-color: #878787; border-style: solid; border-top-width: 0px;border-right-width: 0px; border-bottom-width: 1px; border-left-width: 0px"  >
						
								</td>
							</TR>		
							
				<tr>
				<td>
						邮件内容：<br /><br/>
        <textarea rows="10" cols="120" name="text"></textarea>
						</td>
						</tr>		
						
							
						
							<tr>
								<td>
								<INPUT class=button id=sButton2 type=submit 
														value=" 发送 " name=sButton2 >
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