package line.exercise.coding.leetcode;

/**
 * 动态规划问题。
 * 现在暂时复制了别人的代码。https://www.cnblogs.com/njczy2010/p/5708377.html
 * 未来考虑自己想一个方程 2^a * 3^b * 5^c来解这个问题。
 * 
 * @author line
 * @date 2019年2月11日 下午9:32:39
 */
public class Solution264 {

	public int nthUglyNumber(int n) {
		int[] dp = new int[n];
		int index_2 = 0, index_3 = 0, index_5 = 0;
		int val_2 = 2, val_3 = 3, val_5 = 5;
		int i = 1;
		dp[0] = 1;
		for (; i < n; i++) {
			int val = min(val_2, val_3, val_5);
			if (val == val_2) {
				dp[i] = val_2;
				index_2++;
				val_2 = dp[index_2] * 2;
			}
			if (val == val_3) {
				dp[i] = val_3;
				index_3++;
				val_3 = dp[index_3] * 3;
			}
			if (val == val_5) {
				dp[i] = val_5;
				index_5++;
				val_5 = dp[index_5] * 5;
			}
		}
		return dp[n - 1];
	}

	private int min(int val_2, int val_3, int val_5) {
		return Math.min(val_2, Math.min(val_3, val_5));
	}

	public static void main(String[] args) {
		for (int n = 1; n < 100; n++) {
			System.out.print(n + " : ");
			System.out.println(new Solution264().nthUglyNumber(n));
		}
	}
}
