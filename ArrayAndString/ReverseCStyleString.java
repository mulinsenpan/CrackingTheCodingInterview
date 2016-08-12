package com;

/**
 * C-Style string :C-String means that ��abcd�� is represented as
five characters, including the null character
\0 Ϊ������־

Write code to reverse a C-Style String 

 * @author Chi
 *
 */
public class ReverseCStyleString {
	
	/**
	 * ����1���Ӻ���ǰ��������ŵ�һ���µ��ַ�������
	 * ����2��ʹ������ָ�룺һ���������ң�һ����������
	*/
	
	private static String reverse(String str){
		char[] char_set = str.toCharArray();
		int left = 0;
		int right = str.length()-2;  // ���һ�����ַ�
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
