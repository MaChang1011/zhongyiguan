<%@ page trimDirectiveWhitespaces="true" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">合药堂后台管理系统</a>
				</div>
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="${ctx }/index">主页 </a></li>
						<c:forEach items="${modules }" var="module">  
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${module.name }<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<c:forEach items="${module.children }" var="child">
										<c:if test="${not empty child.url }">
											<li><a href="${ctx }/${child.url }">${child.name }</a></li>
										</c:if>
									</c:forEach>
								</ul>
					        </li>
						</c:forEach>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#" style="font-weight:bold;">${sessionScope.user.name }</a></li>
						<li><a href="javascript:logout();" style="font-weight:bold;color:#999;">退出</a></li>
					</ul>
			    </div>
			</div>
		</nav>