package RecursionAndDP;
import java.util.Timer;

/**
 * A child is running up a staircase with n steps, and can hop either 1step, 2 steps, or
3 steps at a time. Implement a method to count how many possible ways the child
can run up the stairs.
 * @author Chi
 * 
 * Solution1:
 * 从上往下的递归：当处于第n个台阶时，前一状态可以处于n-1，n-2或者n-3个台阶，
 * 			根据上一状态计算当前状态fun(n) = fun(n-1) + fun(n-2) + fun(n-3)
 * 递归设计：
 * 	base case： n<1  fun(n) = 0
 * 				n = 1 fun(n) = 1
 * 递推公式：fun(n) = fun(n-1) + fun(n-2) + fun(n-3)
 *  	
 *  时间复杂度：O(3的n次方)：
 *  
 *  
 *  Solution2:动态规划思想
 *
 */

public class Question91 {
	
	public static long countWay(int n) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}else{
			return countWay(n-1)+countWay(n-2)+countWay(n-3);
		}
	}
	
	/**
	 * 动态规划方法：
	 * 阶段：n个阶段
	 * 状态：当前阶段i时可能的方法数目
	 * 状态转移方程：s(i) = s(i-1) + s(i-2) + s(i-3)
	 * @param n
	 * @return
	 */
	public static long countwayDP(int n) {
		long[] array = new long[n+1];
		array[0] = 0;
		array[1] = 1;
		array[2] = 2;
		array[3] = 4;
		
		for(int i = 4; i < n + 1; i++ ){
			array[i] = array[i-1] + array[i-2] + array[i-3];
		}
		return  array[n];
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
//		System.out.println(countWay(35));
		long end = System.currentTimeMillis();
		System.out.println("运行时间：" + (end-start) + "毫秒");
		
		
		long start1 = System.currentTimeMillis();
		System.out.println(countwayDP(100));
		long end1 = System.currentTimeMillis();
		System.out.println("运行时间：" + (end1-start1) + "毫秒");
	
	}

}
