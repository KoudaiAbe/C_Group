package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AccountBeans;


public class AccountDAO extends ConstantDefinition{

    public List<AccountBeans> findALL(){
        List<AccountBeans> AccountBeansList = new ArrayList<>();

        //データベース接続
        try(Connection con = DriverManager.getConnection(ACCOUNT_URL,DRIVER_USER, DRIVER_PASS)){
            //SELECT文の準備
            String sql = "NAME,PASS FROM account";
            PreparedStatement pStmt = con.prepareStatement(sql);

            //SELECTを実行
            ResultSet rs = pStmt.executeQuery();

            //SELECT文の結果をArrayListに格納
            while(rs.next()) {
                String name = rs.getString("NAME");
                String pass = rs.getString("PASS");

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

//    /*
//    public boolean create(AccountBeans accountbeans) {
//
//        //データベース接続
//        try(Connection con = DriverManager.getConnection(ACCOUNT_URL,DRIVER_USER, DRIVER_PASS)){
//
//            //INSERT文の準備
//            String sql = "INSERT INTO MUTTER(NAME,TEXT) VALUES(?,?";
//            PreparedStatement pStmt = con.prepareStatement(sql);
//
//            //INSERT文中の「？」に使用する値を設定しSQLを完成
//            pStmt.setString(1, accountbeans.getName());
//            //pStmt.setString(2, accountbeans.getText());
//
//            //INSERT文を実行
//            int result = pStmt.executeUpdate();
//            if(result != 1) {
//                return false;
//            }
//        }catch(SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
//    */
}