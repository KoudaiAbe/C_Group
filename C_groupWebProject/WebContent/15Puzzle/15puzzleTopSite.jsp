<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1" />
	<title>15ぱずる</title>
	<link href="15puzzleTopSite.css" rel="stylesheet" type="text/css">
	<link href="15puzzleBackGroundPicture.css" rel="stylesheet" type="text/css">
</head>

<body>
	<jsp:include page="/HEADER.jsp"/>
	<div class="backGround"></div>

	<div class="topText">
		<img src="15PuzzleTexture/TitleText.png" width="650" height="120" alt="15Puzzle"/>
		<h1 style="font-size: 4em;">15パズルへようこそ！</h1>
		<p>
			15パズルは４×４の１６マスのパネルの中で１５枚のタイルをスライドさせ、綺麗に並び替えるゲームです。<br>
			素早く丁寧に少ない手数で完成させ、高得点を狙いましょう！
		</p>
	</div>

	<div class="enterGame">
		<a href="15puzzleGameSite.html">
			<img src="15PuzzleTexture/PlayButton.png" width="241" height="81" alt=""/>
		</a>
		<p>
			ゲームのルールや高得点を取るコツはこの下にあります！<br>
			プレイ前に確認しておこう！
		</p>
	</div>

	<div class="explanationText">
		<h1>ゲームの進め方</h1>
		<p class="start">
			ゲーム画面へ進むと右のような画面が表示されます。<br>
			難易度選択のボタンを押すとゲームが開始されるので<br>
			準備が出来てから押しましょう！<br>
			レベルは３段階あり、レベルが高くなればなるほど<br>
			タイルを揃えるのに必要た手数が多くなります。<br>
			低いレベルはクリアも簡単ですが、クリアした時の得点も低くなります。<br>
			高得点を狙っている方や、パズルに自信がある人は<br>
			レベル３に挑戦してみてください！
			<br><br><br><br><br><br>
		</p>
		<img src="15PuzzleTexture/StartImg.png" width="350" height="600" alt="ゲームのスタート画面"/>

		<h1>ゲームのルール</h1>
		<p class="rule">
			ゲームが開始されると１５枚のタイルがバラバラに配置されます。<br>
			このタイルを１枚ずつ動かしていき、<br>
			左上から順に昇順に並び変えるとゲームクリアとなります。<br>
			動かすタイルの上下左右いずれかのマスが空いている必要があり、<br>
			１度に２枚動かしたり斜め移動やほかのタイルを超えての移動はできません。
			<br><br><br><br><br><br><br><br><br>
		</p>
		<img src="15PuzzleTexture/GameImg.png" width="350" height="600" alt="ゲーム画面"/>

		<h1>高得点のコツ</h1>
		<p class="tips">
			レベルが高くなるにつれてタイルの配置の複雑さが上がりますがスコアも多く取ることができます。<br>
			また、点数は完成までに掛かった時間と完成までにタイルを動かした回数が少ないほうが高くなります。<br>
			特にタイルを動かした回数はスコアにとても影響を与えるのでやみくもに動かさないようにしましょう。
			<br><br>
		</p>
	</div>
</body>

</html>
