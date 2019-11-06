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
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("get");

		//Login.jspのNameとPassを受け取る。
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		//nameとpassの値をaccounBeansに保存。
		AccountBeans account = new AccountBeans();
		account.setName(name);
		account.setPass(pass);
		HttpSession session = request.getSession();
		session.setAttribute("accounBeans",account);

		System.out.println(name);
		System.out.println(pass);

		// セッションスコープへ処理内容を送信
		String action = "get";
		session.setAttribute("action", action);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/loginResult.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("post");

		//Login.jspのNameとPassを受け取る。
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		boolean check = pass.contentEquals(request.getParameter("pass"));

		//nameとpassの値をaccounBeansに保存。
		AccountBeans account = new AccountBeans();
		account.setName(name);
		account.setPass(pass);
		HttpSession session = request.getSession();
		session.setAttribute("accounBeans",account);

		System.out.println(name);
		System.out.println(pass);
		System.out.println(check);

		// セッションスコープへ処理内容を送信
		String action = "get";
		session.setAttribute("action", action);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/loginResult.jsp");
		dispatcher.forward(request, response);
	}

}
