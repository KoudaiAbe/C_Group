package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AccountBeans;

public class GameDAO
extends ConstantDefinition{

	public boolean findALL(){
		List<AccountBeans> AccountBeansList = new ArrayList<>();

		//データベース接続
		try(Connection con = DriverManager.getConnection(ACCOUNT_URL,DRIVER_USER,DRIVER_PASS)){
			//SELECT文の準備
			String sql = "SELECT NAME,PASS FROM account";
			PreparedStatement pStmt = con.prepareStatement(sql);

			//SELECTを実行
			ResultSet rs = pStmt.executeQuery();

			//SELECT文の結果をArrayListに格納
			while(rs.next()) {
				String name = rs.getString("NAME");
				String password = rs.getString("PASS");

				//for文でリストの中からnameが一致するか取得
				for(AccountBeans userName : AccountBeansList) {
					if(name.equals(userName) ){
						return false;
					}else {
						AccountBeans accountbeans = new AccountBeans();
						AccountBeansList.add(accountbeans);
						String sqladd = "SELECT NAME,PASS INSERT account";
					}
				}
				//引数を設定する
//				AccountBeans accountbeans = new AccountBeans();
//				AccountBeansList.add(accountbeans);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}