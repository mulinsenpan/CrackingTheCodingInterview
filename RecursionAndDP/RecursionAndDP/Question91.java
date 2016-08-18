package RecursionAndDP;
import java.util.Timer;

/**
 * A child is running up a staircase with n steps, and can hop either 1step, 2 steps, or
3 steps at a time. Implement a method to count how many possible ways the child
can run up the stairs.
 * @author Chi
 * 
 * Solution1:
 * �������µĵݹ飺�����ڵ�n��̨��ʱ��ǰһ״̬���Դ���n-1��n-2����n-3��̨�ף�
 * 			������һ״̬���㵱ǰ״̬fun(n) = fun(n-1) + fun(n-2) + fun(n-3)
 * �ݹ���ƣ�
 * 	base case�� n<1  fun(n) = 0
 * 				n = 1 fun(n) = 1
 * ���ƹ�ʽ��fun(n) = fun(n-1) + fun(n-2) + fun(n-3)
 *  	
 *  ʱ�临�Ӷȣ�O(3��n�η�)��
 *  
 *  
 *  Solution2:��̬�滮˼��
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
	 * ��̬�滮������
	 * �׶Σ�n���׶�
	 * ״̬����ǰ�׶�iʱ���ܵķ�����Ŀ
	 * ״̬ת�Ʒ��̣�s(i) = s(i-1) + s(i-2) + s(i-3)
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
		System.out.println("����ʱ�䣺" + (end-start) + "����");
		
		
		long start1 = System.currentTimeMillis();
		System.out.println(countwayDP(100));
		long end1 = System.currentTimeMillis();
		System.out.println("����ʱ�䣺" + (end1-start1) + "����");
	
	}

}
