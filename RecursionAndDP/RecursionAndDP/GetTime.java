package RecursionAndDP;

public abstract class GetTime {
	public final void getTime(){
		long start = System.currentTimeMillis();
		
		long end = System.currentTimeMillis();
		System.out.println("����ʱ�䣺" + (end-start) + "����");
	}

	public abstract int runcode();

}
