<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>客户列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
$(function() {
	/*
	给全选添加click事件
	*/
	$("#selectAll").click(function() {
		/*
		1. 获取全选的状态
		*/
		var bool = $("#selectAll").attr("checked");
		/*
		2. 让所有条目的复选框与全选的状态同步
		*/
		setItemCheckBox(bool);
	});
	/*
	给所有条目的复选框添加click事件
	*/
	$(":checkbox[name=checkboxBtn]").click(function() {
		var all = $(":checkbox[name=checkboxBtn]").length;//所有条目的个数
		var select = $(":checkbox[name=checkboxBtn][checked=true]").length;//获取所有被选择条目的个数

		if(all == select) {//全都选中了
			$("#selectAll").attr("checked", true);//勾选全选复选框
			
		} else if(select == 0) {//谁都没有选中
			$("#selectAll").attr("checked", false);//取消全选
			
		} else {
			$("#selectAll").attr("checked", false);//取消全选
							
		}
		
	});
	
});
/*
 * 统一设置所有条目的复选按钮
 */
function setItemCheckBox(bool) {
	$(":checkbox[name=checkboxBtn]").attr("checked", bool);
}


/*
 * 发送邮箱
 */
function batchDelete() {
	// 1. 获取所有被选中条目的复选框
	// 2. 创建一数组，把所有被选中的复选框的值添加到数组中
	// 3. 指定location为CartItemServlet，参数method=batchDelete，参数cartItemIds=数组的toString()
	var cid= [];
	$(":checkbox[name=checkboxBtn][checked=true]").each(function() {
		cid.push($(this).val());//把复选框的值添加到数组中
		
	});
	if(cid.length == 0){
		alert("你还没有选择！");
	}
	
	location = "${pageContext.request.contextPath }/spring/crm/findCustomerBiIds?cid=" + cid;
}
</script>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id="customerForm" name="customerForm"
		action="${pageContext.request.contextPath }/spring/crm/customerScreen"
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
								<TD class=manageHead>当前位置：客户管理 &gt; 客户列表</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
							width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD height=25>
										<TABLE cellSpacing=0 cellPadding=2 border=0>
											<TBODY>
												<TR>
													<TD>客户名称：</TD>
													<TD><INPUT class=textbox id=sChannel2
														style="WIDTH: 80px" maxLength=50 name="custName"></TD>
													
													<TD><INPUT class=button id=sButton2 type=submit
														value=" 筛选 " name=sButton2></TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
							    
								<TR>
									<TD>
										<TABLE id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<td><input type="checkbox" id="selectAll" checked="checked"/><label for="selectAll">全选</label></td>
													<TD>客户名称</TD>
													<TD>客户状态</TD>
													<TD>客户来源</TD>
													
													<TD>电话</TD>
													<TD>手机</TD>
													<TD>邮箱</TD>
													<TD>操作</TD>
													<TD>邮箱发送</TD>
												</TR>
												<c:forEach items="${customer}" var="customer">
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<td><input value="${customer.cid }" type="checkbox" name="checkboxBtn" checked="checked"/ /></td>
													<TD>${customer.custName}</TD>
													<TD>${customer.custLevel }</TD>
													<TD>${customer.custSource }</TD>
													
													<TD>${customer.custPhone }</TD>
													<TD>${customer.custMobile }</TD>
													<TD>${customer.custEmail }</TD>
													<TD>
												<c:if test="${User.status eq 1 }">	  <a href="${pageContext.request.contextPath }/spring/crm/delCustomer/${customer.cid}" >删除</a>
													 
													  <a href="${pageContext.request.contextPath }/spring/crm/findCustomerById/${customer.cid}">修改</a> </c:if>
													 
													</TD>
													
													<td> <a href="${pageContext.request.contextPath }/spring/crm/sendMailPage/${customer.cid}">发送邮箱</a></td>
												</TR>
												
												</c:forEach>

<tr>
		<td colspan="4" class="tdBatchDelete">
			<a href="javascript:batchDelete();">发送邮箱</a>
		</td>
	
	</tr>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
				<!-- 
								<TR>
									<TD><SPAN id=pagelink>
											<DIV
												style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
												共[<B>${total}</B>]条记录,[<B>${totalPage}</B>]页
												,当前第[<b>${page}</b>]页
												[<A href="javascript:to_page(${page-1})">前一页</A>]
												[<A href="javascript:to_page(${page+1})">后一页</A>] 
												
												<input type="hidden" size="3" id="page" name="page" />
												
											</DIV>
									</SPAN></TD>
								</TR>
						                             -->
							</TBODY>
						</TABLE>
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/img/new_023.jpg"><IMG
						src="${pageContext.request.contextPath }/img/new_023.jpg" border=0></TD>
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
