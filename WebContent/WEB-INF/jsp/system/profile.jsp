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
									<th>类型</th>
									<th>标题</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${data }" var="entity" varStatus="status">
									<tr>
										<td>${status.index+1 }</td>
										<td><c:choose>
											<c:when test="${entity.flag=='company' }">公司简介</c:when>
											<c:when test="${entity.flag=='service' }">服务简介</c:when>
										</c:choose></td>
										<td>${entity.title }</td>
										<td><a href="${ctx }/profile/edit/${entity.id }">修改</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>