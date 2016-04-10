<%@ page trimDirectiveWhitespaces="true" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
					<jsp:include page="../comm/operation.jsp">
						<jsp:param value="${ctx }/product/add" name="url"/>
					</jsp:include>
					<div class="panel panel-default">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>序号</th>
									<th>标题</th>
									<th>商品名</th>
									<th>规格</th>
									<th>发布日期</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${data.list }" var="entity" varStatus="status">
									<tr>
										<td>${status.index+1 }</td>
										<td><c:choose>
											<c:when test="${fn:length(entity.title) > 15}">
												<c:out value="${fn:substring(entity.title, 0, 15)}..." />
											</c:when>
											<c:otherwise>
												<c:out value="${entity.title}" />
											</c:otherwise>
										</c:choose></td>
										<td>${entity.name }</td>
										<td><c:choose>
											<c:when test="${fn:length(entity.standard) > 20}">
												<c:out value="${fn:substring(entity.standard, 0, 20)}..." />
											</c:when>
											<c:otherwise>
												<c:out value="${entity.standard}" />
											</c:otherwise>
										</c:choose></td>
										<td><fmt:formatDate value="${entity.pubtime }" pattern="yyyy-MM-dd"/></td>
										<td><a href="javascript:push('${ctx }/product/push/${entity.id }')" class="pdr20">推送</a>
											<a href="javascript:del('${ctx }/product/del/${entity.id }')" class="pdr20">删除</a>
											<a href="${ctx }/product/edit/${entity.id }" class="pdr20">修改</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<jsp:include page="../comm/pagin.jsp">
						<jsp:param value="product/index" name="url"/>
						<jsp:param value="${users.total }" name="total"/>
						<jsp:param value="${users.size }" name="size"/>
						<jsp:param value="${users.start }" name="start"/>
					</jsp:include>
				</div>
			</div>
		</div>
	</body>
</html>