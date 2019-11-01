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
	protected final String driverName = "#";

	/** ユーザアカウントDBのURL */
	protected final String accountURL = "#";

	/** ゲームデータ管理DBのURL */
	protected final String gameURL = "#";

	/** DBへアクセスするユーザ名 */
	protected final String user = "postgre";

	/** DBへアクセスするパスワード */
	protected final String pass = "root";

}
