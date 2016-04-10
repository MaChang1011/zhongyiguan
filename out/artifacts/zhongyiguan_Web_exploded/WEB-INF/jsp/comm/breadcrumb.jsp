<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ol class="breadcrumb">
	<c:forEach items="${current }" var="item" varStatus="status">  
		<li <c:if test="${status.last }">class="active"</c:if>>
			<c:choose>
				<c:when test="${item.parent==0 }">
					${item.name }
				</c:when>
				<c:otherwise>
					<a href="${ctx }/${item.url }">${item.name }</a>
				</c:otherwise>
			</c:choose>
		</li>
	</c:forEach>
</ol>