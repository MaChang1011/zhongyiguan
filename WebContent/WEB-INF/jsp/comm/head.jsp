<%@ page trimDirectiveWhitespaces="true" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>好心人后台管理系统</title>
		<!-- Bootstrap -->
		<link href="${ctx}/bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet">
		<link href="${ctx}/static/styles.css" rel="stylesheet">
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="${ctx}/static/jquery-1.11.3.min.js"></script>
		<script src="${ctx}/static/comm.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="${ctx}/bootstrap-3.3.5/js/bootstrap.min.js"></script>
		<script src="${ctx}/static/jquery.validate.js"></script>
		<script src="${ctx}/static/validate.expand.js"></script>
		<script src="${ctx}/static/messages_zh.js"></script>
		<!--[if lt IE 9]>
		  <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		  <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
		<script>
			var g = {
				ctx : "${ctx}/"
			};
			$(function() {
				if('${param.s}'=='true') {
					alert('操作成功');
				}
			});
		</script>