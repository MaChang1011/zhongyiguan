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
				<%-- <jsp:include page="../comm/leftnav.jsp"/> --%>
				<div class="col-sm-12">
					<jsp:include page="../comm/breadcrumb.jsp"/>
					<form class="form-horizontal" action="${ctx }/user/save" method="post" id="userForm">
						<input type="hidden" class="form-control" id="id" name="id" value="${user.id }">
						<div class="form-group">
							<label for="nickname" class="col-sm-2 control-label">用户昵称：</label>
							<div class="col-sm-8">
							    <input type="text" class="form-control" id="nickname" name="nickname" value="${user.nickname }">
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="col-sm-2 control-label">真实姓名：</label>
							<div class="col-sm-8">
							    <input type="text" class="form-control" <c:if test="${user.type!=2 }">disabled="disabled"</c:if>
							    	id="name" name="name" value="${user.name }">
							</div>
						</div>
						<div class="form-group">
							<label for="mobile" class="col-sm-2 control-label">手机号码：</label>
							<div class="col-sm-8">
							    <input type="text" class="form-control" id="mobile" name="mobile" value="${user.mobile }" 
							    	<c:if test="${user.type!=2 }">disabled="disabled"</c:if>>
							</div>
						</div>
						<%-- <div class="form-group">
							<label for="sex" class="col-sm-2 control-label">性别：</label>
							<div class="col-sm-8">
								<select class="form-control" id="sex" name="sex">
									<option <c:if test="${user.sex==1 }">selected="selected"</c:if> value="1">男</option>
									<option <c:if test="${user.sex==0 }">selected="selected"</c:if> value="0">女</option>
								</select>
							</div>
						</div> --%>
						<div class="form-group">
							<label for="type" class="col-sm-2 control-label">用户类型：</label>
							<div class="col-sm-8">
								<select class="form-control" disabled="disabled" id="type" name="type">
									<option <c:if test="${user.type==2 }">selected="selected"</c:if> value="2">管理员</option>
									<option <c:if test="${user.type==1 }">selected="selected"</c:if> value="1">医生</option>
									<option <c:if test="${user.type==0 }">selected="selected"</c:if> value="0">患者</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="level" class="col-sm-2 control-label">等级：</label>
							<div class="col-sm-8">
							    <input type="number" class="form-control" id="level" name="level" 
							    	value="<c:if test="${user.type!=2 }">${user.level }</c:if>" 
							    	<c:if test="${user.type==2 }">disabled="disabled"</c:if>>
							</div>
						</div>
						<div class="form-group">
						    <div class="col-sm-offset-2 col-sm-8">
								<button type="submit" class="btn btn-default pull-right">保存</button>
						    </div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<script>
			$(function() {
				var $form = $("#userForm");
				$form.validate({
					rules: {
						nickname: {
			                required: true
			            },
						name: {
			                required: true
			            },
						mobile: {
			                required: true,
			                mobile: true,
			            }
					},
					invalidHandler : function(){
						return false;
					},
					submitHandler : function(){
						$.ajax({
							url: $form.attr('action'),
							dataType: 'json',
							type: 'post',
							data: $form.serialize(),
							success:function(data) {
								if(data.success) {
									alert('保存成功');
									window.location.href = data.msg;
								}else {
									alert(data.msg);
								}
							},
							error:function() {
								
							}
						});
						return false;
					}
				});
			});
		</script>
	</body>
</html>