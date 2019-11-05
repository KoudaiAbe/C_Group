
/* **CHANGED**
 *
 * param(accounBeans) -> account
 *
 * column99-109 add
 */

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

		//Login.jspのNameとPassを受け取る。
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		//nameとpassの値をaccounBeansに保存。
		AccountBeans account = new AccountBeans();
		account.setName(name);
		account.setPass(pass);
		HttpSession session = request.getSession();
		session.setAttribute("accounBeans",account);

		// セッションスコープへ処理内容を送信
		String action = "get";
		session.setAttribute("action", action);

		/*RequestDispatcher dispatcher = request.getRequestDispatcher("/loginResult.jsp");
		dispatcher.forward(request, response);*/

		//AccountDAO生成
		AccountDAO  accountDAO = new AccountDAO();

		//既存アカウントと新規アカウントの精査
		boolean check =accountDAO.getAccount(account);

		if(check) {

			//ログイン完了
			// loginResult.jspへ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/loginResult.jsp");
			dispatcher.forward(request, response);

		}else {

			//ログイン失敗
			// セッションスコープとBeansを破棄
			session.removeAttribute("accounBeans");
			account = null;

			// login.jspへ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);

		}
	}



	/**
	 * アカウント作成処理を行うメソッド。
	 *
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//LoginページのNameとPassを受け取る。
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		/* ADD if @author 近藤 */
		if (!pass.contentEquals(request.getParameter("pass")))
		{	// 確認欄とパスワードが一致しない場合は登録処理を行わずlogin.jspへ

			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);

		}	//if end

		//nameとpassの値をaccounBeansに保存。
		AccountBeans account = new AccountBeans();
		account.setName(name);
		account.setPass(pass);
		HttpSession session = request.getSession();
		session.setAttribute("accounBeans",account);

		// セッションスコープへ処理内容を送信
		String action = "post";
		session.setAttribute("action", action);

		//AccountDAO生成
		AccountRegistDAO accountRegistDAO = new AccountRegistDAO();

		//既存アカウント名と被らないように新規アカウントを保存。
		boolean check = accountRegistDAO.createAccount(account);

		if(check) {

			//新規アカウント登録&ログイン完了
			// loginResult.jspへ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/loginResult.jsp");
			dispatcher.forward(request, response);

		}else {

			//被るので登録不可
			// セッションスコープとBeansを破棄
			session.removeAttribute("accounBeans");
			account = null;

			// login.jspへ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);

		}
	}

}
