package model.entity;

import java.io.Serializable;

//ユーザー情報を保持するクラス
public class UserBean implements Serializable {
	private int id; //ユーザーID
	private String name; //ユーザーの名前
	private String password; //パスワード

	public UserBean() {
	}

	public UserBean(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
