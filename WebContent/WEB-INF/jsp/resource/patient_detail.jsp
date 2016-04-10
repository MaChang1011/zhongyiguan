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
					<form class="form-horizontal" action="${ctx }/patient/save" method="post" id="form">
						<input type="hidden" class="form-control" id="id" name="id" value="${entity.id }">
						<div class="form-group">
							<label for="money" class="col-sm-2 control-label">案例标题：</label>
							<div class="col-sm-8">${entity."money" }</div>
						</div>

						<div class="form-group">
							<label for="drug" class="col-sm-2 control-label">案例详情：</label>
							
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>