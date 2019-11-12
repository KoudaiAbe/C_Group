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
 * アカウントを取り扱うサーブレット。<br>
 * ログインの処理とアカウント作成の処理をそれぞれのメソッドで行う。<br>
 * login.jspのフォームより値を受け取り、ログインであればdoGet()、アカウント作成であればdoPost()を実行する。
 *
 * @author 梅本/大河内
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * ログインの処理を行うメソッド。
	 *
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String action;

		//Login.jspのNameとPassを受け取る。
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		/* ADD if @author 近藤 */
		if (name.length() == 0 || pass.length() == 0)
		{	// フォームに不備があればエラー

			// セッションスコープへエラー内容を送信
			action = "NullInputError";
			session.setAttribute("action", action);

			// login.jspへ
			request.getRequestDispatcher("/login.jsp").forward(request, response);

		}	// for end

		//nameとpassの値をaccounBeansに保存。
		AccountBeans account = new AccountBeans();
		account.setName(name);
		account.setPass(pass);
		session.setAttribute("accountBeans",account);

		//AccountDAO生成
		AccountDAO  accountDAO = new AccountDAO();

		//既存アカウントと新規アカウントの精査
		boolean check =accountDAO.getAccount(account);

		if(check) {

			//ログイン完了
			// セッションスコープへアクション内容を送信
			action = "Get";
			session.setAttribute("action", action);

			// loginResult.jspへ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/loginResult.jsp");
			dispatcher.forward(request, response);

		}else {

			//ログイン失敗
			// セッションスコープへエラー内容を送信
			action = "TypeError";
			session.setAttribute("action", action);

			// セッションスコープとBeansを破棄
			session.removeAttribute("accountBeans");
			account = null;

			// login.jspへ
			request.getRequestDispatcher("/login.jsp").forward(request, response);

		}
	}



	/**
	 * アカウント作成処理を行うメソッド。
	 *
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String action;

		//LoginページのNameとPassを受け取る。
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		/* ADD if @author 近藤 */
		if (name.length() == 0 || pass.length() == 0)
		{	// フォームに不備があればエラー

			// セッションスコープへエラー内容を送信
			action = "NullInputError";
			session.setAttribute("action", action);

			// login.jspへ
			request.getRequestDispatcher("/login.jsp").forward(request, response);

		}	// for end

		/* ADD if @author 近藤 */
		if (!pass.contentEquals(request.getParameter("pass")))
		{	// 確認欄とパスワードが一致しない場合は登録処理を行わずlogin.jspへ

			// セッションスコープへエラー内容を送信
			action = "DisagreementError";
			session.setAttribute("action", action);

			request.getRequestDispatcher("/login.jsp").forward(request, response);

		}	//if end

		//nameとpassの値をaccounBeansに保存。
		AccountBeans account = new AccountBeans();
		account.setName(name);
		account.setPass(pass);

		session.setAttribute("accountBeans",account);



		//AccountDAO生成
		AccountRegistDAO accountRegistDAO = new AccountRegistDAO();

		//既存アカウント名と被らないように新規アカウントを保存。
		boolean check = accountRegistDAO.createAccount(account);

		if(check) {

			//新規アカウント登録&ログイン完了
			// セッションスコープへアクション内容を送信
			action = "Post";
			session.setAttribute("action", action);

			// loginResult.jspへ
			request.getRequestDispatcher("/loginResult.jsp").forward(request, response);

		}else {

			//被るので登録不可
			// セッションスコープへエラー内容を送信
			action = "DuplicateError";
			session.setAttribute("action", action);

			// セッションスコープとBeansを破棄
			session.removeAttribute("accountBeans");
			account = null;

			// login.jspへ
			request.getRequestDispatcher("/login.jsp").forward(request, response);

		}
	}

}
