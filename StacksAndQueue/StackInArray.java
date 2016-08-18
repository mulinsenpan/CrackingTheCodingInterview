package StacksAndQueue;

/**
 * escribe how you could use a single array to implement three stacks
 * @author Chi
 * ���⣺���ʹ��һ��arrayʵ������ջ��
 * ���ⱳ����array���̶�����
 * 		ջ���Ƚ��������Ҫ��¼ջ����ջ��λ�ã�ÿ��ջ�ĳ��ȹ̶���ͬ����Ҫʵ�ֽ�ջ����ջ��peek��isEmpty�Ȳ���
 * 
 * �������������ÿ��ջ�ĳ��Ⱦ�Ϊarray���ȵ�����֮һ�����ջ���в���ʱ����Ҫ��ȷ���ĸ�ջ���в���������Ҫ֪��ջ���±�
 *
 */

public class StackInArray {
	int stackSize = 300;
	int[] buffer = new int[stackSize * 3];
	int[] stackPointer = {0, 0, 0};    // ��¼ջ��λ��
	
	void push(int stackNum, int value){
		//step1:����stackNum �ҵ�ջ��λ�ã�����Ҫ��ջ��value�������е��±�
		int index = stackNum * stackSize + stackPointer[stackNum] + 1;
		
		stackPointer[stackNum] += 1; // ���ĵ�ǰջ��ջ��λ��
		
		buffer[index] = value; // ��¼ջ������
	}
	
	//��ջ����:���ĸ�ջ���в���
	int pop(int stackNum){
		//step 1:�ҵ���Ӧ��Ԫ���������е��±�
		int index = stackNum * stackSize + stackPointer[stackNum];
		//step 2:ջ��λ��-1��
		stackPointer[stackNum] -= 1;
		int value = buffer[index];
		buffer[index] = 0;
		return value;
	}
	
	//����ջ��Ԫ��
	int peek(int stackNum){
		int index = stackNum * stackSize + stackPointer[stackNum];
		return buffer[index];
	}
	
	//�ж��Ƿ�Ϊ��
	boolean isEmpty(int stackNum){
		//����ǰջ��ջ��λ��Ϊ��ʼλ�ã����ʾ��ǰջΪ��
		return stackPointer[stackNum] == stackNum * stackSize;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
