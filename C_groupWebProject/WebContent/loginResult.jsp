<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<jsp:include page="/HEADER.html"/>

	<div class="textArea">
		<p id="resultText">/resultText/</p>
		<p id="returnTimer" style="font-size: 15px;">/returnTimer/</p>
	</div>

	<script type="text/javascript">
		(function(name, result) {
			let text = document.getElementById("resultText"),
				reText = document.getElementById("returnTimer");

			text.textContent = name +"さんの"+ result;

			let countSec = 3;

			const timer = () => {

				reText.textContent = countSec +"秒後にTOPへ移動します。";

				if (countSec != 0)
				{
					countSec--;
					setTimeout(timer, 1000);
				} else
				{　location.href = "index.jsp"; }
			};

			timer();
		})();
	</script>
</body>

</html>