package line.exercise.coding.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 
 * @author line
 * @date 2019年2月11日 下午10:25:14
 */
public class Solution204 {

	private List<Integer> primes;

	/**
	 * 判断一个数是否是素数。最笨的方法。
	 */
//	private boolean isPrime(int num) {
//		if (num < 1)
//			return false;
//		int sqrt = (int) Math.sqrt(num);
//		for (int i = 2; i <= sqrt; i++) {
//			if (num % i == 0)
//				return false;
//		}
//		return true;
//	}
	/**
	 * 判断一个数是否是素数。比较笨的方法。
	 * 维护一个素数列表。
	 */
	private boolean isPrime(int num) {
		if (num < 2)
			return false;
		int sqrt = (int) Math.sqrt(num);
		for (int p : primes) {
			if (p > sqrt) {
				primes.add(num);
				break;
			}
			if (num % p == 0)
				return false;
		}
		return true;
	}

//	public int countPrimes(int n) {
//		if (n < 3) // less than means < rather than <=
//			return 0;
//		primes = new ArrayList<>(n / 2);
//		primes.add(2);
//		int counter = 1;
//		for (int i = 3; i < n; i++) {
//			System.out.println(Arrays.toString(primes.toArray(new Integer[primes.size()])));
//			if (isPrime(i))
//				counter++;
//		}
//		return counter;
//	}

	/**
	 * 基础筛选法，与前面方法的区别在于，比较有整体性。
	 * https://blog.csdn.net/qq_38595487/article/details/80032510
	 * 
	 * 还有其他升级版的筛选法Orz
	 */
	public int countPrimes(int n) {
		// 下标i代表这个数，false表示素数。一开始全部初始化false
		boolean[] primes = new boolean[n];
		int counter = 0;
		for (int i = 2; i < n; i++) { // 第一个数为2
			if (!primes[i]) { // 是素数
				counter++; // 在这个地方做统计
				for (int j = i + i; j < n; j += i)
					primes[j] = true; // 排除i的倍数：i, 2i, 3i ...
			}
		}
		return counter;
	}

	public static void main(String[] args) {
		Solution204 sol = new Solution204();
//		sol.primes = new ArrayList<>();
//		sol.primes.add(2);
//		for (int i = 0; i < 30; i++) {
//			System.out.println(i + " : " + sol.isPrime(i));
//			System.out.println(Arrays.toString(sol.primes.toArray(new Integer[sol.primes.size()])));
//		}

		System.out.println(sol.countPrimes(100));
	}
}
