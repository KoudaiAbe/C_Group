package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		try
		{

			ScoreLogic logic = new ScoreLogic();
			List<ScoreBeans> scoreList = logic.rankingLogic((String) request.getAttribute("gameName"));

			System.out.println(scoreList.get(0).getName());

			//出力(レスポンスをmapに格納してJSON化)

			//JSONマップ
			Map<String, String> mapMsg = new HashMap<>();

			//追加
			mapMsg.put("name", scoreList.get(0).getName());
			mapMsg.put("score", scoreList.get(0).getScore());
			mapMsg.put("date", scoreList.get(0).getDate());

			//マッパ(JSON <-> Map, List)
			ObjectMapper mapper = new ObjectMapper();

			//json文字列
			String jsonStr = mapper.writeValueAsString(mapMsg);  //list, map

			//ヘッダ設定
			response.setContentType("application/json;charset=UTF-8");   //JSON形式, UTF-8

			//pwオブジェクト
			PrintWriter pw = response.getWriter();

			//出力
			pw.print(jsonStr);

			//クローズ
			pw.close();

		} catch(Exception e)
		{ e.printStackTrace(); }

	}
}
