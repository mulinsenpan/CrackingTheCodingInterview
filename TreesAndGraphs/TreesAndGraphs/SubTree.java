package TreesAndGraphs;

/**
 * You have two very large binary trees: Tl, with millions of nodes, and T2, with
hundreds of nodes. Create an algorithm to decideifT2 isa subtree ofTl.
 * @author Chi
 * 
 * 核心问题：判断t2是否是t1的子树
 * 问题简化：小的二叉树
 * 问题背景：二叉树t1很大：遍历耗费时间
 * 		子树：若t1中存在一个节点n，使得n的子树和t2相同，则t2是t1的子树
 * 		在二叉树的遍历中，已知中序和前序（或者后序）可以重新构建二叉树，
 * 策略：可以得到两个二叉树的中序和前序遍历序列，比较t2的序列是否是t1学列的子序列。
 * 
 * 现实问题：树很大，得到序列需要占据很大的空间，花费时间也加多。
 * 
 * 策略2：step1：找到t2的root在t1中的位置
 * 		step2：判断t2中的每一个节点是否匹配
 * 
 * 技巧：不要忘记null的情况
 * 		递归
 * 
 *
 */
public class SubTree {
	
	public static boolean containsTree(TreeNode t1, TreeNode t2) {
		if (t2 == null) {
			return true;
		}
		return subTree(t1, t2);
	}
	
	private static boolean subTree(TreeNode t1, TreeNode t2) {
		//边界条件
		if (t1 == null) {
			return false;
		}
		if (t1.data == t2.data) {
			if (matchTree(t1, t2)) {
				return true;
			}
		}
		
		//前进阶段
		return subTree(t1.left, t2) || subTree(t1.right, t2);
	}
	
	private static boolean matchTree(TreeNode t1, TreeNode t2) {
		//递归边界
		//两个都为空
		if (t1 == null && t2 == null) {
			return true;
		}
		//只有一个为空
		if (t1 == null || t2 == null) {
			return false;
		}
		if (t1.data != t2.data) {
			return false;
		}
		
		//前进阶段
		return (matchTree(t1.left, t2.left)) && (matchTree(t1.right, t2.right));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
