package line.exercise.coding.leetcode;

/**
 * 
 * 
 * @author line
 * @date 2019年2月12日 下午10:15:22
 */
public class Solution557 {

	public String reverseWords(String s) {
		int i = 0;
		char[] cs = s.toCharArray();
		while (i < cs.length) {
			int j = i;
			while (++i < cs.length && cs[i] != ' ');
			handle(cs, j, i - 1);
			i++;
		}
		return new String(cs);
	}
	private void handle(char[] a, int from, int to) {
		while (from < to) {
			swap(a, from++, to--);
		}
	}
	private void swap(char[] a, int i, int j) {
//		换成位运算，也还是很慢额。12ms
		a[i] = (char) (a[i] ^ a[j]);
		a[j] = (char) (a[i] ^ a[j]);
		a[i] = (char) (a[i] ^ a[j]);
	}
	
	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
		System.out.println(new Solution557().reverseWords(s));
	}
}
