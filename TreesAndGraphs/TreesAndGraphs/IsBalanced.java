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
 * �������⣺���һ�����Ƿ���ƽ����
 * ���ⱳ����ƽ����������һ �ÿ����������������������ĸ߶Ȳ�ľ���ֵ������1����������������������һ��ƽ���������
 * 			������ȣ����ڵ㵽Ҷ�ӽڵ�ľ��루������
 * �����������������Ҷ�ӽڵ㵽���ڵ�ľ�������1��������ĺ���ǳ�����߶Ȳ����1.
 * ����ת��������Ҵ�һ���������
 * �������������Ϊ�գ������Ϊ0
 * 			������Ϊ�գ������=1+max(������,��������
 * 			��ˣ��������������һ���ݹ����
 * �����Ƶݹ飺�ݹ�߽�������root==null
 * 			  ���ƹ�ʽ��1+max(root.left,root.right)
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
