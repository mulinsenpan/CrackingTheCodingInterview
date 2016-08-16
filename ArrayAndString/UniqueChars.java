package ArrayAndString;

/*
 * Implement an algorithm to determine if a string has all unique characters What if you
can not use additional data structures?
 */
public class UniqueChars {
	
	/**
	 * 与字符串相关的问题一个出发点是字符编码
	 * 1、是否是ascll编码
	 * 2、记录该字符是否出现过
	 * 3、若没有出现，则标识变为出现过
	 * 4、若出现过，则返回false
	 * 5、遍历完返回true；
	 * 
	 * 分析：时间复杂度O(n)，空间复杂度O(n)
	 * @param str
	 * @return
	 */
	private boolean isUnique(String str){
		boolean[] char_set = new boolean[256];
		for(int i = 0; i < str.length(); i++){
			int val = str.charAt(i);
			if(char_set[val]){
				return false;
			}
			char_set[val] = true;
		}
		
		return true;
	}
	
	/**
	 * 方法二：比较某一个字符与其他字符，若相同，则标识有重复的字符
	 * 		遍历完则返回true
	 * 分析：时间复杂度O(n*n)
	 * 空间复杂度0；
	 * 
	 * 
	 * 方法三：先排序，在比较相邻的字符串。
	 */
	private boolean isUnique2(String str){
		for(int i = 0; i < str.length(); i++){
			for(int j = 0; j < str.length() && j != i; j++){
				if(str.charAt(i) == str.charAt(j)){
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "";
		UniqueChars uc = new UniqueChars();
		System.out.println(uc.isUnique(a));
		System.out.println(uc.isUnique2(a));

	}

}
