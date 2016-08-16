package ArrayAndString;

/*
 * Implement an algorithm to determine if a string has all unique characters What if you
can not use additional data structures?
 */
public class UniqueChars {
	
	/**
	 * ���ַ�����ص�����һ�����������ַ�����
	 * 1���Ƿ���ascll����
	 * 2����¼���ַ��Ƿ���ֹ�
	 * 3����û�г��֣����ʶ��Ϊ���ֹ�
	 * 4�������ֹ����򷵻�false
	 * 5�������귵��true��
	 * 
	 * ������ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(n)
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
	 * ���������Ƚ�ĳһ���ַ��������ַ�������ͬ�����ʶ���ظ����ַ�
	 * 		�������򷵻�true
	 * ������ʱ�临�Ӷ�O(n*n)
	 * �ռ临�Ӷ�0��
	 * 
	 * 
	 * ���������������ڱȽ����ڵ��ַ�����
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
