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

			//出力(レスポンスをmapに格納してJSON化)

			//JSONマップ
			Map<String, String> mapMsg = new HashMap<>();

			//追加
			for (int index = 0 ; index < scoreList.size() ; index++)
			{	// scoreListをマップへ挿入

				String name = "name"+ index;
				String score = "score"+ index;
				String date = "date"+ index;

				mapMsg.put(name, scoreList.get(index).getName());
				mapMsg.put(score, scoreList.get(index).getScore());
				mapMsg.put(date, scoreList.get(index).getDate());

			}	// for end

			mapMsg.put("LIST_RENGTH", Integer.toString(scoreList.size()));

			//マッパ(JSON <-> Map, List)
			ObjectMapper mapper = new ObjectMapper();

			//json文字列
			String jsonStr = mapper.writeValueAsString(mapMsg);

			//ヘッダ設定
			response.setContentType("application/json;charset=UTF-8");

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
