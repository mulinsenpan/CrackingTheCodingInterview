package TreesAndGraphs;


/**
 * Write an algorithm to find the 'next'node (i.e., in-order successor) of a given nodein
a binary search tree. Youmay assume that each nodehas a link to its parent
 * @author Chi
 *
 *核心问题：中序遍历中当前节点的下一个节点
 *问题背景：中序遍历：左子树-->当前节点-->右子树
 *		已知当前节点，则其下一个节点位于右子树的最左边的节点，
 *问题分析：当前节点有右子树：找到右子树的最左节点
 *		当前节点没有右子树：说明该子树已经遍历完,则需要找到一个节点使当前节点位于该节点的左子树。
 *		当前节点为空，表示已经是最右节点，后继节点为空。
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
