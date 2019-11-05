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
			top: 250px;
			left: 0px;
			right: 0px;
			margin: 0px auto;
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

	<script type="text/javascript">
		(function() {
			let text = document.getElementById("resultText"),
				reText = document.getElementById("returnTimer"),
				name = <%= account.getName() %>;
				result;

			switch (<%= action %>)
			{	// 新規作成ORログイン

				case "get":
					result = "ログインが完了しました。";
					break;

				case "post":
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
	<% session.removeAttribute("result"); %>
</body>

</html>