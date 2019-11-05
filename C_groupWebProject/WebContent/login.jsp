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
	<link href="login.css" rel="stylesheet" type="text/css">
</head>

<body>
	<jsp:include page="/HEADER.jsp"/>

	<!--タブ-->
	<ul class="tab-group">
		<li class="tab tab-A is-active">LOGIN</li>
		<li class="tab tab-B">REGIST</li>
	</ul>

	<!--タブを切り替えて表示するコンテンツ-->
    <div class="panel-group">
		<div class="panel tab-A is-show">
			<form action="../src/servlet/Login.java" method="get">
				<div id="errorText" style="color: red;"></div>
				ユーザ名　 ：<input type="text" name="name"><br>
				パスワード：<input type="password" name="pass"><br>
				<input type="submit" name="login" value="ログイン！">
			</form>
		</div>

		<div class="panel tab-B">
			<form action="../src/servlet/Login.java" method="post">
				<div id="errorText" style="color: red;"></div>
				ユーザ名　 ：<input type="text" name="name"><br>
				パスワード：<input type="password" name="pass"><br>
				（確認）　：<input type="password" name="checkPass"><br>
				<input type="submit" name="regist" value="アカウント作成！">
			</form>
		</div>
	</div>

	<script type="text/javascript">
		(function() {
			document.addEventListener('DOMContentLoaded', function() {
				// タブに対してクリックイベントを適用
				const tabs = document.getElementsByClassName('tab');

				for (let i = 0; i < tabs.length; i++)
				{ tabs[i].addEventListener('click', tabSwitch, false); }

				function tabSwitch()
				{	// タブの切り替え

					// タブのclassの値を変更
					document.getElementsByClassName('is-active')[0].classList.remove('is-active');
					this.classList.add('is-active');

					// コンテンツのclassの値を変更
					document.getElementsByClassName('is-show')[0].classList.remove('is-show');
					const arrayTabs = Array.prototype.slice.call(tabs);
					const index = arrayTabs.indexOf(this);
					document.getElementsByClassName('panel')[index].classList.add('is-show');
				};
			});

			if (action != null)
			{	// リダイレクトされた時のエラーメッセージ

				let msg;

				switch (action)
				{	// 新規作成ORログイン

					case "get":
						msg = "ユーザ名もしくはパスワードが間違っています。";
						break;

					case "post":
						msg = "このユーザ名は既に使用されています。";
						break;

				}	// switch end

				// エラーテキストの表示
				let text = document.getElementById("errorText");
				const p = document.createElement("p");
				p.textContent = msg;
				text.appendChild(p);

			}	// if end
		})();
	</script>
	<% session.removeAttribute("result"); %>
</body>

</html>
