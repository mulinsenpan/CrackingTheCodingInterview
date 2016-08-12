package notes;

import java.lang.reflect.Field;

public class Reflection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "aaaaaaa";
		System.out.println(a);
		try {
			Field field = a.getClass().getDeclaredField("value");
			field.setAccessible(true);
			if(null != field.get("value")){
				System.out.println(field.get("value"));
			}else{
				System.out.println("no data");
			}
			field.set(a, new char[]{'b'});
			System.out.println(a);
			
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
