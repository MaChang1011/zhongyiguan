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
	    <script type="text/javascript" src="${ctx }/static/ajaxfileupload.js"></script>
	</head>
	<body>
		<jsp:include page="../comm/topnav.jsp"/>
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<jsp:include page="../comm/breadcrumb.jsp"/>
					<form class="form-horizontal" action="${ctx }/comm/upload" method="post" id="upfile" enctype="multipart/form-data">
						<div class="form-group">
							<label for="file" class="col-sm-2 control-label">资讯图片：</label>
							<div class="col-sm-3">
							    <input type="file" id="file" name="file" >
								<button type="button" onclick="msgFileUpload(this.form.id, 'file')" class="mp15">上传</button>
							</div>
							<div class="col-sm-5">
								<c:choose>
									<c:when test="${entity.image and entity.image!='' }">
										<img src="${ctx }/${entity.image }" id="prevImage" class="img-rounded wh100">
									</c:when>
									<c:otherwise>
										<img src="${ctx }/uploads/default/001.png" id="prevImage" class="img-rounded wh100">
									</c:otherwise>
								</c:choose>
						    </div>
						</div>
					</form>
					
					<form class="form-horizontal" action="${ctx }/message/save" method="post" id="messageForm">
						<input type="hidden" class="form-control" id="id" name="id" value="${entity.id }">
						<div class="form-group">
							<label for="title" class="col-sm-2 control-label">资讯标题：</label>
							<div class="col-sm-8">
							    <input type="text" class="form-control" id="title" name="title" value="${entity.title }">
							</div>
						</div>
						<div class="form-group" style="display:none;">
							<label for="name" class="col-sm-2 control-label">资讯图片：</label>
					    	<div class="col-sm-8">
							    <input type="text" class="form-control" id="image" name="image" value="${entity.image }">
							</div>
						</div>
						<div class="form-group">
							<label for="origin" class="col-sm-2 control-label">资讯来源：</label>
							<div class="col-sm-8">
							    <input type="text" class="form-control" id="origin" name="origin" value="${entity.origin }">
							</div>
						</div>
						<div class="form-group">
							<label for="content" class="col-sm-2 control-label">资讯内容：</label>
							<div class="col-sm-8">
								<script id="container" id="content" name="content" type="text/plain">
									${entity.content }
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
	        function msgFileUpload(frm, field) {
				var f = $("#" + frm);
				$.ajaxFileUpload({
					url : f.attr('action'),
					secureuri : false,
					fileElementId : field,
					dataType : 'text',
					success : function(data, status) {    
						$("#image").attr('value', data);
						$("#prevImage").attr('src', '${ctx}/' + data.replace(/\\/g, '/'));
					},
					error : function(data, status, e) {
					    alert('图片上传失败');
					}
				});
			}
        
			$(function() {
		        UE.getEditor('container');
		        var $form = $("#messageForm");
				$form.validate({
					rules: {
						title: {
			                required: false
			            },
			            origin: {
			                required: true
			            },
						content: {
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