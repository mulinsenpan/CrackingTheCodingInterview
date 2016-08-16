package ArrayAndString;

/**
 * Design an algorithm and write code to remove the duplicate characters in a string
without using any additional buffer NOTE: One or two additional variables are fine
An extra copy of the array is not
 * @author Chi
 *
 *
 *����1������ʹ��additional bufferʱʲô��˼��
 *����2���ɷ�ʹ�ù̶����ȵ�����
 *
 *
 */


public class RemoveDuplicates {
	
	/*
	 * �͵ؽ�����⣺����ʹ����������
	 * ���������
	 * 1��������ȷ��ɾ��һ���ַ��������е��ظ��ַ���ֻ�������ظ����ַ�
	 * 			�ַ�����һ��ʲô�����ַ��������ַ���������Ϊ1�����ȴ���1
	 * 2�����ⱳ��������ʹ��������������ȣ�
	 * 3��Java�е��ַ������ɱ䣬�����Ҫʹ�ø����Ľṹ
	 * 4��βָ����÷����ӿ�ͷ��βָ���м�� ������û���ظ��ģ��ж������ַ��Ƿ������С�
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
