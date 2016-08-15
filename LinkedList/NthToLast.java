package LinkedList;


/**
 * Implement an algorithm to find the nth to last element of a 
 * singly linked list
 * 
 * 核心问题：在单向链表中找到倒数第n个到最后一个元素。
 * 问题背景：单向链表数组：之后一个next指向
 * 		倒数第n个到最后一个元素（当链表中的元素少于n时如何处理？）
 *
 *问题转化：假设链表中节点的个数大于n，如何找到倒数第n个元素？
 *思路：双指针方法：两个指针间的距离为n，当一个指针达到最后时，另一个指针指向倒数第n个元素
 *
 *技巧：双指针方法，指针之间距离固定。
 *
 *
 *递归方法：
 *
 *
 */
public class NthToLast {
	
	public static LinkedListNode nthToLast(LinkedListNode head, int nth) {
		LinkedListNode prevous = head;
		LinkedListNode current = head;
		for(int i = 0; i < nth-1; i++){
			if (current == null) {
				return null;
			}
			current = current.next;
		}
		
			while(current.next != null){
				prevous = prevous.next;
				current = current.next;
			}
			return prevous;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode two = new LinkedListNode(2);
		LinkedListNode three = new LinkedListNode(1);
		LinkedListNode four = new LinkedListNode(3);
		LinkedListNode five = new LinkedListNode(1);
		LinkedListNode six = new LinkedListNode(3);
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		
		LinkedListNode head = nthToLast(two, 2);
		while(head != null){
			System.out.println(head.data);
			head = head.next;
		}
		
	}

}
