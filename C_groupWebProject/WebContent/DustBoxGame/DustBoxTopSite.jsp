<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DustBoxTopSite</title>
<style type="text/css">
	input[type="submit"]{
		width:200px;
		height:90px;
		color: #ffff00;
		background-color:#000000;
		font-size:40px;
		border-radius: 10px;
		margin: 0px 40px;
	}
	button[type="button"]{
		width:200px;
		height:90px;
		color: #ffff00;
		background-color:#000000;
		font-size:40px;
		border-radius: 10px;
		margin: 0px 40px;
	}
	.geomsize{
		width: 2em;
   		height: 2em;
	}

	.Level{
		display:flex;
		justify-content:center;
		font-size:40px;
	}

</style>
</head>
<body>
<jsp:include page="/HEADER.jsp"/>
<div class="top" align="center" style="margin-top:180px;">
<img src="animation/top.png" alt="写真" width="600px" height="300px"><br>
<font size="6">Levelを選択してスタート!!</font>

<div class="Level">
<form action="/C_groupWebProject/DustBoxGame" method="get">
<input type="radio" name="level" value="1" class="geomsize" checked="checked">Level_1
<input type="radio" name="level" value="2" class="geomsize">Level_2
<input type="radio" name="level" value="3" class="geomsize">Level_3<br>
<a href="HowTo.html"><button type="button">HOW TO</button></a>
<input type="submit" value="START"></form>
</div>

</div>
</body>
</html>