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
import java.sql.SQLException;

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
}