package TreesAndGraphs;

import javax.crypto.EncryptedPrivateKeyInfo;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import TreesAndGraphs.TreeNode;

/**
 * Implement a function to check if a tree is balanced For the purposes of this question,
a balanced tree is defined to be a tree such that no two leaf nodes differ in distance
from the root by more than one
 * @author Chi
 * 
 * 核心问题：检查一个树是否是平衡树
 * 问题背景：平衡树：它是一 棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 * 			树的深度：根节点到叶子节点的距离（层数）
 * 问题分析：任意两个叶子节点到根节点的距离差不超过1，则最深的和最浅子树高度差不超过1.
 * 问题转化：如何找打一个数的深度
 * 问题分析：若树为空，则深度为0
 * 			若树不为空，则深度=1+max(左子树,右子树）
 * 			因此，计算树的深度是一个递归过程
 * 如何设计递归：递归边界条件：root==null
 * 			  递推公式：1+max(root.left,root.right)
 * 
 *
 */

public class IsBalanced {
	private static int maxDepth(TreeNode root){
		if (root == null) {
			return 0;
		}
		return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
	}
	
	private  static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1+Math.min(minDepth(root.left), minDepth(root.right));
	}
	
	private static boolean isBalanced(TreeNode root) {
		return (maxDepth(root) - minDepth(root)) <= 1;
 	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode o = new TreeNode(5);
		TreeNode t = new TreeNode(5);
		TreeNode th = new TreeNode(5);
		TreeNode four = new TreeNode(5);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(5);
		TreeNode seven = new TreeNode(5);
		TreeNode eight = new TreeNode(5);
		TreeNode nine = new TreeNode(5);
		
		o.left = t;
		o.right = th;
		t.right = five;
		t.left = four;
		
		th.left = six;
		th.right = seven;
		
		four.left = eight;
		four.right = nine;
		
		boolean  Result = isBalanced(o);
		System.out.println(Result);
		
		
	}

}
