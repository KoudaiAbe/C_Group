package model;

import java.io.Serializable;

/**
 * ユーザアカウントを保存するJavaBeans<br>
 * プロパティはname, password
 *
 * @author 近藤
 */
public class GameBeans
implements Serializable
{

	/** ゲーム名 */
	private String game;

	/** スコア */
	private String score;

	private String year;
	private String month;
	private String day;
	private String hour;
	private String minute;
	private String second;





	/*
	 * ------------------Accessor----------------------
	 */

	public void setYear(String year) {
		this.year = year;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	public String getYear() {
		return year;
	}

	public String getMonth() {
		return month;
	}

	public String getDay() {
		return day;
	}

	public String getHour() {
		return hour;
	}

	public String getMinute() {
		return minute;
	}

	public String getSecond() {
		return second;
	}

	/** JavaBeans Accessor */
	public String getGame()
	{ return this.game; }

	/** JavaBeans Accessor */
	public void setGame(String game)
	{ this.game = game; }

	/** JavaBeans Accessor */
	public String getScore()
	{ return this.score; }

	/** JavaBeans Accessor */
	public void setScore(String score)
	{ this.score = score; }

}
