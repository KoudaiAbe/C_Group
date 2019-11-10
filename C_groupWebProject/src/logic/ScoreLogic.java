package logic;

import java.util.ArrayList;
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

		//TODO とりあえずインスタンス生成して呼び出して返すだけ
		//ScoreDAO inst = new ScoreDAO();
		//return inst.getRankingList(game);

		//TODO チェック用のBeansを返す
		List<ScoreBeans> scoreList = new ArrayList<>();
		ScoreBeans bean = new ScoreBeans();
		bean.setName("TEST");
		bean.setGame("GAMENAME");
		bean.setScore("9999");
		bean.setDate("9999/99/99");
		scoreList.add(bean);

		return scoreList;


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
