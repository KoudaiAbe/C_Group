
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

/**
 * ログインの処理を行うクラス。<br>
 * サーブレットクラスよりBeansインスタンスを受け取り、それをもとにDBと照合する。<br>
 * インスタンス内の値とDB内に一致するものがあればTRUEを返し、一致しなければFALSEを返す。
 *
 * @author 阿部/松本
 */
public class AccountDAO
extends ConstantDefinition{

	public boolean getAccount(AccountBeans account){

		List<AccountBeans> dataList = new ArrayList<>();

		boolean check = false;	// 入力されたアカウント情報のチェック用

		//クラスをロード
		try {
			Class.forName("org.postgresql.Driver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}

		//データベース接続
		try(Connection con = DriverManager.getConnection(ACCOUNT_URL,DRIVER_USER,DRIVER_PASS)){

			//SELECT文の準備
			String sql = "SELECT NAME,PASS FROM account";
			PreparedStatement pStmt = con.prepareStatement(sql);

			//SELECTを実行
			ResultSet rs = pStmt.executeQuery();

			//SELECT文の結果をArrayListに格納
			while(rs.next()) {

				// Beansを用いてコレクションを作成
				AccountBeans accountList = new AccountBeans();
				accountList.setName(rs.getString("NAME"));
				accountList.setPass(rs.getString("PASS"));

				dataList.add(accountList);

			}

			/* ADD for @author 近藤 */
			for (int index = 0 ; index < dataList.size(); index++)
			{	// 入力されたユーザ名と一致するものを探す

				if (dataList.get(index).getName().equals(account.getName())
					&&dataList.get(index).getPass().equals(account.getPass()))
				{	// ユーザ名パスワードが一致すればログイン成功

					check = true;
					break;

				}	// if end
			}	// for end

		}catch(SQLException e) {

			e.printStackTrace();
			return false;

		}

		return check;
	}
}