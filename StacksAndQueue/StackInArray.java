package StacksAndQueue;

/**
 * escribe how you could use a single array to implement three stacks
 * @author Chi
 * 问题：如何使用一个array实现三个栈？
 * 问题背景：array：固定长度
 * 		栈：先进后出；需要记录栈顶和栈底位置；每个栈的长度固定相同？需要实现进栈、出栈、peek、isEmpty等操作
 * 
 * 问题分析：假设每个栈的长度均为array长度的三分之一，则对栈进行操作时，需要明确对哪个栈进行操作，即需要知道栈的下标
 *
 */

public class StackInArray {
	int stackSize = 300;
	int[] buffer = new int[stackSize * 3];
	int[] stackPointer = {0, 0, 0};    // 记录栈顶位置
	
	void push(int stackNum, int value){
		//step1:根据stackNum 找到栈顶位置，即需要进栈的value在数组中的下标
		int index = stackNum * stackSize + stackPointer[stackNum] + 1;
		
		stackPointer[stackNum] += 1; // 更改当前栈的栈顶位置
		
		buffer[index] = value; // 记录栈顶数据
	}
	
	//出栈操作:对哪个栈进行操作
	int pop(int stackNum){
		//step 1:找到对应的元素在数组中的下标
		int index = stackNum * stackSize + stackPointer[stackNum];
		//step 2:栈顶位置-1；
		stackPointer[stackNum] -= 1;
		int value = buffer[index];
		buffer[index] = 0;
		return value;
	}
	
	//返回栈顶元素
	int peek(int stackNum){
		int index = stackNum * stackSize + stackPointer[stackNum];
		return buffer[index];
	}
	
	//判断是否为空
	boolean isEmpty(int stackNum){
		//若当前栈的栈顶位置为初始位置，则表示当前栈为空
		return stackPointer[stackNum] == stackNum * stackSize;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
