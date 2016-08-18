package StacksAndQueue;

import java.util.Stack;

/**
 * 汉诺塔问题（自定上下：abcde）,三个柱子：123
 * 问题分析：
 * 假设只需把最顶端的两个碟子(ab)移动到其他位置：
 * step1：a移动到2
 * step2:b移动到3
 * step3：a从2移动到3；
 * 
 * 问题扩展：如何移动最顶端的3个？
 * 问题分析：已知如何把嘴顶端的两个移动到其他柱子上，因此只需要ab移动到2上，把c移动到3上，之后再把ab移动到3之上即可。
 * 
 * 问题：如何在计算机中进行建模？
 * 分析：首先碟子有顺序，从上往下从小到大，因此碟子拿出的顺序和放进去的顺序相反，先进后出（符合栈的特性），因此使用辅助栈结构
 * 
 * 
 * 递归实现
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
