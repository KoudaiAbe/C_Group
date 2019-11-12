<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dustBoxGame.Beans"%>
<%
	Beans Beans = (Beans) request.getAttribute("Beans");
%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DustBox_GAME</title>
</head>
<link href="/C_groupWebProject/DustBoxGame/Css.css" rel="stylesheet" type="text/css">
<body>
	<div class="canvas">

		<%-- 	<c:set var="haikei" value="Beans.getLevel()" />--%>


		<%-- switch --%>
		<%
			String haikei;
			haikei = Beans.getLevel();
			switch (haikei) {
				case "1" :
		%>
		<img src="/C_groupWebProject/DustBoxGame/animation/haikyo.jpg">
		<%
			break;
				case "2" :
		%>
		<img src="/C_groupWebProject/DustBoxGame/animation/rojiura-animation.jpg">
		<%
			break;
				case "3" :
		%>
		<img src="/C_groupWebProject/DustBoxGame/animation/juutakugai.jpg">
		<%
			break;
			}
		%>

		<!--
		Level 1 廃墟    右下GoaL
		Level 2 路地裏  右寄り中心寄りGoaL
		Level 3 住宅街  右上GoaL
		-->

		<div class="button">
			<div id="timer1">
				<input type="submit" value="HIGTH" class="START1" onclick="start1()">
				<input type="submit" value="STOP" class="STOP1" onclick="stop1()">
			</div>
			<div id="heightA" class="gage"></div>

			<div id="timer2">
				<input type="submit" value="POWER" class="START2" onclick="start2()"><br>
				<input type="submit" value="STOP" class="STOP2" onclick="stop2()">
			</div>
			<div id="powerB" class="gage"></div>
		</div>

		<div class="POI">
		<input type="submit" value="Let's POI" onclick="POI()" >
		</div>

		<span class="target hidden">
		<img>
		</span>

	</div>

	<form style="visibility: hidden;" action="/C_groupWebProject/GameInspector" method="post">
		<input type="text" name="game" id="gameName">
		<input type="text" name="score" id="gameScore">
		<input type="text" name="url" id="gameTop">
	</form>

	<script type="text/javascript">
	var level = '<%=Beans.getLevel()%>';
	console.dir(level);
		</script>
	<script type="text/javascript" src="/C_groupWebProject/DustBoxGame/Gage.js"></script>

</body>