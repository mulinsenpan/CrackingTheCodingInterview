package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  Given a binary tree, design an algorithm whichcreates a linked list of all the nodes at
each depth (e.g., if you have a tree with depth D,you'll have D linked lists
 * @author Chi
 * 
 * 核心问题：二叉树的每一层构建一个链表。
 * 问题背景：二叉树：每一个节点最多有两个子节点，中序遍历、先序、后序，层次遍历。
 * 		二叉树的层：层次遍历，
 * 策略分析:根据上一层的顺序获取下一层的节点。（BSF）
 * 
 * 技巧：二叉树的层次遍历方法
 * 		根据上一层获取下一层的节点：不需要使用辅助的存储
 *
 */
public class CreateLevelLinkedList {

	public static  void clll(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
		if (root == null) {
			return;  //边界条件
		}
		
		LinkedList<TreeNode> list = null;
		if (lists.size() == level) {
			//当前层不在list中
			list = new LinkedList<>();
			lists.add(list);
		}else{
			list = lists.get(level);
		}
		
		list.add(root);
		clll(root.left, lists, level+1);
		clll(root.right, lists, level+1);
	}
	
	public static void clll(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
		clll(root, lists, 0);
		for (LinkedList<TreeNode> linkedList : lists) {
			for (TreeNode treeNode : linkedList) {
				System.out.print(treeNode.data);
			}
			System.out.println();
		}
	}
	
	//根据树的特点构建的广度优先遍历方法：类似层次遍历。
	public static ArrayList<LinkedList<TreeNode>> BSF(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
		LinkedList<TreeNode> current = new LinkedList<>();
		if (root != null) {
			current.add(root);
		}
		while(current.size()>0){
			lists.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<>();
			for(TreeNode parent: parents){
				if (parent.left != null) {
					current.add(parent.left);
				}
				if (parent.right != null) {
					{
						current.add(parent.right);
					}
				}
			}
		}
		
		return lists;
	}
	
	public static void preOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
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
		
		clll(o);
		
		
		ArrayList<LinkedList<TreeNode>> lists = BSF(o);
		for (LinkedList<TreeNode> linkedList : lists) {
			for (TreeNode treeNode : linkedList) {
				System.out.print(treeNode.data);
			}
			System.out.println();
		}

	}

}
