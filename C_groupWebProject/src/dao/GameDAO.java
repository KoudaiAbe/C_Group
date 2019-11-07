
/* **CHANGED**
 *
 * param(check) add
 *
 * column59-71 add
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AccountBeans;
import model.GameBeans;

/**
 * ログインの処理を行うクラス。<br>
 * サーブレットクラスよりBeansインスタンスを受け取り、それをもとにDBと照合する。<br>
 * インスタンス内の値とDB内に一致するものがあればTRUEを返し、一致しなければFALSEを返す。
 *
 * @author 阿部/松本
 */
public class GameDAO extends ConstantDefinition{

	public void postData(AccountBeans account, GameBeans data){

		//クラスをロード
		try {
			Class.forName("org.postgresql.Driver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}

		//データベース接続
		try(Connection con = DriverManager.getConnection(GAME_URL,DRIVER_USER,DRIVER_PASS)){

			// DBにアカウントを登録する
			String sqladd =
				"INSERT INTO gamerecord VALUES('"+ account.getName() +"', '"+data.getGame() +"', '"+ data.getYear() + "', '"+ data.getMonth() + "', '"+ data.getDay() + "', '"+ data.getHour() + "', '"+ data.getMinute() + "', '"+ data.getSecond() + "', '"+ data.getScore() + "')";
			PreparedStatement pStmt2 = con.prepareStatement(sqladd);

			//INSERTを実行
			pStmt2.executeUpdate();

		}catch(SQLException e) {

			e.printStackTrace();

		}
	}



	@SuppressWarnings("unused")
	private void hoge() {

		List<GameBeans> dataList = new ArrayList<>();

		//クラスをロード
		try {
			Class.forName("org.postgresql.Driver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}

		//データベース接続
		try(Connection con = DriverManager.getConnection(ACCOUNT_URL,DRIVER_USER,DRIVER_PASS)){

			//SELECT文の準備
			String sql = "SELECT NAME, GAME, YEAR, MONTH, DAY, HOUR, MINUTE, SECOND, SCORE, FROM GameRecord";
			PreparedStatement pStmt = con.prepareStatement(sql);

			//SELECTを実行
			ResultSet rs = pStmt.executeQuery();

			//SELECT文の結果をArrayListに格納
			while(rs.next()) {

				// Beansを用いてコレクションを作成
				GameBeans data = new GameBeans();
				data.setGame(rs.getString("GAME"));
				data.setYear(rs.getString("YEAR"));
				data.setMonth(rs.getString("MONTH"));
				data.setDay(rs.getString("DAY"));
				data.setHour(rs.getString("HOUR"));
				data.setMinute(rs.getString("MINUTE"));
				data.setSecond(rs.getString("SECOND"));
				data.setScore(rs.getString("SCORE"));

				dataList.add(data);

			}

		}catch(SQLException e) {

			e.printStackTrace();

		}
	}
}