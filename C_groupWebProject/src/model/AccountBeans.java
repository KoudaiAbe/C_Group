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
	private String password;

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
	public String getPassword()
	{ return this.password; }

	/** JavaBeans Accessor */
	public void setPassword(String password)
	{ this.password = password; }

}
