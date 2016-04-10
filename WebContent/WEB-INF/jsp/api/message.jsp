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
				<div class="col-xs-12 mp15 tc title">${entity.title }</div>
				<div class="col-xs-12 mp10 tc">
					<span class="plr5"><fmt:formatDate value="${entity.pubtime }" pattern="yyyy-MM-dd"/></span>
					<span class="plr5">来源：${entity.origin }</span>
				</div>
				<div class="col-xs-12">${entity.content }</div>
			</div>
		</div>
		<script>
			$(function() {
				$("img").addClass("carousel-inner img-responsive img-rounded"); 
			});
		</script>
	</body>
</html>