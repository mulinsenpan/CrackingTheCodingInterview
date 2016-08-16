package ArrayAndString;

/**
 * Design an algorithm and write code to remove the duplicate characters in a string
without using any additional buffer NOTE: One or two additional variables are fine
An extra copy of the array is not
 * @author Chi
 *
 *
 *问题1：不能使用additional buffer时什么意思？
 *问题2：可否使用固定长度的数组
 *
 *
 */


public class RemoveDuplicates {
	
	/*
	 * 就地解决问题：不能使用其他数组
	 * 问题分析：
	 * 1、问题明确：删除一个字符串中所有的重复字符，只保留非重复的字符
	 * 			字符串是一个什么样的字符串：空字符串，长度为1，长度大于1
	 * 2、问题背景：不能使用其他辅助数组等；
	 * 3、Java中的字符串不可变，因此需要使用辅助的结构
	 * 4、尾指针的用法：从开头到尾指针中间的 内容是没有重复的，判断其他字符是否在其中。
	 */
	private static String remove(String str){
		if (str == null) {
			return null;
		}
		if(str.length() < 2){
			return str;
		}
		int tail = 1;
		char[] char_set = str.toCharArray();
		for(int i = 1; i < str.length(); i++){
			int j;
			for(j = 0; j < tail; j++){
				if (char_set[i] == char_set[j]) {
					char_set[i] = '\0';
				}
			}
			if(j == tail){
				char_set[tail] = char_set[i];
				tail += 1;
			}
		}
		return new String(char_set);
	} 
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abcdefg";
		String b = "accbd";
		String c = "";
		String d = "a";
		String e = "aaabbb";
		System.out.println(remove(a));
		System.out.println(remove(b));
		System.out.println(remove(c));
		System.out.println(remove(d));
		System.out.println(remove(e));
	}

}
