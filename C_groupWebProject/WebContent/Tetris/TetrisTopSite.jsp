<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>テトリス風ゲーム入り口</title>
	<link href="TetrisTopSiteStylesheet.css" rel="stylesheet" type="text/css">
</head>

<body>
	<jsp:include page="/HEADER.jsp"/>

	<div class =main>
		<div class= "main-bg"></div>
		<div class= "main-logo">Tetrish</div>
		<div class="main-list">
			<ul>
			<li>テトリス風ゲーム</li>
			<li>ブロックを揃えて高得点を狙おう！</li>
			</ul>
		</div>
	</div>

<div class="level">
	<a href="TetrisEasyGameSite.html" class="btn">初級</a>
	<a href="TetrisNormalGameSite.html" class="btn">中級</a>
	<a href="TetrisHardGameSite.html" class="btn">上級</a>
</div>


</body>
</html>