package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AccountBeans;

public class AccountRegistDAO
extends ConstantDefinition
{
	public boolean createAccount(AccountBeans beans){
		List<String> nameList = new ArrayList<>();

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
				if(list.equals(beans.getName()) ){
					return false;
				}
//					else {
//						AccountBeans accountbeans = new AccountBeans();
//						AccountBeansList.add(accountbeans);
//						String sqladd = "SELECT NAME,PASS INSERT account";
//					}

				//引数を設定する
//				AccountBeans accountbeans = new AccountBeans();
//				AccountBeansList.add(accountbeans);

			}

			// DBにアカウントを登録する
			String sqladd =
					"INSERT INTO account VALUES('"+ beans.getName() +"', '"+ beans.getPass() +"')";
			PreparedStatement pStmt2 = con.prepareStatement(sqladd);

			//INSERTを実行
			pStmt2.executeQuery();

		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
