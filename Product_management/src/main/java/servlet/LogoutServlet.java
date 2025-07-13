package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//ログアウト処理を担当するサーブレット
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//すでに存在しているセッションを取得
		HttpSession session = request.getSession(false);
		//セッションが存在していれば無効化（ログアウト）
		if (session != null) {
			//セッションのデータを破棄
			session.invalidate();
		}
		//ログイン画面へリダイレクト
		response.sendRedirect("login.jsp");
	}
}
