var ajaxJT = function (url, data) {
	$.ajax({
		type: 'POST',
		contentType: "application/json",
		url: url,
		dataType: 'text',
		data:  data,
		success: function (result) {
			alert('success : \n' + result);
		},
		error: function (err) {
			alert('error : \n' + err);
		}
	});
};

var ajaxJJ = function (url, data) {
	$.ajax({
		type: 'POST',
		contentType: "application/json",
		url:url,
		dataType: 'json',
		data: data,
		success: function (result) {
			alert('success : \n' + result);
		},
		error: function (e) {
			alert('error : \n' + e);
		}
	});
};


// 동기식 Ajax 사용
$.ajaxNotUseASync = function(url, reqData){
	if(typeof url === 'undefined') {
		return;
	};

	var result = {};

	$.ajax({
		url: url,
		type: 'post',
		contentType: "application/json; charset=UTF-8",
		dataType: 'json',
		data: JSON.stringify(reqData),
		async: false,
		success: function (data) {
			result = data;
		}
	});

	alert('result = ' + JSON.stringify(result));
	return result;
};

// 비동기식 Ajax 사용
$.ajaxASync = function(url, reqData, succCallback){
	if(typeof data === 'undefined') {
		return;
	}

	$.ajax({
		url: url,
		type: 'post',
		contentType: "application/json; charset=UTF-8",
		dataType: 'json',
		data: JSON.stringify(reqData),
		// async: false,            // 기본값은 true 임
		success: function (data) {
			var result = data;
			succCallback(result);
		}
	});

};