package line.exercise.coding.leetcode;

import line.exercise.coding.leetcode.utils.MyPrinter;

/**
 * 
 * 
 * @author line
 * @date 2019年2月12日 下午9:05:30
 */
public class Solution541 {
	public String reverseStr(String s, int k) {
		byte[] bs = s.getBytes(); // 题目规定只有小写英文，因此这里可以用byte[]
		int i, j;
		for (i = 0, j = i + k * 2 - 1; j < bs.length; i = j + 1, j = i + k * 2 - 1) {
//			MyPrinter.print(bs, i, i + k + k - 1);
			handle(bs, i, i + k - 1);
//			MyPrinter.print(bs, i, i + k + k - 1);
//			System.out.println("-----------------");
		}
		int left = bs.length - i;
//		System.out.println(left);
//		MyPrinter.print(bs, i, bs.length - 1);
		if (left < k) {
			handle(bs, i, i + left - 1);
		} else {
			handle(bs, i, i + k - 1);
		}
//		MyPrinter.print(bs, i, bs.length - 1);
		
		return new String(bs);
	}

	private void handle(byte[] bs, int from, int to) {
		while (from < to) {
			swap(bs, from++, to--);
		}
	}

	private void swap(byte[] bs, int i, int j) {
//		换成位运算，也还是很慢额。12ms
		bs[i] = (byte) (bs[i] ^ bs[j]);
		bs[j] = (byte) (bs[i] ^ bs[j]);
		bs[i] = (byte) (bs[i] ^ bs[j]);
	}

	public static void main(String[] args) {
		String s = "abcdefghijklmn";
		Solution541 sol = new Solution541();
		System.out.println(sol.reverseStr(s, 2));
	}
}
