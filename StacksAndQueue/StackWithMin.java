package StacksAndQueue;

import java.time.chrono.MinguoChronology;
import java.util.Stack;

/**
 * How would you design a stack which, in addition to push and pop, also has a function
min which returns the minimum element? Push, pop and min should all operate in
O(1) time
 * @author Chi
 * 
 * 核心问题：以O(1)找到栈中最小的元素
 * 
 *
 */

public class StackWithMin extends Stack<Integer>{
	
	Stack<Integer> s2;
	public StackWithMin(){
		s2 = new Stack<Integer>();
	}
	public void push(int value){
		if (value < min()) {
			s2.push(value);
		}
		super.push(value);
	}
	
	public Integer pop(){
		int value = super.pop();
		if(value == min()){
			s2.pop();
		}
		return value;
	}
	
	public int min(){
		if (s2.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		else{
			return s2.peek();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
