<%@ page trimDirectiveWhitespaces="true" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:include page="comm/taglib.jsp"/>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<jsp:include page="comm/head.jsp"/>
	</head>
	<body>
		<div class="container">
			<div class="row col-sm-6 col-sm-6 col-sm-offset-3">
			<div class="panel panel-primary panel-login">
				<div class="panel-heading">系统登录</div>
				<div class="panel-body">
					<form class="form-horizontal" action="${ctx }/check" method="post" id="loginForm">
						<div class="form-group">
							<label for="nickname" class="col-sm-3 control-label">账号 ：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="nickname" name="nickname">
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-sm-3 control-label">密码：</label>
							<div class="col-sm-8">
								<input type="password" class="form-control" id="password" name="password">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-8">
								<button type="submit" class="btn btn-default pull-right">登录</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			</div>
		</div>
		<script>
			$(function() {
				$("#loginForm").validate({
					rules: {
						nickname: {
			                required: true
			            },
						password: {
			                required: true
			            }
					},
					invalidHandler : function(){
						return false;
					},
					submitHandler : function(){
						$.ajax({
							url: '${ctx }/auth',
							dataType: 'json',
							type: 'post',
							data: $('#loginForm').serialize(),
							success:function(data) {
								if(data.success) {
									window.location.href = '${ctx }/index';
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
