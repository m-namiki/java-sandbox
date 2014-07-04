/**
 * 
 */
package jp.co.shantery.sandbox.paiza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * N種類のそれぞれ決まった抵抗値Ωを持った抵抗のみで構成された回路があります。<br>
 * 回路の始点と終点は１つだけです。 <br>
 * 抵抗は直列と並列で並んでおり、それぞれ最大M個まで繋がります。
 * </p>
 * <p>
 * 全体での抵抗値(Ω)を求めてください。 <br>
 * 抵抗値(Ω)の計算法則は以下のとおりです。
 * 
 * <pre>
 * ２つの抵抗値A,Bがある場合
 * ・直列の抵抗値 = A + B
 * ・並列の抵抗値 = 1 / (1 / A + 1 / B)
 * </pre>
 * 
 * <h3>入力値</h3>
 * 1行目には入力される抵抗の種類の総数Nが入力されます。<br>
 * 続いて、アルファベット1文字、数字がスペース区切りで入力されます。重複して入力されることはありません。<br>
 * 最終行には、2行目以降に入力された抵抗に対応したアルファベットが入力されます。<br>
 * スペース区切りで直列、区切りがない場合は並列とします。直列、並列ともにM以下の個数とします。
 * 
 * <h3>期待する出力</h3>
 * 小数点以下を切り捨てた値を出力してください。<br>
 * ただし、計算過程では小数点を考慮してください。
 * </p>
 * 
 * <h3>条件</h3> 10個のテストケースの内、8個のテストケースにおいて以下の条件を満たします。
 * 
 * <pre>
 * 1 ≦ N ≦ 26
 * 1 ≦ M ≦ 10
 * 1 ≦ Ω ≦ 1000
 * 10個のテストケースの内、全てのテストケースにおいて以下の条件を満たします。
 * 1 ≦ N ≦ 26
 * 1 ≦ M ≦ 1000
 * 1 ≦ Ω ≦ 1000
 * </pre>
 * 
 * @author m2-namiki
 * 
 */
public class B002Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			String line = null;

			Map<String, Integer> resistanceValueMap = new HashMap<>();

			String formula = null;

			int paramSize = 0;
			int index = 0;
			while ((line = reader.readLine()) != null) {
				if ("".equals(line)) {
					break;
				}
				if (0 == index) {
					paramSize = Integer.valueOf(line);
				} else if (0 < index && index <= paramSize) {
					String[] array = line.split(" ");
					resistanceValueMap.put(array[0], Integer.valueOf(array[1]));
				} else {
					formula = line;
				}

				index++;
			}

			double value = 0;

			String[] array = formula.split(" ");
			for (String s : array) {
				if (s.length() == 1) {
					value += resistanceValueMap.get(s);
				} else {
					double[] d = new double[s.length()];
					for (int i = 0; i < s.length(); i++) {
						String key = String.valueOf(s.charAt(i));
						d[i] = resistanceValueMap.get(key);
					}
					double v = 0;
					for (int i = 0; i < d.length; i++) {
						v += (1 / d[i]);
					}
					value += 1 / v;
				}
			}
			value = Math.floor(value);

			DecimalFormat f = new DecimalFormat("####");
			System.out.println(f.format(value));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
				}
			}
		}
	}

}
