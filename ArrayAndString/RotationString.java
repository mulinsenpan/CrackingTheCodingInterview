package com;

/**
 * Assume you have a method isSubstring which checks if one word is a 
 * substring of another Given two strings, s1 and s2, write code to 
 * check if s2 is a rotation of s1 using only one call to isSubstring 
 * (i e , ��waterbottle�� is a rotation of ��erbottlewat��)
 * @author Chi
 *
 *
 *���ɣ���Ҫ�õ�һ��������ַ���ȫ��rotationʱ����������һ�¡�
 *
 *�������⣺�ж������ַ����Ƿ�Ϊrotation
 *���ⱳ����1��ֻ����ʹ��һ������isSubstring
 *		2��rotation��ʲô��˼��һ���ַ�������һ���������ǿ�ʼ�ͽ���ָ��̶�����ת��ƽ�ƣ��õ�����һ���ַ�����
 *		3�������ַ����ĳ����Ƿ���ͬ������ͬ�����Բ���rotation������ͬ���п����ǡ�
 *����1����������һ���ַ�������ʼ�ַ���ritationһ���ַ������Ƚ������ַ���
 *����2:�ַ���A�����ظ�һ�Σ����Եõ�A������rotation��
 *		�ж�B�Ƿ��Ǿ���rotation���A���ִ���
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
