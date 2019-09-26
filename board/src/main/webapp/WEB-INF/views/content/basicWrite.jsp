<%--
  Created by IntelliJ IDEA.
  User: soft
  Date: 2018-08-15
  Time: 오후 4:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>${title}</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/base.js" ></script>
</head>
<body>
<h1>${subject}</h1>
<div style="background: black; height: 3px"></div>
<br>
${content}

테스트중이며띄어씌가가되는지보자.테스트중이며띄어씌가가되는지보자.
<br>
<br>
<br>
<input type="button" value="돌아가기" onclick="back()">
<script type="text/javascript" >
	var back = function() {
		location.href = _contextPath + "/../../";
	};
</script>
</body>
</html>
