<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${param.size>1 }">
	<nav>
		<ul class="pagination pull-right">
			<li>
				<c:choose>
					<c:when test="${param.start>1 }">
						<a href="${ctx }/${param.url }?start=${param.start-1 }" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</a>
					</c:when>
					<c:otherwise>
						<a href="#" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</a>
					</c:otherwise>
				</c:choose>
			</li>
			<c:forEach var="pageIndex" begin="1" end="${param.size }" step="1">
				<li <c:if test="${param.start==pageIndex }">class="active"</c:if>><a href="${ctx }/${param.url }?start=${pageIndex }">${pageIndex }</a></li>
			</c:forEach>
			<li>
				<c:choose>
					<c:when test="${param.start<param.size }">
						<a href="${ctx }/${param.url }?start=${param.start+1 }" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
					</c:when>
					<c:otherwise>
						<a href="#" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
					</c:otherwise>
				</c:choose>
			</li>
		</ul>
	</nav>
</c:if>