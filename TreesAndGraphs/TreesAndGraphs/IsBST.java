package TreesAndGraphs;

import java.util.LinkedList;

/**
 * Implement a function to check if a binary tree isa binary search tree
 * @author Chi
 * 
 * 核心问题：判断二叉树是否是BST。
 * 问题背景：二叉树：无序
 * 		BST：左<根<右
 * 		树中是否有重复元素？
 * 策略分析：1、BST的中序遍历是有序的，因此可以使用中序遍历得到一个数组，判断该数组是否是有序的。
 * 			但当树中有重复值时，无法正确判断是否是BST。
 * 		2、根据BSTleft<root<right的特性。遍历所有节点，判断其子节点是否满足。（对迭代遍历方法做出修改）
 *
 */
public class IsBST {
	
	
	private static void inOrder(TreeNode root, LinkedList<Integer> array) {
		if (root == null) {
			return;
		}
		inOrder(root.left, array);
		array.add(root.data);
		inOrder(root.right, array);
	}

	public static boolean isBST(TreeNode root) {
		LinkedList<Integer> array = new LinkedList<>();
		inOrder(root, array);
		int length = array.size();
		for(int i = 0; i < length-1; i++){
			if (array.get(i)>array.get(i+1)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * 上一种方法分析：
	 * 中序遍历得到的数组用于判断是否是BST，但是判断时仅适用上一个数字和下一个数字进行比较，是否可以保存上一个数字，从而不用保存整个数组，
	 * 在获取下一个数字之后判断是否是BST。
	 * 
	 * 设计递归：边界条件：root=null, node.data <= last_printed 
	 * 前进条件: last_printed = node.data  checkBST(node.left), checkBST(node.right)
	 */
	public static int last_printed = Integer.MIN_VALUE;
	public static boolean checkBST(TreeNode node) {
		if (node == null) {
			return true;
		}
		if (!checkBST(node.left)) {
			return false;
		}
		if (node.data <= last_printed) {
			return false;
		}
		last_printed = node.data;
		if (!checkBST(node.right)) {
			return false;
		}
		return true;
	}
	
	
	/**二叉树满足的条件： the condition is that alI left nodes must be less than or equal to the
current node, which must be less than all the right nodes.
	 * 
	 * 
	 */
	
	public static boolean checkBST2(TreeNode node) {
		return checkBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean checkBST(TreeNode node, int min,
			int max) {
		
		//边界条件
		if (node == null) {
			return false;
		}
		if (node.data <= min || node.data > max) {
			return false;
		}
		
		if (!checkBST(node.left, min, node.data)
				|| !checkBST(node.right, node.data, max)) {
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode o = new TreeNode(1);
		TreeNode t = new TreeNode(2);
		TreeNode th = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		TreeNode eight = new TreeNode(8);
		TreeNode nine = new TreeNode(9);
		
		/**
		 *     1
		 *   2   3
		 *  4 5 6 7
		 * 8 9  
		 */
		o.left = t;
		o.right = th;
		t.right = five;
		t.left = four;
		
		th.left = six;
		th.right = seven;
		
		four.left = eight;
		four.right = nine;
		
		System.out.println(isBST(o));
		System.out.println(checkBST(o));
		System.out.println(checkBST2(o));
	}

}
