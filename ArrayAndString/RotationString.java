package com;

/**
 * Assume you have a method isSubstring which checks if one word is a 
 * substring of another Given two strings, s1 and s2, write code to 
 * check if s2 is a rotation of s1 using only one call to isSubstring 
 * (i e , “waterbottle” is a rotation of “erbottlewat”)
 * @author Chi
 *
 *
 *技巧：想要得到一个数组或字符的全部rotation时，不妨复制一下。
 *
 *核心问题：判断两个字符串是否互为rotation
 *问题背景：1、只允许使用一个方法isSubstring
 *		2、rotation是什么意思？一个字符串看成一个环，但是开始和结束指针固定，旋转（平移）得到另外一个字符串。
 *		3、两个字符串的长度是否相同？若不同则明显不是rotation；若相同则有可能是。
 *方法1：根据另外一个字符串的起始字符，ritation一个字符串，比较两个字符串
 *方法2:字符串A自身重复一次，可以得到A的所有rotation。
 *		判断B是否是经过rotation后的A的字串。
 */

public class RotationString {
	
	private static boolean rotation(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		if(str1.length() == str2.length() && str1.length()>0){
			String new_str1 = str1 + str1;
			
			return isSubString(new_str1, str2);
		}
		return false;
	}
	
	private static boolean isSubString(String s1, String s2) {
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
