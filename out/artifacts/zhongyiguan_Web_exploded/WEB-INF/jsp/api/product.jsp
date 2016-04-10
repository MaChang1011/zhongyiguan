<%@ page trimDirectiveWhitespaces="true" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session"/>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<jsp:include page="../comm/head_api.jsp">
			<jsp:param value="${entity.title }" name="title"/>
		</jsp:include>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-xs-4 mp15">
					<img src="${ctx }/${entity.image }" alt="" class="img-rounded wh100">
				</div>
				<div class="col-xs-8 mp15">
					<p>${entity.title }</p>
					<p><span class="t">商品名</span>${entity.name }</p>
					<p><span class="t">规&nbsp;&nbsp;&nbsp;&nbsp;格</span>${entity.standard }</p>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">${entity.descr }</div>
			</div>
		</div>
	</body>
</html>