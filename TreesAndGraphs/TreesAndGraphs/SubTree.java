package TreesAndGraphs;

/**
 * You have two very large binary trees: Tl, with millions of nodes, and T2, with
hundreds of nodes. Create an algorithm to decideifT2 isa subtree ofTl.
 * @author Chi
 * 
 * �������⣺�ж�t2�Ƿ���t1������
 * ����򻯣�С�Ķ�����
 * ���ⱳ����������t1�ܴ󣺱����ķ�ʱ��
 * 		��������t1�д���һ���ڵ�n��ʹ��n��������t2��ͬ����t2��t1������
 * 		�ڶ������ı����У���֪�����ǰ�򣨻��ߺ��򣩿������¹�����������
 * ���ԣ����Եõ������������������ǰ��������У��Ƚ�t2�������Ƿ���t1ѧ�е������С�
 * 
 * ��ʵ���⣺���ܴ󣬵õ�������Ҫռ�ݺܴ�Ŀռ䣬����ʱ��Ҳ�Ӷࡣ
 * 
 * ����2��step1���ҵ�t2��root��t1�е�λ��
 * 		step2���ж�t2�е�ÿһ���ڵ��Ƿ�ƥ��
 * 
 * ���ɣ���Ҫ����null�����
 * 		�ݹ�
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
		//�߽�����
		if (t1 == null) {
			return false;
		}
		if (t1.data == t2.data) {
			if (matchTree(t1, t2)) {
				return true;
			}
		}
		
		//ǰ���׶�
		return subTree(t1.left, t2) || subTree(t1.right, t2);
	}
	
	private static boolean matchTree(TreeNode t1, TreeNode t2) {
		//�ݹ�߽�
		//������Ϊ��
		if (t1 == null && t2 == null) {
			return true;
		}
		//ֻ��һ��Ϊ��
		if (t1 == null || t2 == null) {
			return false;
		}
		if (t1.data != t2.data) {
			return false;
		}
		
		//ǰ���׶�
		return (matchTree(t1.left, t2.left)) && (matchTree(t1.right, t2.right));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
