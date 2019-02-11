package line.exercise.coding.leetcode;

/**
 * 
 * 
 * @author line
 * @date 2019年2月11日 下午9:08:41
 */
public class Solution263 {
	public boolean isUgly(int num) {
		if (num < 1)
			return false;
		while ((num & 1) == 0)
			num = num >> 1;
		while (num % 3 == 0)
			num = num / 3;
		while (num % 5 == 0)
			num = num / 5;

		return num == 1;
	}
}
