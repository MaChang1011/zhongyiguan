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
			<jsp:include page="../comm/breadcrumb.jsp"/>
			<div class="panel panel-default">
				<table class="table table-hover">
					<thead>
					<tr>
						<th>序号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>身份证</th>
						<th>公司</th>
						<th>职称</th>
						<th>等级</th>
						<th>预约时间段</th>
						<th>预约星期几</th>
						<th>预约地点</th>
						<th>审核状态</th>
						<!-- <th>操作</th> -->
					</tr>
					</thead>
					<tbody>
					<c:forEach items="${data.list }" var="entity" varStatus="status">
						<tr>
							<td>${status.index+1 }</td>
							<td>${entity.name }</td>
							<td><c:choose>
								<c:when test="${entity.sex==1 }">男</c:when>
								<c:otherwise>女</c:otherwise>
							</c:choose></td>
							<td>${entity.card }</td>
							<td>${entity.company }</td>
							<td>${entity.job }</td>
							<td>Lv${entity.level }</td>
							<td>${entity.startTime }~${entity.endTime }</td>
							<td>${entity.dayOfWeek }</td>
							<td>${entity.location }</td>
							<td><c:choose>
								<c:when test="${entity.d_check==0 }">待审核</c:when>
								<c:when test="${entity.d_check==1 }">通过</c:when>
								<c:when test="${entity.d_check==2 }">未通过</c:when>
							</c:choose></td>
								<%-- <td><a href="${ctx }/record/edit/${entity.id }">修改</a></td> --%>
							<td>
								<c:choose>
									<c:when test="${entity.d_check==0 }">
										<a href="javascript:aduit('${entity.id }', 1)" class="pdr5">通过</a>
										<a href="javascript:aduit('${entity.id }', 2)" class="pdr5">不通过</a>
									</c:when>
									<c:when test="${entity.d_check==1 }">
										<a href="javascript:aduit('${entity.id }', 2)" class="pdr5">不通过</a>
									</c:when>
									<c:when test="${entity.d_check==2 }">
										<a href="javascript:aduit('${entity.id }', 1)" class="pdr5">通过</a>
									</c:when>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<jsp:include page="../comm/pagin.jsp">
				<jsp:param value="record/index" name="url"/>
				<jsp:param value="${data.total }" name="total"/>
				<jsp:param value="${data.size }" name="size"/>
				<jsp:param value="${data.start }" name="start"/>
			</jsp:include>
		</div>
	</div>
</div>
<script>
	var aduit = function($id, $d_check) {
		$.ajax({
			url: '${ctx}/record/aduit',
			dataType: 'json',
			type: 'post',
			data: {'id':$id, 'd_check':$d_check},
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