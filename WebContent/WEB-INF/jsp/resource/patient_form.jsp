<%@ page trimDirectiveWhitespaces="true" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session"/>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<jsp:include page="../comm/head.jsp"/>
		<script type="text/javascript" src="${ctx }/ueditor1_4_3/ueditor.config.js"></script>
	    <script type="text/javascript" src="${ctx }/ueditor1_4_3/ueditor.all.js"></script>
	</head>
	<body>
		<jsp:include page="../comm/topnav.jsp"/>
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<jsp:include page="../comm/breadcrumb.jsp"/>
					<form class="form-horizontal" action="${ctx }/patient/save" method="post" id="form">
						<input type="hidden" class="form-control" id="id" name="id" value="${entity.id }">
						<input type="hidden" class="form-control" id="status" name="status" value="${entity.status }">
						<div class="form-group">
							<label for="money" class="col-sm-2 control-label">案例标题：</label>
							<div class="col-sm-8">
							    <input type="money" class="form-control" id="money" name="money" value="${entity.money }">
							</div>
						</div>
						
					
						<div class="form-group">
							<label for="drug" class="col-sm-2 control-label">案例详情：</label>
							<div class="col-sm-8">
								<script id="container" id="drug" name="drug" type="text/plain">
									${entity.drug }
								</script>
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
		        var ue = UE.getEditor('container');
		        var $form = $("#form");
				$form.validate({
					rules: {
						money: {
			                required: false
			            },
			            
			            drug: {
			                required: true
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