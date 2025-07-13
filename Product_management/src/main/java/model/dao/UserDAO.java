package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.entity.UserBean;

//ユーザー情報のデータベースアクセスを担当するクラス
public class UserDAO {
	// ログイン処理：IDとパスワードでユーザーを検索
	public UserBean login(int id, String password) {
		UserBean user = null;
		// SQL文：指定されたIDとパスワードに一致するユーザーを探す
		String sql = "SELECT * FROM users WHERE id = ? AND password = ?";
		//データベースへの接続を取得し、PreparedStatementを作成
		try (Connection con = ConnectionManager.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			// ユーザーが見つかった場合
			if (rs.next()) {
				user =new UserBean();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			// エラーが起きた場合
			e.printStackTrace();
		}
		return user;
	}
}
