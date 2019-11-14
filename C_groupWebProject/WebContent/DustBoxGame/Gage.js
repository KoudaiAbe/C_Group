let a,b;

var x = 900;
var y = 700;

var timer1 = document.getElementById("timer1");
function start1(){
	console.log("start1");	// DEBUG
	timer1.style.height = "0px"; // ←widthを0pxにすることで減っていくアニメーションが始まる。
}
function stop1(){
	console.log("stop1");	// DEBUG
	a = timer1.offsetHeight;
	timer1.style.height = a + "px"; // ←停止の為に、現在の幅をheightに与える。
	console.log("a:"+ a);

}

var timer2 = document.getElementById("timer2");
function start2(){
	console.log("start2");	// DEBUG
	timer2.style.width = "0px"; // ←widthを0pxにすることで減っていくアニメーションが始まる。
}
function stop2(){
	console.log("stop2");	// DEBUG
	b = timer2.offsetWidth;
	timer2.style.width = b + "px"; // ←停止の為に、現在の幅をwidthに与える。
	console.log("b"+ b);
}


function POI() {

	if (!a || !b)
	{ return; }

	let msgIndex;

	const scores = [
		300,  //Level1のMaxスコア
		600,  //Level2のMaxスコア
		1000  //Level3のMaxスコア
	];

	// column:level row:a,b
	const positions = [
		[100,750], //Level1のGOALポジション
		[250,450], //Level2のGOALポジション
		[450,800]  //Level3のGOALポジション
		];

//		X1 :(a1=100,b1=750)(a-a1)+(b-b1)-300
//		X2 :(a2=250,b2=450)(a-a2)+(b-b2)-600
//		X3 :(a3=450,b3=800)(a-a3)+(b-b3)-1000

	const msg = [
			"ポイ捨て禁止だぞ！",
			"おしい！あと少し！",
			"GOAL!!ゴミ捨て完了！"
	];

	const anime = {

			out:"/C_groupWebProject/DustBoxGame/animation/animation-out.gif",
			lv1 : {
					goal:"/C_groupWebProject/DustBoxGame/animation/haikyo-animation-in.gif",
					miss:"/C_groupWebProject/DustBoxGame/animation/haikyo-animation-out.gif"
			},
			lv2 : {
					goal:"/C_groupWebProject/DustBoxGame/animation/rojiura-animation-in.gif",
					miss:"/C_groupWebProject/DustBoxGame/animation/rojiura-animation-out.gif"
			},
			lv3 : {
					goal:"/C_groupWebProject/DustBoxGame/animation/juutakugai-animation-in.gif",
					miss:"/C_groupWebProject/DustBoxGame/animation/juutakugai-animation-out.gif"
			},
	};

//	const renge = (dis, low, high) => (dis >= low) && (dis < high);
//	// renge(a, 0, 180) aが0から180内であればTRUE

	let target = document.getElementsByClassName("hidden");
	target[0].classList.remove("hidden");

	//resultIDにimgタグを作成
	const img = document.getElementsByClassName("target")[0].querySelector("img");

	//anime.out; OUTのアニメーション
	//anime.lv1.goal; Lv1のゴールアニメーション


	//条件式
	switch(level){
	case "1"://Level 1 廃墟    右下GoaL  //a 高加減 400px  b 力加減 630px

		if(a >= 0 && a < 150){
			if(b >= 0 && b < 210){
				img.src = anime.out;
				msgIndex = 0 ;
				console.log("1-1 out");
			}else if(b >= 210 && b < 420){
				img.src = anime.lv1.miss;
				msgIndex = 1 ;
				console.log("1-1 miss");
			}else if(b >= 420 && b < 630){
				img.src = anime.lv1.goal;
				msgIndex = 2 ;
				console.log("1-1 in");
			}
		}
		if(a >= 150 && a < 275){
			if(b >= 0 && b < 210){
				img.src = anime.out;
				msgIndex = 0 ;
				console.log("1-2 out");
			}else if(b >= 210 && b < 420){
				img.src = anime.out;
				msgIndex = 0 ;
				console.log("1-2 out");
			}else if(b >= 420 && b < 630){
				img.src = anime.lv1.miss;
				msgIndex = 1 ;
				console.log("1-2 miss");
			}
		}
		if(a >= 275 && a < 400){
			if(b >= 0 && b < 210){
				img.src = anime.out;
				msgIndex = 0 ;
				console.log("1-3 out");
			}else if(b >= 210 && b < 420){
				img.src = anime.out;
				msgIndex = 0 ;
				console.log("1-3 out");
			}else if(b >= 420 && b < 630){
				img.src = anime.out;
				msgIndex = 0 ;
				console.log("1-3 out");
			}
		}
	break;

	case "2": //Level 2 路地裏   真中GoaL  //a 高加減 400px  b 力加減 630px
		if(a >= 0 && a < 130){
			if(b >= 0 && b < 210){
				img.src = anime.out;
				msgIndex = 0 ;
				console.log("2 out");
			}else if(b >= 210 && b < 420){
				img.src = anime.out;
				msgIndex = 0 ;
				console.log("2 out");
			}else if(b >= 420 && b < 630){
				img.src = anime.out;
				msgIndex = 0 ;
				console.log("2 out");
			}
		}
		if(a >= 130 && a < 280){
			if(b >= 0 && b < 210){
				img.src = anime.out;
				msgIndex = 0 ;
				console.log("2 out");
			}else if(b >= 210 && b < 420){
				img.src = anime.lv2.goal;
				msgIndex = 2 ;
				console.log("2 in");
			}else if(b >= 420 && b < 630){
				img.src = anime.lv2.miss;
				msgIndex = 1 ;
				console.log("2 miss");
			}
		}
		if(a >= 280 && a < 400){
			if(b >= 0 && b < 210){
				img.src = anime.out;
				msgIndex = 0 ;
				console.log("2 out");
			}else if(b >= 210 && b < 420){
				img.src = anime.lv2.miss;
				msgIndex = 1 ;
				console.log("2 miss");
			}else if(b >= 420 && b < 630){
				img.src = anime. out;
				msgIndex = 0 ;
				console.log("2 out");
			}
		}
	break;

	case "3":	//Level 3 住宅街    右上GoaL  //a 高加減 400px  b 力加減 630px
		if(a >= 0 && a < 130){
			if(b >= 0 && b < 210){
				img.src = anime.out;
				msgIndex = 0 ;
				console.log("3-1 out");
			}else if(b >= 210 && b < 420){
				img.src = anime.out;
				msgIndex = 0 ;
				console.log("3-1 out");
			}else if(b >= 420 && b < 630){
				img.src = anime.out;
				msgIndex = 0 ;
				console.log("3-1 out");
			}
		}
		if(a >= 130 && a < 280){
			if(b >= 0 && b < 210){
				img.src = anime.out;
				msgIndex = 0 ;
				console.log("3-2 out");
			}else if(b >= 210 && b < 420){
				img.src = anime.out;
				msgIndex = 0 ;
				console.log("3-2 out");
			}else if(b >= 420 && b < 630){
				img.src = anime.lv3.miss;
				msgIndex = 1 ;
				console.log("3-2 miss");
			}
		}
		if(a >= 280 && a < 400){
			if(b >= 0 && b < 210){
				img.src = anime.out;
				msgIndex = 0 ;
				console.log("3-3 out");
			}else if(b >= 210 && b < 420){
				img.src = anime.lv3.miss;
				msgIndex = 1 ;
				console.log("3-3 miss");
			}else if(b >= 420 && b < 630){
				img.src = anime.lv3.goal;
				msgIndex = 2 ;
				console.log("3-3 in");
			}
		}
	break;

	}

	// 点数の計算
	let score = scores[level-1],
		posA = positions[level-1][0]-a,
		posB = positions[level-1][1]-b;

	if(posA <= 0){
		posA *= -1;
	}

	if(posB <= 0){
		posB *= -1;
	}

	let point = score-(posA + posB)
	if (point <= 0 ) {
		point = 0;
	}


	const result = () => {
		console.log("pタグ生成");
		let re = document.getElementsByClassName("target")
		const p = document.createElement("p");

		re[0].appendChild(p);
		p.innerHTML = 	'<font color="#FF0">'+ point +'点</font><br>'+
						'<font color="#0F0">' + msg[msgIndex] + '</font><br>'+
						'<font color="#F0F" size="7">クリックでＴＯＰ画面に飛ぶよー</font>';

	};
	setTimeout(result, 3000);


	// ゲーム終了後にクリック誤爆防止のため、1秒のタイムアウトを設定する
	setTimeout(function() {
	    document.querySelector("body")[0],addEventListener("click", function(e) {
	        submit(point);
	    });
	}, 1000);

	function submit(point)
	{    // ページ移動ボタンが押されたらゲームのデータを送信

	    document.getElementById("gameName").value = "DustBoxGame";
	    document.getElementById("gameScore").value = point;
	    document.getElementById("gameTop").value = "/C_groupWebProject/DustBoxGame/DustBoxTopSite.jsp";
	    document.querySelector("form").submit();

	}    // submit function end
}




