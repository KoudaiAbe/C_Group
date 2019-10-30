package model;

import java.io.Serializable;

/**
 * @author 近藤
 *
 * ユーザアカウントを保存するJavaBeans<br>
 * プロパティはname, password
 */
public class GameBeans
implements Serializable
{

	/** アカウントID名 */
	private String game;

	/** アカウントパスワード */
	private String date;

	/** アカウントパスワード */
	private String score;

	/*
	 * ------------------Accessor----------------------
	 */

	/** JavaBeans Accessor */
	public String getGame()
	{ return this.game; }

	/** JavaBeans Accessor */
	public void setGame(String game)
	{ this.game = game; }

	/** JavaBeans Accessor */
	public String getDate()
	{ return this.date; }

	/** JavaBeans Accessor */
	public void setDate(String date)
	{ this.date = date; }

	/** JavaBeans Accessor */
	public String getScore()
	{ return this.score; }

	/** JavaBeans Accessor */
	public void setScore(String score)
	{ this.score = score; }

}
