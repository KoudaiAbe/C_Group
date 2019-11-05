package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		AccountBeans accountBeans = new AccountBeans();
		accountBeans.setName(name);
		accountBeans.setPass(pass);
		HttpSession session = request.getSession();
		session.setAttribute("accounBeans",accountBeans);
		String action = "get";
		session.setAttribute("action", action);

		System.out.println("ログイン"); //TODO DEBUG
		System.out.println("ユーザ名:"+ accountBeans.getName()); //TODO DEBUG
		System.out.println("パスワード:"+ accountBeans.getPass()); //TODO DEBUG

		//TODO DEBUG フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/loginResult.jsp");
		dispatcher.forward(request, response);

		//AccountDAO生成
//		AccountDAO  accountDAO = new AccountDAO();

		//既存アカウントと新規アカウントの精査
//		boolean check =accountDAO.getAccount(accounBeans);

//		if(check) {
//
//			//既存：ログイン完了。
//			// フォワード
//			RequestDispatcher dispatcher =
//					request.getRequestDispatcher("/loginResult.jsp");
//			dispatcher.forward(request, response);
//
//		}else {
//
//			// フォワード
//			RequestDispatcher dispatcher =
//					request.getRequestDispatcher("/login.jsp");
//			dispatcher.forward(request, response);
//
//		}
	}


	/** アカウント作成処理 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//LoginページのNameとPassを受け取る。
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		//AccountDAO生成
//		AccountRegistDAO accountRegistDAO = new AccountRegistDAO();
		AccountBeans accountBeans = new AccountBeans();
		accountBeans.setName(name);
		accountBeans.setPass(pass);
		HttpSession session = request.getSession();
		session.setAttribute("accounBeans",accountBeans);
		String action = "get";
		session.setAttribute("action", action);
		boolean eqPass = pass.contentEquals(request.getParameter("pass"));

		System.out.println("アカウント作成"); //TODO DEBUG
		System.out.println("ユーザ名:"+ accountBeans.getName()); //TODO DEBUG
		System.out.println("パスワード:"+ accountBeans.getPass()); //TODO DEBUG
		System.out.println("パスワードの一致:"+ eqPass); //TODO DEBUG

		//TODO DEBUG フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/loginResult.jsp");
		dispatcher.forward(request, response);

		//既存アカウント名と被らないように新規アカウントを保存。
//		boolean check = accountRegistDAO.createAccount(accounBeans);

//		if(check) {
//
//			//被らないので、新規登録。AccountBeansnに保存。
//
//			HttpSession session = request.getSession();
//			session.setAttribute("accounBeans",accounBeans);
//
//			//新規アカウント登録後、ログイン完了画面へ
//			RequestDispatcher dispatcher =
//					request.getRequestDispatcher("/loginResult.jsp");
//			dispatcher.forward(request, response);
//
//		}else {
//
//			//被るので登録出来ず、リダイレクト。
//			accounBeans = null;
//			//response.sendRedirect("/WebContent/login.jsp");
//			RequestDispatcher dispatcher =
//					request.getRequestDispatcher("/login.jsp");
//			dispatcher.forward(request, response);
//
//		}
	}

}
