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

	public boolean getAccount(AccountBeans beans){
		List<AccountBeans> AccountBeansList = new ArrayList<>();

		//繝�繝ｼ繧ｿ繝吶�ｼ繧ｹ謗･邯�
		try(Connection con = DriverManager.getConnection(ACCOUNT_URL,DRIVER_USER,DRIVER_PASS)){
			//SELECT譁�縺ｮ貅門ｙ
			String sql = "SELECT NAME,PASS FROM account";
			PreparedStatement pStmt = con.prepareStatement(sql);

			//SELECT繧貞ｮ溯｡�
			ResultSet rs = pStmt.executeQuery();

			//SELECT譁�縺ｮ邨先棡繧但rrayList縺ｫ譬ｼ邏�
			while(rs.next()) {
				String name = rs.getString("NAME");
				String password = rs.getString("PASS");

				//蠑墓焚繧定ｨｭ螳壹☆繧�
				AccountBeans accountbeans = new AccountBeans();
				AccountBeansList.add(accountbeans);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}