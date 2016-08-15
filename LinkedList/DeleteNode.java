package LinkedList;

/**
 * Implement an algorithm to delete a node in the middle of a single linked list, given
only
 * @author Chi
 * 
 * 核心问题：删除一个节点
 * 问题背景：链表特殊的节点有首节点和尾节点，如果要删除的节点时首尾节点时，需要如何处理
 * 		方法一：删除一个节点：该节点的值为下一节点的值，指针指向下一节点的下一节点。
 *输入：一个节点（因此无法通过遍历的方法删除节点）
 *输出：不含该节点的链表
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
