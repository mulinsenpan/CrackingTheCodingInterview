package LinkedList;

/**
 * Implement an algorithm to delete a node in the middle of a single linked list, given
only
 * @author Chi
 * 
 * �������⣺ɾ��һ���ڵ�
 * ���ⱳ������������Ľڵ����׽ڵ��β�ڵ㣬���Ҫɾ���Ľڵ�ʱ��β�ڵ�ʱ����Ҫ��δ���
 * 		����һ��ɾ��һ���ڵ㣺�ýڵ��ֵΪ��һ�ڵ��ֵ��ָ��ָ����һ�ڵ����һ�ڵ㡣
 *���룺һ���ڵ㣨����޷�ͨ�������ķ���ɾ���ڵ㣩
 *����������ýڵ������
 */

public class DeleteNode {

	public static boolean deleteNode(LinkedListNode c) {
		if(c == null || c.next == null){
			return false;
		}
		LinkedListNode next = c.next;
		c.data = next.data;
		c.next = next.next;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
