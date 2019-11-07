<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="model.AccountBeans" %>
    <% AccountBeans account = (AccountBeans) session.getAttribute("accountBeans"); %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title></title>
	<style type="text/css">
	<!--
		body {
		margin: 0 auto;
		text-align: center;
		align-content: center;
		align-items: center;
		font-size: 1em;
		font-family: "ヒラギノ角ゴ Pro W3", "Hiragino Kaku Gothic Pro", "メイリオ", Meiryo, Osaka, "ＭＳ Ｐゴシック", "MS PGothic", "sans-serif";
		}

		.webCommon_Header {
		background-color: aqua;
		position: absolute;
		top: 0px;
		margin: 0px;
		width: 100%;
		height: 150px;
		z-index: 100;
		}

		.webCommon_Header > h1 {
			position:absolute;
			left: 50px;
			margin-top: 15px;
			text-align: left;
			font-size: 30pt;
		}

		.webCommon_Header > h2 {
			position:absolute;
			top: 10px;
			right: 50px;
			text-align: right;
			font-size: 15pt;
		}

		.webCommon_Header > .button {
			position:absolute;
			top: 100px;
			width: 100%;
			height: 50px;
			z-index: 101;
		}

		.webCommon_Header > .button > .btn-border {
			display: inline-block;
			width: 120px;
			height: 30px;
			margin: 0px 20px;
			text-align: center;
			border: 2px solid #9ec34b;
			font-size: 20px;
			color: #9ec34b;
			text-decoration: none;
			font-weight: bold;
			padding: 8px 16px;
			border-radius: 4px;
			transition: .4s;
		}

		.webCommon_Header > .button > .btn-border:hover {
			background-color: #9ec34b;
			border-color: #cbe585;
			color: #FFF;
		}

		.webCommon_Header > .button > .hidden {
			display: none;
		}
	-->
	</style>
</head>

<body>
	<%
	String name;
	boolean check;

	if (account == null)
	{

		check = false;
		name = "ゲスト";

	}
	else
	{

		check = true;
		name = account.getName();

	}
	%>
	<div class="webCommon_Header">
		<h1>ヘッドテキスト</h1>
		<h2>ようこそ<%= name %>さん！</h2>
		<div class="button">
			<a href="index.jsp" class="btn-border">HOME</a>
			<a href="mypage.jsp" class="btn-border">MY PAGE</a>
			<a href="ranking.jsp" class="btn-border">RANKING</a>
			<a href="login.jsp" class="btn-border" id="webCommon_login">LOGIN</a>
			<a href="logout.jsp" class="btn-border hidden" id="webCommon_logout">LOGOUT</a>
		</div>
	</div>

	<script>
		(function() {

			const login = document.getElementById("webCommon_login"),
				  logout = document.getElementById("webCommon_logout");

			if (<%= check %>)
			{	// ログインしていればLOGOUTボタンを表示

				console.log("accountUN_NULL");
				document.getElementsByClassName('hidden')[0].classList.remove('hidden');
				login.classList.add('hidden');

			} else
			{	// ログインしていなければLOGINボタンを表示

				console.log("accountNULL");
				document.getElementsByClassName('hidden')[0].classList.remove('hidden');
				logout.classList.add('hidden');

			}
		})();
	</script>
</body>

</html>