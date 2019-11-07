/*
 * 4x4の16マスの中で15枚のタイルをスライドさせタイル番号を左上から昇順に並べ替えるゲーム。
 * 並べ替えが完了した時点でゲームクリアとなる。
 *
 * ・ゲームの難易度を3段階で設定することができ、難易度を選択した時点でゲームが開始される。
 * ・操作を行う各タイルにはイベントリスナーをセットし、クリックが行われた際に特定の処理を行う。
 * ・ゲーム中では常にプレイ時間とタイルの移動回数を監視し、常時ゲーム画面に表示させる。
 * ・ゲームクリア時に難易度、プレイ時間、移動回数を考慮した得点を算出する。
 */

'use strict';
{

	// ゲームの進行状況
	let result = false;

	// レベル選択ボタンの要素を取得
	const levels = [
		document.getElementById("startButton1"),
		document.getElementById("startButton2"),
		document.getElementById("startButton3")
	];

	/*const submits = Array.from(document.getElementsByClassName("submit"));*/
	const submits = [
		document.getElementById("restart"),
		document.getElementById("back")
	];

	// 表示するテキスト要素を取得
	const gameText = {
		level: document.getElementById("levelText"),
		time: document.getElementById("timeText"),
		count: document.getElementById("countText")
	};

	// レベルボタンにイベントリスナーを設定
	levels.forEach((array, index) => {
		array.addEventListener("click", function(e) {
			gameStart(index + 1);
		});
	});

	submits.forEach((array) => {
		console.log("リスナー");
		array.addEventListener("click", function(e) {
			submit();
		})
	});



	function gameStart(level)
	{	// レベルの選択ボタンが押されたら実行

        let canvas = document.getElementById("stage"),
			moveCount = level * (level + 7 + (level * (level - 1))),
			clickCount = 0,
        	context,
        	image,
        	tiles = new Array(4).fill(null).map(() => new Array(4).fill(null));

		const PIC_WIDTH = 280,
			  PIC_HEIGHT = 280,
			  START_MSEC = new Date(),
			  TILE_WIDTH = PIC_WIDTH / tiles.length,
			  TILE_HEIGHT = PIC_HEIGHT / tiles[0].length,
			  IMAGE_URL = "15PuzzleTexture/15Puzzle.png";

		// タイルの周囲を検索するためのインデックス定数
		const UDLR = [
			[ 0, -1],
			[ 0,  1],
			[-1,  0],
			[ 1,  0]
		];

		// ボタンオブジェクトを削除
		let element = document.getElementById("frontWindow");
		while (element.firstChild)
		{ element.removeChild(element.firstChild); }
		element.remove();

		if (!canvas.getContext)
		{	// もしcanvasに対応していなければ

            alert("Canvas not supported ...");
            return;

        }	// if end

		gameText.level.textContent = "Lv. "+ level;
		gameText.count.textContent = 0;

        context = canvas.getContext("2d");

        image = document.createElement("img");
        image.src = IMAGE_URL;

        image.addEventListener("load", function() {
            initTiles();
			moveBlank(moveCount);
            drawPuzzle();
			getTime("showTimer");
        });

		// クリックイベント
		canvas.addEventListener("click", function(e) {
			let x,
				y,
				rect,
				row,
				column,
				targetRow,
				targetColumn;

			rect = e.target.getBoundingClientRect();
			x = e.clientX - rect.left;
			y = e.clientY - rect.top;
			row = Math.floor(y / TILE_HEIGHT);
			column = Math.floor(x / TILE_WIDTH);

			// クリックされたものがスペースであれば何も処理しない
			if (tiles[row][column] === -1)
			{ return; }

			for (let i = 0; i < UDLR.length; i++)
			{	// クリックされたタイルの周囲を検索する

				targetRow = row + UDLR[i][1];
				targetColumn = column + UDLR[i][0];

				// タイルの周囲に空白がなければ別の場所を探す
				if (targetRow < 0 || targetRow >= tiles[0].length)
				{ continue; }
				if (targetColumn < 0 || targetColumn >= tiles.length)
				{ continue; }

				if (tiles[targetRow][targetColumn] == -1)
				{	// 周囲に空白があれば移動する

					clickCount++;
					tiles[targetRow][targetColumn] = tiles[row][column];
					tiles[row][column] = -1;
					drawPuzzle();
					gameText.count.textContent = clickCount;

					break;

				}	// if end
			}	// for end
		});

		/*
		 * ----------------------Function----------------------
		 */

        function initTiles()
		{	// タイルのイニシャライズ

            for (let row = 0; row < tiles[0].length; row++)
			{	// 行の繰り返し

                tiles[row] = [];

                for (let column = 0; column < tiles.length; column++)
				{	// 列の繰り返し

					tiles[row][column] = row * tiles.length + column;

				}	// for end
            }	// for end

			// 右下のタイルを-1とする
			tiles[tiles[0].length - 1][tiles.length - 1] = -1;

        }	// initTiles function end



		function moveBlank(count)
		{	// タイルをランダムで動かす

			let blankRow = tiles[0].length - 1,
				blankColumn = tiles.length - 1,
				covorNumber = -1;

			while(true)
			{

				// 入れ替え先をランダムで抽出
				let targetPosition = Math.floor(Math.random() * UDLR.length),
					targetRow = blankRow + UDLR[targetPosition][1],
					targetColumn = blankColumn + UDLR[targetPosition][0];

				// 直前と同じ動きであれば動かさずにやり直す
				if (targetPosition == covorNumber)
				{ continue; }
				else
				{ covorNumber = -1; }

				// 抽出先がエリア外であれば抽出し直し
				if (targetRow < 0 || targetRow >= tiles[0].length)
				{ continue; }
				if (targetColumn < 0 || targetColumn >= tiles.length)
				{ continue; }

				tiles[blankRow][blankColumn] = tiles[targetRow][targetColumn];
				tiles[targetRow][targetColumn] = -1;
				blankRow = targetRow;
				blankColumn = targetColumn;

				if (!--count)
				{ break; }

				// 次のタイルの移動を今回と繰り返さないようにする
				if (targetPosition % 2 == 0)
				{ covorNumber = targetPosition + 1; }
				else
				{ covorNumber = targetPosition - 1; }

			}	// while end
		}	// moveBlank function end



        function drawPuzzle()
		{	// パズルの描画

            for (let row = 0; row < tiles[0].length; row++)
			{	// 行の繰り返し

                for (let column = 0; column < tiles.length; column++)
				{	// 列の繰り返し

					let dx = column * TILE_WIDTH,
						dy = row * TILE_HEIGHT;

					if (tiles[row][column] == -1)
					{	// 右下のタイルであれば消す

						context.fillStyle = "#FFF";
						context.fillRect(dx, dy, TILE_WIDTH, TILE_HEIGHT);

					} else
					{	//右下のタイルでなければ描画

						let sx = (tiles[row][column] % tiles.length) * TILE_WIDTH,
							sy = Math.floor((tiles[row][column] / tiles[0].length)) * TILE_HEIGHT;

						context.drawImage(image, sx, sy, TILE_WIDTH, TILE_HEIGHT, dx, dy, TILE_WIDTH, TILE_HEIGHT);

					}	 // if end
                }	// for end
			}	// for end

			// 全てのタイルが正しい位置に属しているかをチェック
            if (checkResult())
            { getTime("gameClear"); }

        }	// drawPuzzle function end



		function checkResult()
		{	// タイルの位置の正誤チェック

			for (let row = 0; row < tiles[0].length; row++)
			{	// 行の繰り返し

				for (let column = 0; column < tiles.length; column++)
				{	// 列の繰り返し

					// タイルが正しい位置にあればtrue
					if (row == tiles[0].length - 1 && column == tiles.length - 1)
					{ return true; }

					// タイルが誤った位置にあればfalse
					if (tiles[row][column] != row * tiles.length + column)
					{ return false; }

				}	// for end
			}	// for end
		}	// checkResult function end




		function getTime(there)
		{	// ゲームのプレイ時間を取得

			let playTimeMsec = new Date() - START_MSEC,
				diffSec = Math.floor(playTimeMsec / 1000),
				diffMsec = playTimeMsec - (diffSec * 1000);

			switch (there)
			{	//	取得したプレイ時間を渡す宛先

				case "showTimer":
					showTimer(diffSec, ("000"+ diffMsec).slice(-3));
					break;

				case "gameClear":
					gameClear(playTimeMsec, diffSec, ("000"+ diffMsec).slice(-3));
					break;

				default:
					return playTimeMsec;

			}	// switch end
		}	// getTime function end



		function showTimer(sec, msec)
		{	// タイマーの表示

			if (!result)
			{	// ゲームが終了していなければ16m秒後に表示を更新

				gameText.time.textContent = `${sec}.${msec}`;
				setTimeout(() => {
				getTime("showTimer");
					}, 1);

			}	// if end
		}	// showTimer function end



		function gameClear(times, sec, msec)
		{	// ゲームの終了処理

			// タイマーを終了させる
			result = true;

			gameText.time.textContent = `${sec}.${msec}`;

            /* 得点の計算
             *
             * 得点の最大値は１０００点でレベル、時間、手数を考慮した減点方式とする。
             * レベル１の最大得点は４００点、レベル２の最大得点は７００点とする。
             * 手数を考慮した減点は各レベルの最小手数である"moveCount"と等しい、もしくはそれ以下で減点率を０％とし、
             * 手数が多くなるほどに減点率を上昇させ、手数の減点率最大値を７０％とする。
             * 時間を考慮した減点は時間が掛かるほどに反比例して減点を行い、時間の減点率最大値を３０％とする。
             * 最終的にレベルの最大得点から減点率を加算計算方式で合計し、端数切捨てで減点計算を行ったものを得点とする。
			 * 因みに得点の最大値は１０００点だがこれは理論値であり、人間がこの点数を取ることはまずない。
             */
            const levelPoints = () => {
                switch (level)
                {
                    case 1: return 400;
                    case 2: return 700;
                    case 3: return 1000;

                }	// switch end
            };
            console.log("れべるP"+ levelPoints());

            // 手数が最小値より大きければ比例して減点率を上げる
            let moveCheck = (clickCount / moveCount <= 1 ? 0 : clickCount / moveCount - 1),
                moveDeduction = (moveCheck * 25 > 70 ? 70 : moveCheck * 25);
            console.log("てかずD"+ moveDeduction);

			// 経過時間による反比例の減点計算
			// 減少率はレベルに応じて変化し、レベルが高い程最大減少率への到達は遅くなる
            let timeRateCalc = (times / 1000)**2 / (2 * (level**level * level)),
                timeDeduction = (timeRateCalc > 30 ? 30 : timeRateCalc);
            console.log("じかんD"+ timeDeduction);

			// 手数と経過時間により得点減少率を加算計算方式で合計し最大得点から減算する
            let points = Math.round(levelPoints() * (1 - ((moveDeduction + timeDeduction) / 100)));

			console.log(`Game Clear!\n\nプレイ時間:${sec}.${msec}秒\n移動回数:${clickCount}回\n得点:${points}`);

			// タイルを削除する
			canvas.remove();

			// ゲームクリア画面の生成
			// ゲーム開始時に要素を消したflontWindowを使いまわす
			const div = document.createElement("div"),
				  img = document.createElement("img"),
				  text = document.createElement("p");

			div.setAttribute("id", "frontWindow");
			img.src = "15PuzzleTexture/ClearText.png";
			img.alt = "ゲームクリア";
			text.innerHTML = '<font size="7">'+ points +'</font>点';

			document.getElementById("gameWindow").insertBefore(div, gameText.level);
			div.appendChild(img);
			div.appendChild(text);

		}	// gameClear function end
	}	// gameStart function end



	function submit()
	{	// ページ移動ボタンが押されたらゲームのデータを送信

		console.log("click");
		if (result)
		{	// ゲームが終了していればデータを送信する

			console.log("submit");
			document.getElementById("gameName").value = "15Puzzle";
			document.getElementById("gameScore").value = points;
			document.querySelector("form").submit();

		}	// if end
	}	// submit function end
}	/* EOF */