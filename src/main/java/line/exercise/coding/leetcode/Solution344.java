package line.exercise.coding.leetcode;

import java.util.Arrays;

/**
 * 翻转字符数组
 * 
 * @author line
 * @date 2019年2月12日 下午8:44:50
 */
public class Solution344 {

	public void reverseString(char[] s) {
		for (int i = 0, j = s.length - 1; i < j; i++, j--) {
			swap(s, i, j);
		}
	}
	
	private void swap(char[] s, int i, int j) {
//		char tmp = s[i];
//		s[i] = s[j];
//		s[j] = tmp;
		
//		换成位运算，也还是很慢额。12ms
		s[i] = (char) (s[i] ^ s[j]);
		s[j] = (char) (s[i] ^ s[j]);
		s[i] = (char) (s[i] ^ s[j]);
	}
	
	public static void main(String[] args) {
		char[] s = "\0hel lo!".toCharArray();
		new Solution344().reverseString(s);
		System.out.println(Arrays.toString(s));
	}
}
