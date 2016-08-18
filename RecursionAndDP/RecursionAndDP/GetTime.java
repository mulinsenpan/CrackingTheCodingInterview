package RecursionAndDP;

public abstract class GetTime {
	public final void getTime(){
		long start = System.currentTimeMillis();
		
		long end = System.currentTimeMillis();
		System.out.println("运行时间：" + (end-start) + "毫秒");
	}

	public abstract int runcode();

}
