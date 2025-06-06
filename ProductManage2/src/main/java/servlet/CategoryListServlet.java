package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoryDAO;
import model.entity.CategoryBean;

//カテゴリリストの一覧表示を制御するサーブレット
@WebServlet("/CategoryListServlet")
public class CategoryListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//DAOのインスタンスを生成
		CategoryDAO dao = new CategoryDAO();
		List<CategoryBean> categoryList = null;
		try {
			//DAOを使ってカテゴリリストの情報を取得
			categoryList = dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//カテゴリリストをリクエストスコープに設定
		request.setAttribute("categoryList", categoryList);
		//JSPページにリクエストを転送
		RequestDispatcher dispatcher = request.getRequestDispatcher("/category-list.jsp");
		dispatcher.forward(request, response);
	}
}
