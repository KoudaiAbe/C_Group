package servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GameDAO;
import model.AccountBeans;
import model.GameBeans;

/**
 * Servlet implementation class GameInspector
 */
@WebServlet("/GameInspector")
public class GameInspector extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GameInspector() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/*doPOSTでゲーム名とゲームスコアを受け取る。*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		try {

			AccountBeans account = (AccountBeans) session.getAttribute("account");

		}catch(IllegalStateException ex) {
			return;
		}

		String game = request.getParameter("game");
		String score = request.getParameter("score");

		/*プレイ日時としてリアルタイム取得。*/

		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		String year = Integer.toString(c.get(Calendar.YEAR));
		String month = Integer.toString(c.get(Calendar.MONTH));
		String day = Integer.toString(c.get(Calendar.DAY_OF_MONTH));
		String hour = Integer.toString(c.get(Calendar.HOUR));
		String minute = Integer.toString (c.get(Calendar.MINUTE));
		String second = Integer.toString (c.get(Calendar.SECOND));

		/*Beansへ保存。*/

		GameBeans data = new GameBeans();
		data.setGame(game);
		data.setScore(score);
		data.setYear(year);
		data.setMonth(month);
		data.setDay(day);
		data.setHour(hour);
		data.setMinute(minute);
		data.setSecond(second);

		session.setAttribute("data", data);

		GameDAO gameDAO = new GameDAO();
		gameDAO.postData(account,data);


	}

}
