package com;


/**
 * Write an algorithm such that if an element in an MxN matrix is 0, 
 * its entire row and column is set to 0
 * @author Chi
 * 
 * ���������Ҫ������а���0���к��е�Ԫ��ȫ����Ϊ0
 * ���ⱳ����һ��M*N�ľ��� Ԫ��0�������Ƿ����Ϊ�գ��Ƿ�����ʹ�ø�������洢�±ꣿ
 * ���ģ��ҵ�����0���к��е��±ꡣ
 * ���裺1���ҵ�����0���к��е��±�
 * 		2�������±����Щ�к��е�Ԫ����Ϊ0��
 * 
 * ���⣺����ҵ���Щ�±ꣿ��δ洢��Щ�±ꣿ
 * 			
 *���ɣ��ȼ�¼���޸�
 */
public class SetZeros {
	
	private static void setZeros(int[][] matrix) {
		int[] rows = new int[matrix.length];
		int[] cols = new int[matrix[0].length];
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if (matrix[i][j] == 0) {
					rows[i] = 1;
					cols[j] = 1;
					continue;
				}
			}
		}
		
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if (rows[i] == 1 || cols[j] ==1) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] mat= {{1,2,0,4},
					{5,6,7,8},
					{9,0,11,12},
					{13,14,15,0}};
		setZeros(mat);
		
		for (int[] is : mat) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}

}
