<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>RANKING</title>
<link href="ranking.css" rel="stylesheet" type="text/css">
</head>

<body>
	<jsp:include page="/HEADER.jsp"/>

	<!--タブ-->
	<ul class="tab-group">
		<li class="tab">DustBoxGame</li>
		<li class="tab">15Puzzle</li>
		<li class="tab">StopWatch</li>
		<li class="tab">Tetris</li>
		<li class="tab">N/A</li>
	</ul>

	<!-- ランキングリスト（20位まで表示可） -->
	<div id="rankingList">
		<h1 style="margin-top: 100px;">ゲーム別ランキング</h1>
		<p>各ゲームのタブをクリックしてランキングを見てみよう！</p>
<!--
		<div class="list">
			<div class="box box-rank">1位：</div>
			<div class="box box-name">userAccount_ID16</div>
			<div class="box box-score"><font size="5">1000</font>pt</div>
			<div class="box box-date">9999/99/99</div>
		</div>
-->
	</div>

	<div id="mixdata_response">
	<!-- 結果を出力する -->
	</div>

	<script src="/C_groupWebProject/jquery-3.4.1.min.js"></script>
	<script>
	(function() {

		<%-- TODO スクリプトのgameをメソッドの引数として渡したい
		<% List<ScoreBeans> scoreList = logic.rankingLogic("test"); %> --%>

		document.addEventListener('DOMContentLoaded', function() {

			// タブに対してクリックイベントを適用
			const tabs = document.getElementsByClassName('tab');

			for (tab of tabs)
			{

				tab.addEventListener('click', function() {

					// タブのclassの値を変更
					let activeTAG = document.getElementsByClassName('is-active');
					if (activeTAG[0])
					{ activeTAG[0].classList.remove('is-active'); }
					this.classList.add('is-active');

					//サーバに送信するリクエストの設定
					$.ajax({
						type:'GET',
						url: '/C_groupWebProject/Score',
						data: {gameName: this.textContent},
						async: true,
						dataType: 'json',
						success : function(data) {
							//通信が成功した場合に受け取るメッセージ
							scoreList = {
									name: data["name"],
									score: data["score"],
									date: data["date"]
							};
							console.log(scoreList);
						},
						error : function(XMLHttpRequest, textStatus, errorThrown) {
							alert("リクエスト時になんらかのエラーが発生しました：" + textStatus +":\n" + errorThrown);
						}
					});

					// ランキングを表示させる関数を実行
					resetList();
					getRanking();

				}, false);

			}	// for end
		}, false);



		function getRanking()
		{	// ランキングを取得して表示する

 			/* document.querySelector("form").submit(); */

			let rankingList = document.getElementById("rankingList");

			for (let index = 0 ; index < 20 ; index++)
			{	// 20位から順にノードを作成

				// ノードの生成
				var listNode = document.createElement("div"),
					rankNode = document.createElement("div"),
					nameNode = document.createElement("div"),
					scoreNode = document.createElement("div"),
					dateNode = document.createElement("div");

				// ノードにクラスを追加
				listNode.classList.add("list");
				rankNode.classList.add("box", "box-rank");
				nameNode.classList.add("box", "box-name");
				scoreNode.classList.add("box", "box-score");
				dateNode.classList.add("box", "box-date")

				// ノードの内容を作成
				rankNode.textContent = (index + 1) +"位：";

				try
				{

					<%-- TODO スクリプトのindexをインデックスとして渡したい
					nameNode.textContent = <%= scoreList.get(index).getName() %>;
					scoreNode.innerHTML = '<font size="5">'+ <%= scoreList.get(index).getScore() %> + '</font>pt';
					dateNode.textContent = <%= scoreList.get(index).getDate() %>; --%>

 					throw new Error(); // とりあえずキャッチさせておく

				} catch (error)
				{	// リストが無ければ以下の表示

					nameNode.textContent = "--NONE--";
					scoreNode.innerHTML = '<font size="5">----</font>pt';
					dateNode.textContent = "----/--/--";

				}	// try end

				// ノードの配置
				rankingList.appendChild(listNode);
				listNode.appendChild(rankNode);
				listNode.appendChild(nameNode);
				listNode.appendChild(scoreNode);
				listNode.appendChild(dateNode);

			}	// for end
		}	// getRanking func end



		function resetList()
		{	// 表示されているランキングをリセットする

			let lists = document.getElementById("rankingList");

			while (lists.firstChild) lists.removeChild(lists.firstChild);

		}	// resetList func end

	})();
	</script>
</body>

</html>