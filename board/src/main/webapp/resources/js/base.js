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
