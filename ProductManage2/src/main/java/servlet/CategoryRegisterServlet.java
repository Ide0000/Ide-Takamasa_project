package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoryDAO;
import model.entity.CategoryBean;

@WebServlet("/CategoryRegisterServlet")
public class CategoryRegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// フォームから送信された値を取得
		String idInput = request.getParameter("id");// カテゴリID
		String name = request.getParameter("name");// カテゴリ名
		try {
			int id = Integer.parseInt(idInput);
			// CategoryBean にデータをセット
			CategoryBean category = new CategoryBean(id, name);
			// データベースに登録
			CategoryDAO dao = new CategoryDAO();
			dao.insert(category);
			
		} catch (NumberFormatException e) {
			// IDが数値に変換できなかった場合
			e.printStackTrace();
			request.setAttribute("error", "カテゴリIDは数値で入力してください。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/category-register.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// その他の例外が発生した場合
			e.printStackTrace();
			request.setAttribute("error", "登録に失敗しました。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/category-register.jsp");
			dispatcher.forward(request, response);
		}
	}
}
