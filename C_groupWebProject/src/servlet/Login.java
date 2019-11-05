package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import dao.AccountRegistDAO;
import model.AccountBeans;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/** ログイン処理 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		//Login.jspのNameとPassを受け取る。
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		//nameとpassの値をaccounBeansに保存。
		AccountBeans accounBeans = new AccountBeans();
		accounBeans.setName(name);
		accounBeans.setPass(pass);
		HttpSession session = request.getSession();
		session.setAttribute("accounBeans",accounBeans);


		//AccountDAO生成
		AccountDAO  accountDAO = new AccountDAO();

		//既存アカウントと新規アカウントの精査
		boolean check =accountDAO.getAccount(accounBeans);

		if(check) {

			//既存：ログイン完了。
			// フォワード
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/loginResult.jsp");
			dispatcher.forward(request, response);
			System.out.println(2);

		}else {

			//ログイン失敗、リダイレクト。
			session.removeAttribute("accounBeans");
			accounBeans = null;
			response.sendRedirect("/login.jsp");

		}
	}


	/** アカウント作成処理 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//LoginページのNameとPassを受け取る。
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		//AccountDAO生成
		AccountRegistDAO accountRegistDAO = new AccountRegistDAO();
		AccountBeans accounBeans = new AccountBeans();
		accounBeans.setName(name);
		accounBeans.setPass(pass);
		//既存アカウント名と被らないように新規アカウントを保存。
		boolean check = accountRegistDAO.createAccount(accounBeans);

		if(check) {

			//被らないので、新規登録。AccountBeansnに保存。

			HttpSession session = request.getSession();
			session.setAttribute("accounBeans",accounBeans);

			//新規アカウント登録後、ログイン完了画面へ
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/loginResult.jsp");
			dispatcher.forward(request, response);

		}else {

			//被るので登録出来ず、リダイレクト。
			accounBeans = null;
			response.sendRedirect("/login.jsp");

		}
	}

}
