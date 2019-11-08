package model;

import java.io.Serializable;

/**
 * ランキングスコアを保存するJavaBeans<br>
 * プロパティはname, game, score, date
 *
 * @author 近藤
 */
public class ScoreBeans
implements Serializable
{

	/** ユーザ名 */
	private String name;

	/** ゲーム名 */
	private String game;

	/** スコア */
	private String score;

	/** 取得年月日 */
	private String date;

	/*
	 * -----------------Accessor-----------------
	 */

	/** JavaBeans Accessor */
	public String getName()
	{ return name; }

	/** JavaBeans Accessor */
	public void setName(String name)
	{ this.name = name; }

	/** JavaBeans Accessor */
	public String getGame()
	{ return game; }

	/** JavaBeans Accessor */
	public void setGame(String game)
	{ this.game = game; }

	/** JavaBeans Accessor */
	public String getScore()
	{ return score; }

	/** JavaBeans Accessor */
	public void setScore(String score)
	{ this.score = score; }

	/** JavaBeans Accessor */
	public String getDate()
	{ return date; }

	/** JavaBeans Accessor */
	public void setDate(String date)
	{ this.date = date; }

}
