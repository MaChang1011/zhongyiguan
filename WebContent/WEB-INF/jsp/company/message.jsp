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
					<jsp:include page="../comm/breadcrumb.jsp" />
					<jsp:include page="../comm/operation.jsp">
						<jsp:param value="${ctx }/message/add" name="url"/>
					</jsp:include>
					<div class="panel panel-default">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>序号</th>
									<th>资讯标题</th>
									<th>文章来源</th>
									<th>发布日期</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${messages.list }" var="entity" varStatus="status">
									<tr>
										<td>${status.index+1 }</td>
										<td>${entity.title }</td>
										<td>${entity.origin }</td>
										<td><fmt:formatDate value="${entity.pubtime }" pattern="yyyy-MM-dd"/></td>
										<td><a href="javascript:push('${ctx }/message/push/${entity.id }')" class="pdr20">推送</a>
											<a href="javascript:del('${ctx }/message/del/${entity.id }')" class="pdr20">删除</a>
											<a href="${ctx }/message/edit/${entity.id }" class="pdr20">修改</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<jsp:include page="../comm/pagin.jsp">
						<jsp:param value="message/index" name="url"/>
						<jsp:param value="${users.total }" name="total"/>
						<jsp:param value="${users.size }" name="size"/>
						<jsp:param value="${users.start }" name="start"/>
					</jsp:include>
				</div>
			</div>
		</div>
	</body>
</html>