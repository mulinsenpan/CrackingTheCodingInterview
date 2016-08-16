package ArrayAndString;

/**
 * Write a method to replace all spaces in a string with ��%20
 * @author Chi
 * 
 * ������
 * 1��Java��string���Ͳ��ɱ䣬�����Ҫ�����������char[]
 * 2��һ���հ��ַ�ռһ��λ�ã�%20ռ������λ�ã������Ҫ���¼����滻���ַ����ĳ���
 * 3����ǰ�ַ����ǿհ��ַ�����������
 * 	����ǰ�ַ�Ϊ�հ��ַ�������Ҫ����λ�ô洢% 2 0��
 * 
 * 
 * shift����
 *
 */


public class ReplaceFun {
	
	private static void replace(char[] str) {
		
		int length = str.length;
		int space_count = 0;
		for(int i = 0; i < length; i++){
			if(str[i] == ' '){
				space_count += 1;
			}
		}
		
		int new_lenght = length + space_count * 2;
		char[] new_str = new char[new_lenght];
		for(int j = length - 1; j > -1; j--){
			if(str[j] == ' '){
				new_str[new_lenght-1] = '0';
				new_str[new_lenght-2] = '2';
				new_str[new_lenght-3] = '%';
				new_lenght -= 3;
			}
			else{
				new_str[new_lenght-1] = str[j];
				new_lenght -= 1;
			}
		}
		System.out.println(new String(new_str));
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "a b d c d e ";
		char[] a_array = a.toCharArray();
		replace(a_array);

	}

}
