package com;

/**
 * C-Style string :C-String means that “abcd” is represented as
five characters, including the null character
\0 为结束标志

Write code to reverse a C-Style String 

 * @author Chi
 *
 */
public class ReverseCStyleString {
	
	/**
	 * 方法1：从后往前遍历，存放到一个新的字符数组中
	 * 方法2：使用两个指针：一个从左向右，一个从右向左
	*/
	
	private static String reverse(String str){
		char[] char_set = str.toCharArray();
		int left = 0;
		int right = str.length()-2;  // 最后一个空字符
		while(left <= right){
			char temp = char_set[left];
			char_set[left] = char_set[right];
			char_set[right] = temp;
			left ++;
			right --;
		}
		
		return new String(char_set);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = "hello world " + "\0";
		System.out.print(reverse(a));

	}

}
