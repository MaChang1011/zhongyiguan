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
						<jsp:param value="${ctx }/patient/add" name="url"/>
					</jsp:include>
					<div class="panel panel-default">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>序号</th>
									<th>案例标题</th>
									<th>案例分类</th>
									<th>作者姓名</th>
									<th>作者类型</th>
									<th>审核状态</th>
									<th>发布日期</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${data.list }" var="entity" varStatus="status">
									<tr>
										<td>${status.index+1 }</td>
										<td><c:choose>
											<c:when test="${entity.status==0 }">待审核</c:when>
											<c:when test="${entity.status==10 }">通过</c:when>
											<c:when test="${entity.status==20 }">未通过</c:when>
										</c:choose></td>
										<td><fmt:formatDate value="${entity.pubtime }" pattern="yyyy-MM-dd"/></td>
										<td>
											<a href="${ctx }/patient/detail/${entity.id }" target="_blank" class="pdr5">详情</a>
											<a href="${ctx }/patient/edit/${entity.id }" class="pdr5">修改</a>
											<c:choose>
												<c:when test="${entity.status==0 }">
													<a href="javascript:aduit('${entity.id }', 10)" class="pdr5">通过</a>
													<a href="javascript:aduit('${entity.id }', 20)" class="pdr5">不通过</a>
												</c:when>
												<c:when test="${entity.status==10 }">
													<a href="javascript:aduit('${entity.id }', 20)" class="pdr5">不通过</a>
												</c:when>
												<c:when test="${entity.status==20 }">
													<a href="javascript:aduit('${entity.id }', 10)" class="pdr5">通过</a>
												</c:when>
											</c:choose>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<jsp:include page="../comm/pagin.jsp">
						<jsp:param value="patient/index" name="url"/>
						<jsp:param value="${users.total }" name="total"/>
						<jsp:param value="${users.size }" name="size"/>
						<jsp:param value="${users.start }" name="start"/>
					</jsp:include>
				</div>
			</div>
		</div>
		<script>
			var aduit = function($id, $status) {
				$.ajax({
					url: '${ctx}/case/aduit',
					dataType: 'json',
					type: 'post',
					data: {'id':$id, 'status':$status},
					success:function(data) {
						if(data.success) {
							alert('操作成功');
							window.location.reload();
						}else {
							alert(data.msg);
						}
					},
					error:function() {
						
					}
				});
			};
		</script>
	</body>
</html>