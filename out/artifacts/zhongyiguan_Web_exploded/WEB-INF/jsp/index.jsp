<%@ page trimDirectiveWhitespaces="true" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session"/>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<jsp:include page="comm/head.jsp"/>
	</head>
	<body>
		<jsp:include page="comm/topnav.jsp"/>
		<div class="container">
			<div class="row">
				<jsp:include page="comm/leftnav.jsp"/>
				<div class="col-sm-9">
					<ol class="breadcrumb">
						<li>主页</li>
					</ol>
				</div>
			</div>
		</div>
	</body>
</html>