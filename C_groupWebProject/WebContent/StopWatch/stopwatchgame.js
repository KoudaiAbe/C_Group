/*
*/
//const time = document.getElementById("time");
//const start = document.getElementById("start");
const stop = document.getElementById("stop");
//const reset = document.getElementById("reset");

//経過時間を保存する変数（単位:ミリ秒）
let elapsedTime;
//スタートボタンを押したときのUnix Epoch
let startTime;
//タイマーのID
let timerId;
//以前 stop したタイミングまでの計測時間
let timeToAdd = 0;

//表示される内容をアップデートする関数
const updateTimeText = () => {
	// 1分 = 1000 ミリ秒 * 60秒
	let m = Math.floor(elapsedTime / (1000 * 60));
	// 1分に満たなかったミリ秒のうち，秒となったもの
	let s = Math.floor((elapsedTime % (1000 * 60)) / 1000);
	// 1秒になれなかったもの
	let ms = elapsedTime % 1000;

	// ゼロパディング
	m = `0${m}`.slice(-2);
	s = `0${s}`.slice(-2);
	ms = `00${ms}`.slice(-3);

	//timer.textContent = `${m}:${s}:${ms}`;
};


//経過時間の管理と計算を行う関数
const countUp = () => {
	timerId = setTimeout(() => {
		elapsedTime = Date.now() - startTime + timeToAdd;
		updateTimeText();
		countUp();
	}, 10);
};


start.addEventListener("click", () => {
	startTime = Date.now();
	countUp();
	// スタートボタンを無効化
	start.disabled = true;
	// ストップボタンを有効化
	stop.disabled = false;
});

stop.addEventListener("click", () => {
	clearTimeout(timerId);
	timeToAdd += Date.now() - startTime;
	//スタートボタンを有効化
	start.disabled = false;
	//ストップボタンを無効化　
	stop.disabled = true;
});


//時間表示
(function(){
	'use strict';

	var start = document.getElementById('start');
	var stop = document.getElementById('stop');
	var result = document.getElementById('point');
	var startTime;
	var isStarted = false;

	start.addEventListener('click', function(){
		if(isStarted === true){
			return;
		}
		isStarted = true;
		startTime = Date.now();
		this.className = 'pushed';
		stop.className = '';
		point.textContent = '0.000';
		point.className = 'stanby';
	});

	stop.addEventListener('click', function(){
		var elapsedTime;
		var diff;
		if(isStarted === false){
			return;
		}
		isStarted = false;
		elapsedTime = (Date.now() - startTime) / 1000;
		point.textContent = elapsedTime.toFixed(3);
		this.className = 'pushed';
		point.className = '';

		//得点 絶対値-10で出力
		diff = Math.abs(elapsedTime - 10);
		console.log(diff);

		if(diff == 0){
			timepoint.className = 'timepoint';
			document.getElementById("timepoint").innerHTML = "1000";
		}else if(diff < 1.00){
			timepoint.className = 'timepoint';
			document.getElementById("timepoint").innerHTML = "800";
		}else if(diff < 2.00){
			timepoint.className = 'timepoint';
			document.getElementById("timepoint").innerHTML = "600";
		}else{
			timepoint.className = 'timepoint';
			document.getElementById("timepoint").innerHTML = "300";
		}
	});
})();

//時間リセット&得点リセット
document.getElementById("reset").onclick = function(){
	document.getElementById("point").innerHTML = "0.000";
	document.getElementById("timepoint").innerHTML = "0";
};

//ページ移動ボタンが押されたらゲームのデータを送信
function submit()
{
    document.getElementById("gameName").value = "カウントゲーム";
    document.getElementById("gameScore").value = document.getElementById("timepoint").textContent;
    document.querySelector("form").submit();

}    // submit function end