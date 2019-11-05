package model;

import java.io.Serializable;

/**
 * ユーザアカウントを保存するJavaBeans<br>
 * プロパティはname, password
 *
 * @author 近藤
 */
public class AccountBeans
implements Serializable
{

	/** アカウントID名 */
	private String name;

	/** アカウントパスワード */
	private String pass;

	/*
	 * ------------------Accessor----------------------
	 */

	/** JavaBeans Accessor */
	public String getName()
	{ return this.name; }

	/** JavaBeans Accessor */
	public void setName(String name)
	{ this.name = name; }

	/** JavaBeans Accessor */
	public String getPass()
	{ return this.pass; }

	/** JavaBeans Accessor */
	public void setPass(String pass)
	{ this.pass = pass; }

}
