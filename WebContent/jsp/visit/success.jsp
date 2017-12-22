<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	

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
			<tr>
				<TD width=15 background="${pageContext.request.contextPath }/img/new_022.jpg"><IMG
					src="${pageContext.request.contextPath }/img/new_022.jpg" border=0></TD>
				<TD vAlign=top width="100%" bgColor=#ffffff>
					<table width="100%" height=200 border="0" cellpadding="0"
						cellspacing="0">
						<tr>
							<td align="center" style="font-size: 14px;"><img
								src="${pageContext.request.contextPath }/img/yes.png"
								align="middle" height="30" width="30" />
							    <span style="vertical-align: middle">您的操作成功！</span>	
							</td>
						</tr>
					</table>
					
					<TABLE id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD>用户名称</TD>
													<TD>客户名称</TD>
													<TD>拜访地址</TD>
													<TD>拜访内容</TD>
													<TD>拜访时间</TD>
												
												</TR>
	<c:forEach items="${list}" var="visit">
	<TR
		style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
		<TD>
			${visit.username }
		</TD>
		<TD>
			${visit.custName }
		</TD>
		<TD>
			${visit.vaddress }
		</TD>
		<TD>
			${visit.vcontent }
		</TD>
		<TD>
			${visit.vtime }
		</TD>
		

</TR>

</c:forEach>

											</TBODY>
										</TABLE>
					
					
					
				</td>
				<TD width=15 background="${pageContext.request.contextPath }/img/new_023.jpg"><IMG
					src="${pageContext.request.contextPath }/img/new_023.jpg" border=0></TD>
			</tr>
		</TBODY>
	</table>
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
</BODY>
</HTML>
