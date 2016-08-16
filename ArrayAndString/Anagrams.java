package ArrayAndString;

/**
 * Write a method to decide if two strings are anagrams or not
 * @author Chi
 *
 */
public class Anagrams {
	
/**
 * ����1��ͳ������string��ÿ���ַ����ֵĴ�����
 * �̶����ȵ����飺��¼ÿ���ַ����ֵĴ���:���ֵ��Ч�������ȹ̶�����Ϊ���ܰ���Ԫ�ص������ǹ̶���
 * ʹ�����������¼ÿ���ַ����ֵĴ�����
 * ����ʹ��һ����
 * ��ʹ����������ֱ��¼
 * ��ʹ��һ��������ͳ��һ����������һ���ַ�����ʹ�ü�����
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
				return false;  //����str1��δ�������ַ�����ĳһ�ַ�������
			}
			count[c] -= 1;
			if(count[c] == 0){
				unique_2 += 1;
				if(unique_1 == unique_2){
					return i == str2.length() -1;  //���ж������һ���ַ�ʱ�Ż᷵��true
				}
			}	
		}
		return false;
		
	}
	
	/**
	 * ����������������Ƚ��ַ��Ƿ���ͬ 
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String aString = "abcdde";
		String bString = "badace";
		System.out.println(isAnagrams(aString, bString));

	}

}
