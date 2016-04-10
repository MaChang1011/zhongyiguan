<%@ page trimDirectiveWhitespaces="true" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session"/>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<jsp:include page="../comm/head.jsp"/>
	</head>
	<body>
		<jsp:include page="../comm/topnav.jsp"/>
		<div class="container">
			<div class="row">
				<%-- <jsp:include page="../comm/leftnav.jsp"/> --%>
				<div class="col-sm-12">
					<jsp:include page="../comm/breadcrumb.jsp"/>
					<div class="panel panel-default">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>序号</th>
									<th>用户昵称</th>
									<th>真实姓名</th>
									<th>手机号码</th>
									<th>用户类型</th>
									<th>等级</th>
									<!-- <th>性别</th>
									<th>身份证号</th>
									<th>单位</th>
									<th>职称</th> -->
									<th>注册日期</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${users.list }" var="user" varStatus="status">
									<tr>
										<td>${status.index+1 }</td>
										<td>${user.nickname }</td>
										<td>${user.name }</td>
										<td>${user.mobile }</td>
										<td><c:choose>
											<c:when test="${user.type==2 }">管理员</c:when>
											<c:when test="${user.type==1 }">医生</c:when>
											<c:when test="${user.type==0 }">患者</c:when>
										</c:choose></td>
										<td><c:choose>
											<c:when test="${user.type==2 }"></c:when>
											<c:otherwise>LV${user.level }</c:otherwise>
										</c:choose></td>
										<%-- <td><c:choose>
											<c:when test="${user.sex==1 }">男</c:when>
											<c:otherwise>女</c:otherwise>
										</c:choose></td>
										<td>${user.card }</td>
										<td>${user.company }</td>
										<td>${user.job }</td> --%>
										<td><fmt:formatDate value="${user.regtime }" pattern="yyyy-MM-dd"/></td>
										<td><a href="${ctx }/user/edit/${user.id }">修改</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<jsp:include page="../comm/pagin.jsp">
						<jsp:param value="user/index" name="url"/>
						<jsp:param value="${users.total }" name="total"/>
						<jsp:param value="${users.size }" name="size"/>
						<jsp:param value="${users.start }" name="start"/>
					</jsp:include>
				</div>
			</div>
		</div>
	</body>
</html>