package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;

//データベース操作を行うDAOクラス
public class CategoryDAO {
	public List<CategoryBean> findAll() throws Exception {
		List<CategoryBean> list = new ArrayList<>();

		String sql = "SELECT * FROM categories";
		//データベースへの接続、ステートメントの作成、SQLの実行
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			//結果セットからid,category_nameをリストに追加
			while (rs.next()) {
				CategoryBean categoryList = new CategoryBean();
				categoryList.setId(rs.getInt("id"));
				categoryList.setName(rs.getString("category_name"));
				list.add(categoryList);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
}
