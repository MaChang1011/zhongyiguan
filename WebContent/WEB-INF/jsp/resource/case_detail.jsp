<%@ page trimDirectiveWhitespaces="true" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session"/>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<jsp:include page="../comm/head.jsp"/>
		<script type="text/javascript" src="${ctx }/ueditor1_4_3/ueditor.config.js"></script>
	    <script type="text/javascript" src="${ctx }/ueditor1_4_3/ueditor.all.js"></script>
	</head>
	<body>
		<jsp:include page="../comm/topnav.jsp"/>
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<jsp:include page="../comm/breadcrumb.jsp"/>
					<form class="form-horizontal" action="${ctx }/case/save" method="post" id="form">
						<input type="hidden" class="form-control" id="id" name="id" value="${entity.id }">
						<div class="form-group">
							<label for="title" class="col-sm-2 control-label">案例标题：</label>
							<div class="col-sm-8">${entity.title }</div>
						</div>
						
						<div class="form-group">
							<label for="category" class="col-sm-2 control-label">案例分类：</label>
							<div class="col-sm-8">
								<c:if test="${entity.category==10 }">经典案例</c:if>
								<c:if test="${entity.category==20 }">心血之家</c:if>
							</div>
						</div>
						<div class="form-group">
							<label for="content" class="col-sm-2 control-label">案例详情：</label>
							<div class="col-sm-8">${entity.content }</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>