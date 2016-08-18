package TreesAndGraphs;


/**
 * Design an algorithm and write code to find the first common ancestor of two nodes
in a binary tree. Avoidstoring additional nodes in a data structure.NOTE: This is not
necessarily a binary search tree
 * @author Chi
 * 
 * 核心问题：找到两个节点的（第一个）公共父节点，包含这两个节点的最小子树，两个节点之间的最短路径。
 * 问题背景：不一定是二叉搜索树
 * 		不允许使用其他数据结构
 * 
 * 问题分析：若为BST，则只需找到大于这两个节点的最小节点数值。
 * 		若当前节点有指向父节点的指针：找到这两个节点所有的父节点，存储在链表中，第一个相同的节点记为第一个公共祖先
 * 		若没有父节点指针，并且不是BST，即最一般的情况。
 * 策略1：最简单的情况：当两个节点不在root的同一侧，则root为first common ancestor。按照这个思路，
 * 			如果两个节点在根节点的左子树：遍历root.left
 * 			如果两个节点在跟节点的右子树：遍历root.right
 * 			如果两个节点不在同一侧：root:可以作为迭代的边界条件之一。
 * 
 * 技巧：多种情况考虑
 * 策略分析：假设树中共有2n个节点，时间复杂度为2n+n+n/2+...,O(4n),即事件复杂度为O(n)
 * 		该方案中多次遍历左子树和右子树，以及子树的子树等，是否可以减少子树的遍历次数？
 * 
 * 策略2：若子树仅包含q，则返回q，
 * 		若字数仅包含p，则返回p，
 * 		若两个都不好喊，则返回null，
 * 		若两个都包含，则继续寻找公共父节点。
 */

public class CommonAncestor {
	
	/**
	 * 判断节点q是否在某一子树中，root不是整棵树的根节点
	 * @param root
	 * @param q
	 * @return
	 */
	private static boolean cover(TreeNode root, TreeNode q) {
		if (root== null) {
			return false;
		}
		if (root == q) {
			return true;
		}
		return cover(root.left, q) || cover(root.right, q);
		
	}
	
	private static TreeNode commonAncestor(TreeNode root, TreeNode q, TreeNode p) {
		//边界条件
		if (root == null) {
			return null;
		}
		if (root == q || root == p) {
			return root;
		}
		boolean is_p_on_left = cover(root.left, p);
		boolean is_q_on_left = cover(root.left, q);
		//当pq不在同一侧，并且pq都不为根节点是，返回root
		if (is_p_on_left != is_q_on_left) {
			return root;
		}
		
		//在同一侧,左侧还是右侧，递推渐进条件，在左子树或者右子树中继续寻找
		TreeNode child_side = is_p_on_left? root.left: root.right;
		return commonAncestor(child_side, q, p);
	}
	public static TreeNode commonAnce(TreeNode root, TreeNode q, TreeNode p) {
		//整棵树中不好喊q或者p
		if (!cover(root, q)||!cover(root, p)) {
			return null;
		}
		return commonAncestor(root, q, p);
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
		
		System.out.println(commonAncestor(o, eight, five).data);

	}

}
