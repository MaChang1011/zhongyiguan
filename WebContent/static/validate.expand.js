jQuery.validator.addMethod("mobile", function(value, element) {   
	var tel = /^1[3|4|5|6|7|8]\d{9}$/;
    return this.optional(element) || (tel.test(value));
}, "请正确的手机号码");
