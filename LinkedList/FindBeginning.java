package LinkedList;

import java.util.Hashtable;

import javax.swing.text.TabableView;

/**
 * Given a circular linked list, implement an algorithm which returns node at the beginning of the loop
DEFINITION
Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an
earlier node, so as to make a loop in the linked list
EXAMPLE
Input: A -> B -> C -> D -> E -> C [the same C as earlier]
Output: C
 * @author Chi
 * 
 * 
 * 
 * 核心问题：发现循环开始的地方
 * 定义：什么是循环开始的地方？第一个重复出现的节点。
 * 问题转化：记录访问过的节点，判断当前节点是否出现在访问记录里
 * 问题1：如何存储访问记录：hashtable
 *技巧1：记录访问记录
 *
 *
 *技巧2：使用两个不同移动速度的指针（双指针策略）
 *
 */

public class FindBeginning {
	
	public static LinkedListNode findBeginning(LinkedListNode head) {
		Hashtable<Integer, Boolean> table = new Hashtable<>();
		LinkedListNode begin = null;
		while(head != null){
			if (table.containsKey(head.data)) {
				begin = head;
			}
			table.put(head.data, true);
			head = head.next;
		}
		return begin;
	}
	
	
	public static LinkedListNode findBeginning2(LinkedListNode head) {
		LinkedListNode n1 = head;
		LinkedListNode n2 = head;
		
		while (n2.next != null) {
			System.out.println(n2.data);
			n1 = n1.next;
			n2 = n2.next.next;
			if (n1 == n2) {
				break;
			}
		}
		
		if (n2.next == null) {
			return null;
		}
		
		n1  = head;
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		
		
		
		return n2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedListNode two = new LinkedListNode(9);
		LinkedListNode three = new LinkedListNode(1);
		LinkedListNode four = new LinkedListNode(2);
		
		LinkedListNode five = new LinkedListNode(4);
		LinkedListNode six = new LinkedListNode(3);
		LinkedListNode seven = new LinkedListNode(1);
		
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		six.next = seven;
		
		LinkedListNode begin = findBeginning2(two);
		System.out.println(begin.data);

	}

}
