<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カウントゲームの紹介</title>
<link href="stopwatchgameTopSite.css" rel="stylesheet" type="text/css">
</head>
<body>

	<jsp:include page="/HEADER.jsp" />

	<div class="container">
		<p>スタートボタンを押して心の中で10秒数えて10.000ピッタリで止める ただそれだけだ…</p>
		<p>
			<button class="btn" type="button"
				onclick="location.href='stopwatchgameGameSite.html'">ゲームスタート</button>
		</p>
	</div>
</body>
</html>