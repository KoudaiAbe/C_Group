package dao;

/**
 * DBアクセス関係の定数を管理する抽象クラス。<br>
 * DAOはこのクラスを継承し、ドライバやDBのURLの定数をここから読み込む。
 *
 * @author 近藤
 */
public abstract class ConstantDefinition
{

	{	// Initializer

		//クラスをロード
		try
		{ Class.forName("org.postgresql.Driver"); }
		catch(ClassNotFoundException e)
		{ e.printStackTrace(); }

	}	// Initializer end

	/** DBドライバの名称 */
	//protected final String DRIVER_NAME = "game_db";

	/** ユーザアカウントDBのURL */
	protected final String ACCOUNT_URL = "jdbc:postgresql://localhost:5432/game_db";

	/** ゲームデータ管理DBのURL */
	protected final String GAME_URL = "jdbc:postgresql://localhost:5432/game_db";

	/** DBへアクセスするユーザ名 */
	protected final String DRIVER_USER = "postgres";

	/** DBへアクセスするパスワード */
	protected final String DRIVER_PASS = "root";

}
