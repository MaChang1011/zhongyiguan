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
				<div class="col-sm-12">
					<jsp:include page="../comm/breadcrumb.jsp"/>
					<div class="panel panel-default">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>序号</th>
									<th>医生姓名</th>
									<th>患者昵称</th>
									<th>患者等级</th>
									<th>预约时间</th>
									<th>状态</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${data.list }" var="entity" varStatus="status">
									<tr>
										<td>${status.index+1 }</td>
										<td>${entity.name }</td>
										<td>${entity.nickname }</td>
										<td>LV${entity.level }</td>
										<td><fmt:formatDate value="${entity.rvtTime }" pattern="yyyy-MM-dd"/></td>
										<td><c:choose>
												<c:when test="${entity.status==0 }">待确认</c:when>
												<c:when test="${entity.status==1 }">同意</c:when>
												<c:when test="${entity.status==2 }">拒绝</c:when>
											</c:choose>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<jsp:include page="../comm/pagin.jsp">
						<jsp:param value="doctor/reservation" name="url"/>
						<jsp:param value="${data.total }" name="total"/>
						<jsp:param value="${data.size }" name="size"/>
						<jsp:param value="${data.start }" name="start"/>
					</jsp:include>
				</div>
			</div>
		</div>
	</body>
</html>