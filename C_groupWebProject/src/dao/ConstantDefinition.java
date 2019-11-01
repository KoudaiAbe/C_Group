package dao;

/**
 * DBアクセス関係の定数を管理する抽象クラス。<br>
 * DAOはこのクラスを継承し、ドライバやDBのURLの定数をここから読み込む。
 *
 * @author 近藤
 */
public abstract class ConstantDefinition
{

	/** DBドライバの名称 */
	protected final String DRIVER_NAME = "jdbc:postgresql://localhost:5432/game_db";

	/** ユーザアカウントDBのURL */
	protected final String ACCOUNT_URL = "#";

	/** ゲームデータ管理DBのURL */
	protected final String GAME_URL = "#";

	/** DBへアクセスするユーザ名 */
	protected final String DRIVER_USER = "postgres";

	/** DBへアクセスするパスワード */
	protected final String DRIVER_PASS = "root";

}
