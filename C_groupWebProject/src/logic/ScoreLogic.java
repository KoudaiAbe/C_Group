package logic;

import java.util.LinkedList;
import java.util.List;

import dao.ScoreDAO;
import model.GameBeans;
import model.ScoreBeans;

/**
 * ランキングや履歴表示のためのリストコレクションを受信、送信するクラス。<br>
 * 各ページにアクセスされた時にScoreDAOへ接続し処理を行う。
 *
 * @author 近藤
 */
public class ScoreLogic
{

	/**
	 * ランキング表示用のリストコレクションの作成を命令するメソッド。<br>
	 * どのゲームのリストコレクションを作成するかを引数で受け取り指定する。
	 *
	 * @param game
	 * 取得するリストのゲーム名
	 *
	 * @return
	 * ランキングのリストコレクション
	 */
	public List<ScoreBeans> rankingLogic(String game)
	{

		ScoreDAO inst = new ScoreDAO();
		List<ScoreBeans> scoreList = new LinkedList<>();
		//scoreList = inst.getRankingList();

		//TODO チェック用のBeansを返す
		ScoreBeans bean = new ScoreBeans();
		bean.setName("TEST");
		bean.setGame("GAMENAME");
		bean.setScore("9999");
		bean.setDate("9999/99/99");
		scoreList.add(bean);
		return scoreList;

//		for (int index = 0 ; index < scoreList.size() ; index++)
//		{	// 受け取ったリストから指定のゲームのみを抽出する
//
//			// 要求したゲームデータでなければ排除
//			if (!scoreList.get(index).getGame().contentEquals(game))
//			{ scoreList.remove(index); }
//
//		}	// for end
//
//		// リストをスコアの降順に並べ換える
//		Collections.sort(scoreList, new Comparator<ScoreBeans>() {
//			@SuppressWarnings("unused")
//			public static final int ASC = 1;   //昇順 (1.2.3....)
//			public static final int DESC = -1; //降順 (3.2.1....)
//
//			@Override
//			public int compare(ScoreBeans value1, ScoreBeans value2)
//			{
//				int sortType = DESC;
//				if (value1 == null && value2 == null)
//				{ return 0; }
//				else if (value1 == null)
//				{ return 1 * sortType; }
//				else if (value2 == null)
//				{ return -1 * sortType; }
//
//				int score1 = Integer.parseInt(value1.getScore());
//				int score2 = Integer.parseInt(value2.getScore());
//
//				return (score1 - score2) * sortType;
//			}
//		});
//
//		return scoreList;

	}	// rankingLogic method end



	/**
	 * プレイ履歴表示用のリストコレクションの作成を命令するメソッド。<br>
	 * どのユーザのリストコレクションを作成するかを引数で受け取り指定する。
	 *
	 * @param name
	 * 取得するリストのユーザ名
	 *
	 * @return
	 * プレイ履歴のリストコレクション
	 */
	public List<GameBeans> historyLogic(String name)
	{	//TODO 実装予定

		ScoreDAO inst = new ScoreDAO();
		return inst.getHistoryList(name);

	}	// historyLogic method end
}
