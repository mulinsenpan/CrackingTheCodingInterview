package TreesAndGraphs;


/**
 * Write an algorithm to find the 'next'node (i.e., in-order successor) of a given nodein
a binary search tree. Youmay assume that each nodehas a link to its parent
 * @author Chi
 *
 *�������⣺��������е�ǰ�ڵ����һ���ڵ�
 *���ⱳ�������������������-->��ǰ�ڵ�-->������
 *		��֪��ǰ�ڵ㣬������һ���ڵ�λ��������������ߵĽڵ㣬
 *�����������ǰ�ڵ������������ҵ�������������ڵ�
 *		��ǰ�ڵ�û����������˵���������Ѿ�������,����Ҫ�ҵ�һ���ڵ�ʹ��ǰ�ڵ�λ�ڸýڵ����������
 *		��ǰ�ڵ�Ϊ�գ���ʾ�Ѿ������ҽڵ㣬��̽ڵ�Ϊ�ա�
 */
public class InorderSucc {
	
	public static TreeNode leftMostChild(TreeNode n) {
		if (n == null) {
			return null;
		}
		while(n.left != null){
			n = n.left;
		}
		return n;
	}
	
	public static TreeNode inOrderSucc(TreeNode current) {
		if (current == null) {
			return null;
		}
		if (current.right != null) {
			return leftMostChild(current.right);
		}else{
			TreeNode qNode = current;
			TreeNode xNode = qNode.parent;
			while(xNode != null && xNode.left != qNode){
				qNode= xNode;
				xNode = xNode.parent;
			}
			return xNode;
		}
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
		t.parent = o;
		o.right = th;
		th.parent = o;
		t.right = five;
		five.parent = t;
		four.parent = t;
		t.left = four;
		
		th.left = six;
		six.parent = th;
		th.right = seven;
		seven.parent = th;
		
		four.left = eight;
		eight.parent = five;
		four.right = nine;
		nine.parent = four;
		
		System.out.println(inOrderSucc(five).data);

	}

}
