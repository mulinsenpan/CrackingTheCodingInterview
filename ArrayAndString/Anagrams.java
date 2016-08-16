package ArrayAndString;

/**
 * Write a method to decide if two strings are anagrams or not
 * @author Chi
 *
 */
public class Anagrams {
	
/**
 * 方法1：统计两个string中每个字符出现的次数。
 * 固定长度的数组：记录每个字符出现的次数:起到字典的效果；长度固定是因为可能包含元素的总数是固定的
 * 使用两个数组记录每个字符出现的次数？
 * 还是使用一个？
 * 若使用两个：则分别记录
 * 若使用一个：则先统计一个，对另外一个字符串，使用减法。
 * 
*/
	private static boolean isAnagrams(String str1, String str2) {
		int[] count = new int[256];
		char[] char_set = str1.toCharArray();
		int unique_1 = 0;
		int unique_2 = 0;
		for (char c : char_set) {
			if (count[c] == 0) {
				unique_1 += 1;
			}
			count[c] += 1;
		}

		for(int i = 0; i < str2.length(); i++){
			int c = (int)str2.charAt(i);
			
			if(count[c] == 0){
				System.out.println(1);
				return false;  //包含str1中未包含的字符或者某一字符次数多
			}
			count[c] -= 1;
			if(count[c] == 0){
				unique_2 += 1;
				if(unique_1 == unique_2){
					return i == str2.length() -1;  //当判断完最后一个字符时才会返回true
				}
			}	
		}
		return false;
		
	}
	
	/**
	 * 方法二：排序，逐个比较字符是否相同 
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String aString = "abcdde";
		String bString = "badace";
		System.out.println(isAnagrams(aString, bString));

	}

}
