package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AccountBeans;


public class AccountDAO
extends ConstantDefinition{

	//データベース接続に使用する情報
//	private final String JDBC_URL = "jdbc:postgresql://localhost:5432/game_db";
//	private final String DB_USER = "postgres";
//	private final String DB_PASS ="root";

	public List<AccountBeans> findALL(){
		List<AccountBeans> AccountBeansList = new ArrayList<>();

		//データベース接続
		try(Connection con = DriverManager.getConnection(DRIVER_NAME,DRIVER_USER,DRIVER_PASS)){
			//SELECT文の準備
			String sql = "SELECT NAME,PASS FROM game_db";
			PreparedStatement pStmt = con.prepareStatement(sql);

			//SELECTを実行
			ResultSet rs = pStmt.executeQuery();

			//SELECT文の結果をArrayListに格納
			while(rs.next()) {
				String Name = rs.getString("NAME");
				//String text = rs.getString("TEXZT");

				//引数を設定する
				AccountBeans accountbeans = new AccountBeans();
				AccountBeansList.add(accountbeans);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return AccountBeansList;
	}

	public boolean create(AccountBeans accountbeans) {

		//データベース接続
		try(Connection conn = DriverManager.getConnection(DRIVER_NAME,DRIVER_USER,DRIVER_PASS)){

			//INSERT文の準備
			String sql = "INSERT INTO game_db(NAME,PASS) VALUES(?,?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//INSERT文中の「？」に使用する値を設定しSQLを完成
			pStmt.setString(1, accountbeans.getName());
			//pStmt.setString(2, accountbeans.getText());

			//INSERT文を実行
			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}