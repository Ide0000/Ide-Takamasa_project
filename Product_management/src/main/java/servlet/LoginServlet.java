package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.UserDAO;
import model.entity.UserBean;

//ログイン処理を担当するサーブレット
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = null;

		try {
			// ログインフォームから送られたIDとパスワードを取得
			int id = Integer.parseInt(request.getParameter("id"));
			String password = request.getParameter("password");
			// UserDAOを使ってログイン処理を行う
			UserDAO dao = new UserDAO();
			UserBean user = dao.login(id, password);

			if (user != null) {
				// ログイン成功
				// セッションを取得
				HttpSession session = request.getSession();
				// セッションにログインユーザー情報を保存
				session.setAttribute("user", user);
				// メニュー画面へ
				url = "/menu.jsp";

			} else {
				// ログイン失敗時（IDかパスワードが違う）
				request.setAttribute("error", "ログイン失敗：IDまたはパスワードが違います。");
				//ログイン画面に戻る
				url = "/login.jsp";
			}
		} catch (NumberFormatException e) {
			// IDが数値でない場合の例外処理
			request.setAttribute("error", "ログイン失敗：IDは数値で入力してください。");
			//ログイン画面に戻る
			url = "/login.jsp";
		}
		// リクエストを指定したJSPに転送
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}
}
