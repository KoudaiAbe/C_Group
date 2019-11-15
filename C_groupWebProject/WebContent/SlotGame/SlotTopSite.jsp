<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="SlotTopSite.css" type="text/css">
<title>スロットゲーム</title>
</head>
<body>
	<jsp:include page="/HEADER.jsp" />
	<div class="container">
		<div class="gazou">
			<h1>スロットゲーム</h1>
			<h2>ルール説明</h2>
			<p>
				<br>１．リールを回す。
				<br>２．STOPボタンを押して777が揃えば100ポイント獲得！！
				<br>３.777が揃わなかった時点でゲーム終了。
				<br><button class="btn" type="button"
						onclick="location.href='SlotGameSite.html'">START</button>
			</p>
		</div>
	</div>
</body>
</html>