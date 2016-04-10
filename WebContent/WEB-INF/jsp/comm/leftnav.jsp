<%@ page trimDirectiveWhitespaces="true" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <div class="col-sm-3">
		<div class="list-group">
			<a href="${ctx }/leave/index.do" class="list-group-item">测试</a>
			<a href="${ctx }/workflow/todo.do" class="list-group-item">测试</a>
		<%-- 	<c:forEach items="${children }" var="child">  
				<a href="${ctx }/${child.url }" class="list-group-item">${child.name }</a>
			</c:forEach>  --%>
		</div>
	</div>