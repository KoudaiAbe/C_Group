let a,b;

var x = 1000;
var y = 800;

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

	let score,
		msgIndex;

	const msg = [
			"あー！ポイ捨て禁止ぃー！",
			"おしい！ちゃんと捨てて！",
			"ゴミ捨て完了！綺麗だね！"
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
	case "1"://Level 1 廃墟    右下GoaL  //a 高加減 500px  b 力加減 850px

		if(a >= 0 && a < 180){
			if(b >= 0 && b < 200){
				img.src = anime.out;
				score =   0;
				msgIndex = 0 ;
				console.log("1-1 out");
			}else if(b >= 200 && b < 400){
				img.src = anime.lv1.miss;
				score =   100;
				msgIndex = 1 ;
				console.log("1-1 miss");
			}else if(b >= 400 && b < 850){
				img.src = anime.lv1.goal;
				score =   300;
				msgIndex = 2 ;
				console.log("1-1 in");
			}
		}
		if(a >= 180 && a < 360){
			if(b >= 0 && b < 200){
				img.src = anime.out;
				score =   0;
				msgIndex = 0 ;
				console.log("1-2 out");
			}else if(b >= 200 && b < 400){
				img.src = anime.out;
				score =   0;
				msgIndex = 0 ;
				console.log("1-2 out");
			}else if(b >= 400 && b < 850){
				img.src = anime.lv1.miss;
				score =   100;
				msgIndex = 1 ;
				console.log("1-2 miss");
			}
		}
		if(a >= 360 && a < 500){
			if(b >= 0 && b < 200){
				img.src = anime.out;
				score =   0;
				msgIndex = 0 ;
				console.log("1-3 out");
			}else if(b >= 200 && b < 400){
				img.src = anime.out;
				score =   0;
				msgIndex = 0 ;
				console.log("1-3 out");
			}else if(b >= 400 && b < 850){
				img.src = anime.out;
				score =   0;
				msgIndex = 0 ;
				console.log("1-3 out");
			}
		}
	break;

	case "2": //Level 2 路地裏   真中GoaL  //a 高加減 500px  b 力加減 850px
		if(a >= 0 && a < 180){
			if(b >= 0 && b < 200){
				img.src = anime.out;
				score =   0;
				msgIndex = 0 ;
				console.log("2 out");
			}else if(b >= 200 && b < 500){
				img.src = anime.out;
				score =   0;
				msgIndex = 0 ;
				console.log("2 out");
			}else if(b >= 500 && b < 850){
				img.src = anime.out;
				score =   0;
				msgIndex = 0 ;
				console.log("2 out");
			}
		}
		if(a >= 180 && a < 360){
			if(b >= 0 && b < 200){
				img.src = anime.out;
				score =   0;
				msgIndex = 0 ;
				console.log("2 out");
			}else if(b >= 200 && b < 500){
				img.src = anime.lv2.goal;
				score =   600;
				msgIndex = 2 ;
				console.log("2 in");
			}else if(b >= 500 && b < 850){
				img.src = anime.lv2.miss;
				score =   400;
				msgIndex = 1 ;
				console.log("2 miss");
			}
		}
		if(a >= 360 && a < 500){
			if(b >= 0 && b < 200){
				img.src = anime.out;
				score =   0;
				msgIndex = 0 ;
				console.log("2 out");
			}else if(b >= 200 && b < 500){
				img.src = anime.lv2.miss;
				score =   400;
				msgIndex = 1 ;
				console.log("2 miss");
			}else if(b >= 500 && b < 850){
				img.src = anime. out;
				score =   0;
				msgIndex = 0 ;
				console.log("2 out");
			}
		}
	break;

	case "3":	//Level 3 住宅街    右上GoaL  //a 高加減 500px  b 力加減 850px
		if(a >= 0 && a < 180){
			if(b >= 0 && b < 200){
				img.src = anime.out;
				score = 0;
				msgIndex = 0 ;
				console.log("3-1 out");
			}else if(b >= 200 && b < 500){
				img.src = anime.out;
				score = 0;
				msgIndex = 0 ;
				console.log("3-1 out");
			}else if(b >= 500 && b < 850){
				img.src = anime.out;
				score = 0;
				msgIndex = 0 ;
				console.log("3-1 out");
			}
		}
		if(a >= 180 && a < 360){
			if(b >= 0 && b < 200){
				img.src = anime.out;
				score = 0;
				msgIndex = 0 ;
				console.log("3-2 out");
			}else if(b >= 200 && b < 500){
				img.src = anime.out;
				score = 0;
				msgIndex = 0 ;
				console.log("3-2 out");
			}else if(b >= 500 && b < 850){
				img.src = anime.lv3.miss;
				score = 700;
				msgIndex = 1 ;
				console.log("3-2 miss");
			}
		}
		if(a >= 360 && a < 500){
			if(b >= 0 && b < 200){
				img.src = anime.out;
				score = 0;
				msgIndex = 0 ;
				console.log("3-3 out");
			}else if(b >= 200 && b < 500){
				img.src = anime.lv3.miss;
				score = 700;
				msgIndex = 1 ;
				console.log("3-3 miss");
			}else if(b >= 500 && b < 850){
				img.src = anime.lv3.goal;
				score = 1000;
				msgIndex = 2 ;
				console.log("3-3 in");
			}
		}
	break;

	}

	const result = () => {
		console.log("pタグ生成");
		let re = document.getElementsByClassName("target")
		const p = document.createElement("p");

		re[0].appendChild(p);
		p.innerHTML = 	'<font color="#FF0">'+ score +'点</font><br>'+
						'<font color="#0F0">' + msg[msgIndex] + '</font><br>'+
						'<font color="#F0F" size="7">クリックでＴＯＰ画面に飛ぶよー</font>';

	};
	setTimeout(result, 3000);


	// ゲーム終了後にクリック誤爆防止のため、1秒のタイムアウトを設定する
	setTimeout(function() {
	    document.querySelector("body")[0],addEventListener("click", function(e) {
	        submit();
	    });
	}, 1000);

	function submit()
	{    // ページ移動ボタンが押されたらゲームのデータを送信

	    document.getElementById("gameName").value = "DustBoxGame";
	    document.getElementById("gameScore").value = score;
	    document.getElementById("gameTop").value = "/C_groupWebProject/DustBoxGame/DustBoxTopSite.jsp";
	    document.querySelector("form").submit();

	}    // submit function end
}




