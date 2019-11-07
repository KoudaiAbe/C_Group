<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	import="model.AccountBeans" %>
    <% AccountBeans account = (AccountBeans) session.getAttribute("accountBeans"); %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>LOGOUT</title>
	<style type="text/css">
	<!--
		.msgBox {
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
	
	<div class="msgBox">
		<p>
			<%= account.getName() %>さんのログアウト処理が<br>
			完了しました。
		</p>
		<p id="returnTimer" style="font-size: 15px;">/returnTimer/</p>
	</div>
	
	<% session.removeAttribute("account"); %>
	
	<script>
	(function(){
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
</body>

</html>