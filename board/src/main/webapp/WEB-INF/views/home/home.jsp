<%--
  Created by IntelliJ IDEA.
  User: soft
  Date: 2018-08-12
  Time: 오후 4:56
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String contextPath = request.getContextPath(); %> <%--ContextPath 선언 --%>
<html>
<head>
	<link type="text/css" rel="stylesheet" href="<%=contextPath%>/resources/css/base.css" />
	<script type="text/javascript" src="<%=contextPath%>/resources/js/base.js" ></script>

</head>
<body>
	<p>게시판</p>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일자</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>2</td>
				<td>3</td>
				<td>5</td>
			</tr>
			<tr>
				<td>
					<button onclick="sampleFunction('1')" >1</button>
				</td>
				<td>
					<button onclick="inlineFunction('basicWrite')" >2</button>
				</td>
				<td>
					<button onclick="sampleFunction('3')" >3</button>
				</td>
				<td>
					<button onclick="sampleFunction('4')" >4</button>
				</td>
			</tr>
		</tbody>
	</table>
	<br>
	테스트중이며 띄어씌가 되는지 보자. 테스트중이며 띄어씌가 되는지 보자. 테스트중이며 띄어씌가 되는지 보자. 테스트중이며 띄어씌가 되는지 보자. 테스트중이며 띄어씌가 되는지 보자. 테스트중이며 띄어씌가 되는지 보자. 테스트중이며 띄어씌가 되는지 보자. 테스트중이며 띄어씌가 되는지 보자. 테스트중이며 띄어씌가 되는지 보자.
	<br>
	<div class="box-container">
		<div id="box1">static 박스</div>
		<div id="box2">relative 박스</div>
		<div id="box3">absolute 박스</div>
		<div id="box4">fixed 박스</div> <!-- '출력 결과' 란이 아닌, 전체 페이지에서 고정되어 보여짐 -->
	</div>

	</br>
	</br>
	<a href="#" onclick="bootstrapTheme();">bootstrap - theme</a>

	</br>
	</br>
	<a href="#" onclick="bootstrapGrid();">bootstrap - grid</a>

	</br>
	</br>
	<a href="#" onclick="bootstrapDashboard();">bootstrap - dashboard</a>

	<script type="text/javascript">
		var inlineVar = "inline Javascript sample - ";
		var inlineFunction = function (value) {
			location.href = '${pageContext.request.contextPath}' +"/content/" + value ;
		};

		var bootstrapTheme = function () {
            location.href = '${pageContext.request.contextPath}' +"/sample/bootstrap/theme";
		}

        var bootstrapGrid = function () {
            location.href = '${pageContext.request.contextPath}' +"/sample/bootstrap/grid";
        }

        var bootstrapDashboard = function () {
            location.href = '${pageContext.request.contextPath}' +"/sample/bootstrap/dashboard";
        }

	</script>
</body>
</html>