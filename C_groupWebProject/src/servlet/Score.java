package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import logic.ScoreLogic;
import model.ScoreBeans;

/**
 * JSPよりデータの取得命令を受けるサーブレットクラス。<br>
 * jacksonを用いてスクリプトより呼び出し、マッパとしてスクリプトへ返す。<br>
 * 利用にはjacksonライブラリが必要となる。
 *
 * @author 近藤
 */
@WebServlet("/Score")
public class Score
extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		ScoreLogic logic = new ScoreLogic();
		List<ScoreBeans> scoreList = logic.rankingLogic((String) request.getAttribute("gameName"));

        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(scoreList);

        request.setAttribute("scoreList", result);

        request.getRequestDispatcher("ranking.jsp").forward(request, response);

	}
}
