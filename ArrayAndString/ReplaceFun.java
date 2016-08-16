package ArrayAndString;

/**
 * Write a method to replace all spaces in a string with ‘%20
 * @author Chi
 * 
 * 分析：
 * 1、Java中string类型不可变，因此需要的输入参数是char[]
 * 2、一个空白字符占一个位置，%20占据三个位置，因此需要重新计算替换后字符串的长度
 * 3、当前字符不是空白字符：正常复制
 * 	若当前字符为空白字符：则需要三个位置存储% 2 0；
 * 
 * 
 * shift技术
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
