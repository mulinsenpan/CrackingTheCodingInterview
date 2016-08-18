package TreesAndGraphs;

import java.util.LinkedList;

/**
 * Implement a function to check if a binary tree isa binary search tree
 * @author Chi
 * 
 * �������⣺�ж϶������Ƿ���BST��
 * ���ⱳ����������������
 * 		BST����<��<��
 * 		�����Ƿ����ظ�Ԫ�أ�
 * ���Է�����1��BST���������������ģ���˿���ʹ����������õ�һ�����飬�жϸ������Ƿ�������ġ�
 * 			�����������ظ�ֵʱ���޷���ȷ�ж��Ƿ���BST��
 * 		2������BSTleft<root<right�����ԡ��������нڵ㣬�ж����ӽڵ��Ƿ����㡣���Ե����������������޸ģ�
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
	 * ��һ�ַ���������
	 * ��������õ������������ж��Ƿ���BST�������ж�ʱ��������һ�����ֺ���һ�����ֽ��бȽϣ��Ƿ���Ա�����һ�����֣��Ӷ����ñ����������飬
	 * �ڻ�ȡ��һ������֮���ж��Ƿ���BST��
	 * 
	 * ��Ƶݹ飺�߽�������root=null, node.data <= last_printed 
	 * ǰ������: last_printed = node.data  checkBST(node.left), checkBST(node.right)
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
	
	
	/**����������������� the condition is that alI left nodes must be less than or equal to the
current node, which must be less than all the right nodes.
	 * 
	 * 
	 */
	
	public static boolean checkBST2(TreeNode node) {
		return checkBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean checkBST(TreeNode node, int min,
			int max) {
		
		//�߽�����
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
