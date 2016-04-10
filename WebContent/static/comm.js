var logout = function() {
	if(confirm('真的要退出系统吗？')) {
		window.location.href= g.ctx + "logout";
	}
};
var del = function(url) {
	if(confirm('真的要删除该条记录吗？')) {
		$.ajax({
			url: url,
			dataType: 'json',
			type: 'get',
			data: {},
			success:function(data) {
				if(data.success) {
					alert('删除成功');
					window.location.reload();
				}else {
					alert(data.msg);
				}
			},
			error:function() {
				
			}
		});
	}
};
var push = function(url) {
	if(confirm('确定要推送该条记录吗？')) {
		$.ajax({
			url: url,
			dataType: 'json',
			type: 'get',
			data: {},
			success:function(data) {
				alert('推送已发出');
			},
			error:function() {
				
			}
		});
	}
};