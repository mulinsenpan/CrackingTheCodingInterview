package TreesAndGraphs;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import javax.swing.RootPaneContainer;
import javax.xml.soap.Node;

/**
 * You are given a binary tree in which each node contains a value. Design an
 * algorithm to print all paths which sum to a given value. The path does not
 * need to start or end at the root or a leaf
 * 
 * @author Chi
 *
 *
 * 核心问题：找到节点之和等于value的所有路径 问题背景：1、路径的起始和终止节点不一定是根节点和叶子节点 2、路径的和满足一定条件。
 * 1、问题简化：开始节点必须为root，并且和满足条件的 所有路径。
 *   step1：从根节点开始后，深度优先遍历，当和满足条件时，转向另一条路径。 问题：树如何进行深度优先遍历。
 *         问题：如何获取到叶子节点的所有路径。
 *技巧：逆向思维：以当前节点为终点，向前判断达到哪个节点能够满足条件。
 */
public class AllPath {

	/**
	 * 借助栈，实现深度优先遍历。
	 * 
	 * @param root
	 */
	private static void dfs(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode node;
		while (!stack.isEmpty()) {
			node = stack.pop();
			System.out.println(node.data + " ");
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}
	
	/**
	 * 输出树中所有路径中每条路径之和，以root为开始，以叶子节点结束的路径
	 * @param node
	 */
	
	public static void print(int[] path, int start, int end) {
		for(int i = start; i <= end; i++){
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}
	
	static void findSum(TreeNode node, int sum, int[] path, int level){
		if (node == null) {  //边界条件
			return;
		}
		path[level] = node.data;
		
		//找到以该点为终点的路径是否满足条件（忽略开始位置）
		int t = 0;
		for(int i = level; i>=0; i--){
			t += path[i];
			if (t== sum) {  // 边界条件
				print(path, i, level);
			}
		}
		
		findSum(node.left, sum, path, level+1);
		findSum(node.right, sum, path, level+1);
//		path[level] = Integer.MIN_VALUE;
	}
	public static void findSum(TreeNode node, int sum) {
		int depth = depth(node);
		int[] path = new int[depth];
		findSum(node, sum, path, 0);
	}
	
	// 简单问题解法：以根节点开始的满足条件的路径：从根节点开始的所有路径是否满足条件。（到哪个节点满足条件）
	public static ArrayList<ArrayList<Integer>> findPath(TreeNode node, int sum) {
		ArrayList<ArrayList<Integer>> pathLists = new ArrayList<>();
		Stack<Integer> path = new Stack<>();
		int currentSum = 0;
		if (node == null) {
			return pathLists;
		}
		finPathCore(node, path, pathLists, sum, currentSum);
		return pathLists;
		
	}
	private static void finPathCore(TreeNode node, Stack<Integer>path, 
			ArrayList<ArrayList<Integer>> pathlists, int sum, int currentsum) {
		currentsum += node.data;
		path.push(node.data);
//		boolean isLeft = (node.left == null && node.right == null);
		if ( sum == currentsum) {    //边界条件  满足sum= currentsum,则把该条路径添加到lists中。
			ArrayList<Integer> list = new ArrayList<>();
			for(int i: path){
				list.add(i);
			}
			pathlists.add(list);
			path.pop();
		}else{
			if (node.left != null) {
				finPathCore(node.left, path, pathlists, sum, currentsum);
			}
			if (node.right != null) {
				finPathCore(node.right, path, pathlists, sum, currentsum);
			}
			path.pop();
		}
	}

	private static int depth(TreeNode node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return 0;
			
		}else{
			return 1 + Math.max(depth(node.left), depth(node.right));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode o = new TreeNode(1);
		TreeNode t = new TreeNode(2);
		TreeNode th = new TreeNode(3);
		TreeNode four = new TreeNode(6);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(5);
		TreeNode seven = new TreeNode(7);
		TreeNode eight = new TreeNode(8);
		TreeNode nine = new TreeNode(9);

		/**
		 *   1 
		 * 2   3
		 *4 5 6 7 
		 8 9
		 */
		o.left = t;
		o.right = th;
		t.right = five;
		t.left = four;

		th.left = six;
		th.right = seven;

		four.left = eight;
		four.right = nine;
//		findSum(o,7 );
		ArrayList<ArrayList<Integer>> pathList = findPath(o, 9);
		for (ArrayList<Integer> arrayList : pathList) {
			for (Integer integer : arrayList) {
				System.out.print( integer + " ");
			}
			System.out.println();
		}
	}

}
