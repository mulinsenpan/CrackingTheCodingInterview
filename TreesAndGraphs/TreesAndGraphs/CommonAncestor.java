package TreesAndGraphs;


/**
 * Design an algorithm and write code to find the first common ancestor of two nodes
in a binary tree. Avoidstoring additional nodes in a data structure.NOTE: This is not
necessarily a binary search tree
 * @author Chi
 * 
 * �������⣺�ҵ������ڵ�ģ���һ�����������ڵ㣬�����������ڵ����С�����������ڵ�֮������·����
 * ���ⱳ������һ���Ƕ���������
 * 		������ʹ���������ݽṹ
 * 
 * �����������ΪBST����ֻ���ҵ������������ڵ����С�ڵ���ֵ��
 * 		����ǰ�ڵ���ָ�򸸽ڵ��ָ�룺�ҵ��������ڵ����еĸ��ڵ㣬�洢�������У���һ����ͬ�Ľڵ��Ϊ��һ����������
 * 		��û�и��ڵ�ָ�룬���Ҳ���BST������һ��������
 * ����1����򵥵�������������ڵ㲻��root��ͬһ�࣬��rootΪfirst common ancestor���������˼·��
 * 			��������ڵ��ڸ��ڵ��������������root.left
 * 			��������ڵ��ڸ��ڵ��������������root.right
 * 			��������ڵ㲻��ͬһ�ࣺroot:������Ϊ�����ı߽�����֮һ��
 * 
 * ���ɣ������������
 * ���Է������������й���2n���ڵ㣬ʱ�临�Ӷ�Ϊ2n+n+n/2+...,O(4n),���¼����Ӷ�ΪO(n)
 * 		�÷����ж�α��������������������Լ������������ȣ��Ƿ���Լ��������ı���������
 * 
 * ����2��������������q���򷵻�q��
 * 		������������p���򷵻�p��
 * 		�����������ú����򷵻�null��
 * 		�������������������Ѱ�ҹ������ڵ㡣
 */

public class CommonAncestor {
	
	/**
	 * �жϽڵ�q�Ƿ���ĳһ�����У�root�����������ĸ��ڵ�
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
		//�߽�����
		if (root == null) {
			return null;
		}
		if (root == q || root == p) {
			return root;
		}
		boolean is_p_on_left = cover(root.left, p);
		boolean is_q_on_left = cover(root.left, q);
		//��pq����ͬһ�࣬����pq����Ϊ���ڵ��ǣ�����root
		if (is_p_on_left != is_q_on_left) {
			return root;
		}
		
		//��ͬһ��,��໹���Ҳ࣬���ƽ����������������������������м���Ѱ��
		TreeNode child_side = is_p_on_left? root.left: root.right;
		return commonAncestor(child_side, q, p);
	}
	public static TreeNode commonAnce(TreeNode root, TreeNode q, TreeNode p) {
		//�������в��ú�q����p
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
