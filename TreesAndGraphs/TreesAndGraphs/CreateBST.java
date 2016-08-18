package TreesAndGraphs;

import javax.xml.soap.Node;

/**
 * Given a sorted (increasing order) array with unique integer elements, 
 * write an algorithm to create a binary search tree with minimal height.
 * @author Chi
 *	
 *核心问题：生成BST
 *问题背景：BST：左<根<右
 *		有序（升序）数组：符合BST的特性
 *		最小高度的树：左子树和右子树的节点数量尽可能的相等
 *
 *策略分析：根据题目要求，把数组分为三部分，左中右三部分，左<中<右。中间一个元素作root，其他部分作为左子树和右子树
 *左部分采用同样的策略构造其左子树右子树和根节点。因此可以考虑采用递归。
 *
 *递归边界：数组的长度等于1，
 *递推阶段：root.left = fun(array_left),root.right = fun(array_right);
 */

public class CreateBST {
	
	public static TreeNode createBST(int[] array) {
		TreeNode root;
		int start = 0;
		int end = array.length - 1;
		int middle = array.length / 2;
		if (start == (end - 1)) {
			root = new TreeNode(array[end]);
			root.left = new TreeNode(array[start]);
			return root;
		}
		if (start == end) {
			root = new TreeNode(array[end]);
			return root;
		}
		
		root = new TreeNode(array[middle]);
		
		int[] left = new int[middle - start];
		int[] right = new int[end - middle];
		for(int i = 0; i < middle; i++){
			left[i] = array[i];
		}
		for(int j = middle + 1; j <= end; j++){
			right[j-middle-1] = array[j];
		}
		
		root.left = createBST(left);
		root.right = createBST(right);
		return root;
	}
	
	/**
	 * 代码优化
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public static TreeNode createMinBST(int[] array, int start, int end) {
		if (end < start) {
			return null;
		}
		int middle = (start + end) / 2;
		TreeNode root = new TreeNode(array[middle]);
		root.left = createMinBST(array, start, middle-1);
		root.right = createMinBST(array, middle+1, end);
		
		return root;		
	}
	
	public static void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode left = root.left;
		TreeNode right = root.right;
		inOrder(left);
		System.out.print(root.data + " ");
		inOrder(right);
	}
	
	public static int depth(TreeNode root) {
		//递归边界条件
		if (root == null) {
			return 0;
		}
		
		int left = 1;
		int right = 1;
		
		left += depth(root.left);
		right += depth(root.right);
		
		return left > right ? left:right;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {1,2,3,4,5,6};
		TreeNode root = createBST(array);
		inOrder(root);
		
		System.out.println();

		TreeNode node = createMinBST(array, 0, array.length-1);
		inOrder(node);
		
		System.out.println(depth(root));
		System.out.println(depth(node));
	}
}
