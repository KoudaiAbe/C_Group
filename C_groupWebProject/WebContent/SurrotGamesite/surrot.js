/**
 *スロットゲームのjavascript
 */

const timer = document.getElementById('timer');
let TIME = 30;
let state = false;
var score = 0;
var interval = 400;
var slotImg = ['seven.jpg','suika.jpg','bar.jpg','beru.jpg','cherry.jpg','jac.jpg'];
var pic_loc = ['pic11','pic21','pic31','pic12','pic22','pic32','pic13','pic23','pic33'];
var int_p01 = [ 8 , 5 , 4 ];
var int_p02 = [ 6 , 9 , 11];

var time_id = new Array(2);
var start_p = new Array(2);
var int_tim = new Array(2);
var rotat_f = new Array(3);

var var_par;

const countDown = () => {
	timer.textContent = '制限時間：' + TIME + '秒';
	if(TIME <= 0) finish();

	if (TIME != 0)
	{
		TIME--;
		setTimeout(countDown, 1000);
	}
}

// 全リール回転開始
function start() {

	// タイマー開始
	if (!state)
	{
		countDown();
		state = ture;
	}

	if (rotat_f[0] == "ON" || rotat_f[1] == "ON" || rotat_f[2] == "ON"){
		// リール回転中、スタートボタンを無効にする
		// alert(rotat_f[0] + "," + rotat_f[1] + "," + rotat_f[2] ) ;
		exit() ;
	}

	document.getElementById("msg_box").innerHTML = "" ;

	var_par = 200 ;

	for(var i = 0; i < 3; i++ ){
		start_p[i] = Math.floor( Math.random() * 6 );
		int_tim[i] = 80 + int_p01[i] * Math.floor( int_p02[i] * Math.random() );
		start_prg(i);
		rotat_f[i] = "ON" ;
	}

	rotat_f[3] = "ON" ;

}

// 回転
function start_prg(r_no) {
	if (start_p[r_no] > 5){ start_p[r_no] = 0 ; }

	var tmp1 = start_p[r_no] ; var tmp2 = start_p[r_no] + 1 ; var tmp3 = start_p[r_no] + 2 ;
	if (tmp1==5){ var tmp2 = 0; var tmp3 = 1; }
	if (tmp1==4){ var tmp3 = 0; }

	document.getElementById(pic_loc[3 * r_no + 0]).src=slotImg[tmp3] ;
	document.getElementById(pic_loc[3 * r_no + 1]).src=slotImg[tmp2] ;
	document.getElementById(pic_loc[3 * r_no + 2]).src=slotImg[tmp1] ;

	start_p[r_no] = start_p[r_no] + 1 ;

	time_id[r_no] = setTimeout(function(){start_prg(r_no)}, int_tim[r_no] + Math.floor( var_par * Math.random()) );
}

// 停止
function stop_prg(id_no) {
	clearTimeout(time_id[id_no]);
	rotat_f[id_no] = "OFF" ;

	if (rotat_f[0] != "ON" && rotat_f[1] != "ON" && rotat_f[2] != "ON" && rotat_f[3] == "ON"){
		//全停止
		var jdg_slot = "lost" ;
		if(start_p[0]==1 && start_p[1]==1 && start_p[2]==1){ jdg_slot = "won" ; }
		if(start_p[0]==5 && start_p[1]==5 && start_p[2]==5){ jdg_slot = "won" ; }
		if(start_p[0]==6 && start_p[1]==6 && start_p[2]==6){ jdg_slot = "won" ; }
		if(start_p[0]==1 && start_p[1]==6 && start_p[2]==5){ jdg_slot = "won" ; }
		if(start_p[0]==5 && start_p[1]==6 && start_p[2]==1){ jdg_slot = "won" ; }



		var elem = document.getElementById("msg_box");
		if (jdg_slot == "won" ){
			elem.innerHTML = "<span style='color:red; font-size:28px; font-weight:bold;'> 当たり！（７７７）</span>" ;
			score += 100; // 得点を足す
			interval *= 0.4;
			// 得点追加の処理
			getScore();
		}else{
			elem.innerHTML = "<span style='color:black; font-size:28px; font-weight:bold;'> 外れ！ 残念！</span>" ;
		}
		rotat_f[3] = "OFF" ;
	}
	// 得点追加時の処理
	function getScore() {
		var target = document.getElementById('score');
		target.textContent = score;
	}

}
//カウントダウンを止める。
function finish() {
	clearInterval(countdown);
	document.getElementById("msg_box").innerHTML = "<span style='color:black; font-size:28px; font-weight:bold;'>GAME OVER</span>" ;
	gameOver();

}

// ゲーム終了時の処理
function gameOver() {
//	// 全てのマスをクリックできないようにする
//	squaresArray.forEach(function (square) {
//		square.classList.add('js-unclickable');
//	});

	// ボタンを無効にする
	let buttons = document.getElementsByClassName("button");

	for (button of buttons)
	{ button.disabled = true; }

	// ゲーム終了後にクリック誤爆防止のため、1秒のタイムアウトを設定する
	setTimeout(function() {
		document.querySelector("body")[0],addEventListener("click", function(e) {
			submit();
		});
	}, 1000);
}



function submit()
{    // ページ移動ボタンが押されたらゲームのデータを送信

	document.getElementById("gameName").value = "Slot";
	document.getElementById("gameScore").value = score;
	document.querySelector("form").submit();

}    // submit function end