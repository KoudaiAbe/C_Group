
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AccountBeans;

/**
 * アカウント新規作成を行うクラス。<br>
 * サーブレットクラスよりBeansインスタンスを受け取り、それをもとにDBと照合する。<br>
 * 登録しようとしているユーザ名がDBに存在しなければユーザ名とパスワードをDBに登録しTRUEを返し、<br>
 * 既にDBにある場合は登録不可となり、FALSEを返す。
 *
 * @author 阿部/松本
 */
public class AccountRegistDAO
extends ConstantDefinition
{

	public boolean createAccount(AccountBeans account){

		List<String> nameList = new ArrayList<>();

		//クラスをロード
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

		//データベース接続
		try(Connection con = DriverManager.getConnection(ACCOUNT_URL,DRIVER_USER,DRIVER_PASS)){

			//SELECT文の準備
			String sql = "SELECT NAME FROM account";
			PreparedStatement pStmt = con.prepareStatement(sql);

			//SELECTを実行
			ResultSet rs = pStmt.executeQuery();

			//SELECT文の結果をArrayListに格納
			while(rs.next()) {

				nameList.add(rs.getString("NAME"));

			}

			//for文でリストの中からnameが一致するか取得
			for(String list : nameList) {

				// 一致する場合は登録を拒絶
				if(list.equals(account.getName()) ){

					return false;

				}
			}

			// DBにアカウントを登録する
			String sqladd =
					"INSERT INTO account VALUES('"+ account.getName() +"', '"+ account.getPass() +"')";
			PreparedStatement pStmt2 = con.prepareStatement(sqladd);

			//INSERTを実行
			pStmt2.executeUpdate();


		}catch(SQLException e) {

			e.printStackTrace();
			return false;

		}

		return true;

	}
}
