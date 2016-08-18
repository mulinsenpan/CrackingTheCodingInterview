package StacksAndQueue;

import java.util.Stack;

/**
 * ��ŵ�����⣨�Զ����£�abcde��,�������ӣ�123
 * ���������
 * ����ֻ�����˵���������(ab)�ƶ�������λ�ã�
 * step1��a�ƶ���2
 * step2:b�ƶ���3
 * step3��a��2�ƶ���3��
 * 
 * ������չ������ƶ���˵�3����
 * �����������֪��ΰ��춥�˵������ƶ������������ϣ����ֻ��Ҫab�ƶ���2�ϣ���c�ƶ���3�ϣ�֮���ٰ�ab�ƶ���3֮�ϼ��ɡ�
 * 
 * ���⣺����ڼ�����н��н�ģ��
 * ���������ȵ�����˳�򣬴������´�С������˵����ó���˳��ͷŽ�ȥ��˳���෴���Ƚ����������ջ�����ԣ������ʹ�ø���ջ�ṹ
 * 
 * 
 * �ݹ�ʵ��
 * 
 * @author Chi
 *
 */
public class Tower {
	private Stack<Integer> disks;
	private int index;
	public Tower(int i){
		disks = new Stack<>();
		index = i;
	}
	public int index(){
		return index;
	}
	
	public void add(int d) {
		if (!disks.isEmpty() && disks.peek() <= d) {
			System.out.println("error placing disk");
		}else{
			disks.push(d);
		}
	}
	
	public void moveTopTo(Tower t) {
		int top = disks.pop();
		t.add(top);
		System.out.println("move disk" +
		top + "from " + index() + 
		"to" + t.index());	
	}
	
	public void print() {
		System.out.println("contents of tower" 
				+ index());
		for(int i = disks.size()-1; i >= 0; i++){
			System.out.println("    " + disks.get(i));
		}
	}
	
	public void moveDisks(int n, Tower destination, Tower buffer) {
			if (n > 0) {
				moveDisks(n-1, buffer, destination);
				moveTopTo(destination);
				buffer.moveDisks(n-1, destination, this);
			}
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		Tower[] towers = new Tower[n];
		for(int i = 0; i < 3; i++){
			towers[i] = new Tower(i);
		}
		for(int i = n-1; i>=0; i--){
			towers[0].add(i);
		}
		towers[0].moveDisks(n, towers[2], towers[1]);
	}

}
