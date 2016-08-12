package com;


/**
 * Write an algorithm such that if an element in an MxN matrix is 0, 
 * its entire row and column is set to 0
 * @author Chi
 * 
 * 问题分析：要求把所有包含0的行和列的元素全部置为0
 * 问题背景：一个M*N的矩阵， 元素0。矩阵是否可以为空？是否允许使用辅助数组存储下标？
 * 核心：找到包含0的行和列的下标。
 * 步骤：1、找到包含0的行和列的下标
 * 		2、根据下标把这些行和列的元素置为0；
 * 
 * 问题：如何找到这些下标？如何存储这些下标？
 * 			
 *技巧：先记录在修改
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
