<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="model.AccountBeans" %>
    <% AccountBeans account = (AccountBeans) session.getAttribute("accountBeans"); %>
    <% String action = (String) session.getAttribute("action"); %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>LOGIN</title>
	<style type="text/css">
	<!--
		.textArea {
			position: absolute;
			border: solid 1px #CCC;
			border-top: none;
			background: #D0F08A;
			text-align: center;
			top: 300px;
			left: 0px;
			right: 0px;
			margin: 0px auto;
			width: 400px;
			height: 200px;
			line-height: 2em;
		}
	-->
	</style>
</head>

<body>
	<jsp:include page="/HEADER.jsp"/>

	<div class="textArea">
		<p id="resultText">/resultText/</p>
		<p id="returnTimer" style="font-size: 15px;">/returnTimer/</p>
	</div>

	<script>
	(function() {
		let text = document.getElementById("resultText"),
			reText = document.getElementById("returnTimer"),
			result;

		let name = '<%= account.getName() %>';
		let action = '<%= action %>';

		switch (action)
		{	// 新規作成ORログイン

			case "Get":
				result = "ログインが完了しました。";
				break;

			case "Post":
				result = "登録が完了しました。";
				break;

		}	// switch end

		// ログインorレジストの結果とアカウント名の表示
		text.textContent = name +"さんの"+ result;

		let countSec = 3;

		// 3秒後にTOPページへ移動
		const timer = () => {

			// カウントダウンテキストの表示
			reText.textContent = countSec +"秒後にTOPへ移動します。";

			if (countSec != 0)
			{
				countSec--;
				setTimeout(timer, 1000);
			} else
			{ location.href = "index.jsp"; }
		};

		timer();
	})();
	</script>
	<% session.removeAttribute("action"); %>
</body>

</html>