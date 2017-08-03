package pg_ex01_2;


import java.util.ArrayList;
import java.util.Scanner;



public class Arabia {


	public static void main(String[] args) {

				// 入力と表示
				System.out.println("1～20までのアラビア数字を入力してください。");

				// 数字の入力
				Scanner ins = new Scanner(System.in);
				int num = ins.nextInt();

				// 入力された数列のメイン処理
				String ans = convertNum(num);

				// 変換値の表示
				System.out.println(ans);
	}

	// ローマ数列をアラビア数列に変換するメインメソッド

	public static String convertNum(int insNum) {

			// アラビア数列の整合性チェック
			checkArab(insNum);

			// アラビア数列をリストに格納
			ArrayList<Integer> numList = makeInList(insNum);

			// アラビア数列リストをローマ数列リストへ変換
			ArrayList<String> romeList = makeList(numList);

			// ローマ数列を処理して解を出力する
			String ans = String.valueOf(ConnectRomeNumList(romeList));

			return ans;

	}

	// アラビア数列を桁ごとにリストへ入れる処理

	private static ArrayList<Integer> makeInList(int arabNum) {

		ArrayList<Integer> numList = new ArrayList<Integer>();

		String strNum = String.valueOf(arabNum);

		for (int i = 0; i <= strNum.length() - 1; i++) {

			numList.add(Integer.parseInt("" + strNum.charAt(i)));

		}

		return numList;

	}



	// 桁数ごとに処理を切り替えて数値へ変換した値をリストで返す処理

	private static ArrayList<String> makeList(ArrayList<Integer> numList) {

		// 何桁か調べる

		int digits = numList.size();

		ArrayList<String> romeList = new ArrayList<String>();

		for (int i = 0; i <= numList.size() - 1; i++) {

			romeList.add(convertArabToRome(numList.get(i), digits - i));

		}

		return romeList;

	}



	// アラビア→ローマ変換

	private static String convertArabToRome(int arabNum, int digits) {

		String romeNum = "";

		String[][] digitsMatrix = { { "I", "X" },

								{"II", "XX"}, {"III"},

								{"IV"}, {"V"}, {"VI"},

								{"VII"}, {"VIII"},

								{"IX"} };

		for (int i = 1; i <= 9; i++) {
			if (arabNum == i) {

				romeNum = digitsMatrix[i - 1][digits - 1];

			}
		}

		return romeNum;

	}

	// リストを一つの文字列にまとめる処理

	private static String ConnectRomeNumList(ArrayList<String> romeNum) {

		String ans = "";

		for (int i = 0; i <= romeNum.size() - 1; i++) {

			ans = ans + romeNum.get(i);

		}

		return ans;

	}

	// アラビア数列チェック;
	private static boolean checkArab(int insNum) {

		boolean result = true;

		if (insNum < 1 || 20 < insNum) {

			throw new RuntimeException("変換できません。初めからやり直してください。");

		}

		return result;

	}

}