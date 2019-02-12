package line.exercise.coding.leetcode.utils;

/**
 * 
 * 
 * @author line
 * @date 2019年2月12日 下午9:25:09
 */
public class MyPrinter {

	public static void print(char[] a, int begin, int end) {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (int i = begin; i <= end; i++) {
			sb.append(a[i]).append(", ");
		}
		sb.delete(sb.length() - 2, sb.length()).append(']');
		System.out.println(sb.toString());
	}

	public static void print(byte[] a, int begin, int end) {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (int i = begin; i <= end; i++) {
			sb.append(a[i]).append(", ");
		}
		sb.delete(sb.length() - 2, sb.length()).append(']');
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) {
		String test = "hello";
		print(test.toCharArray(), 0, 0);

		print(test.getBytes(), 0, 0);
	}
}
