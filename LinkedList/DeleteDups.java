package LinkedList;

import java.awt.TexturePaint;
import java.util.Hashtable;

import LinkedList.LinkedListNode;


public class DeleteDups {
	
	/**
	 * Write code to remove duplicates from an unsorted linked list
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
	 */
	
	/***
	 * 问题明确：删除链表中重复的节点
	 * 问题背景：	单向链表：通过指针获取下一个节点。
	 * 			链表长度不固定：无法使用一个固定大小的数组记录那些节点是否重复
	 * 			允许使用辅助数据结构如何操作？
	 * 			不允许使用数据结构时如何操作？
	 * 问题转化：如何记录链表中已经访问过的节点的值，以便于后续访问能够发现是否重复？
	 * 问题分析： 使用HashTable等键值对结构的，能够快速查找某一节点值是否包含已经包含在链表中。
	 * 问题转化：如何删除链表节点。
	 * 问题分析：删除的是当前节点，因此需要改变当前节点的上一个节点的指针指向。
	 * 	
	 * step1：建立一个ehashtable， 建立两个指针：一个指向当前节点，一个指向当前节点的上一个节点。
	 * step2：遍历链表，判断当前节点的值是否包含在table中，如不含，则把该节点值放入tbale中
	 * 		  坨包含，则把当前节点上一个节点的指针指向当前节点的下一个节点。
	 * @param head
	 */
	public static void deleteDups(LinkedListNode head) {
		LinkedListNode previous = null;
		Hashtable table = new Hashtable();
		while(head != null){
			if (table.containsKey(head.data)) {
				previous.next = head.next;
				
			}else{
				table.put(head.data, true);
				previous = head;
				
			}
			head = head.next;
		}
	}
	
//	当不使用table时，如何判断是否有重复的节点？
	/**
	 * 双指针策略：一个代表当前指针、一个表示从head到当前指针
	 * @param args
	 */

	public static void deleteDups2(LinkedListNode head) {
		if (head == null) {
		}
		LinkedListNode prevoius = head;
		LinkedListNode current = prevoius.next;
		while(current!=null){
			LinkedListNode runer = head;
			while(runer != current){
				if (runer.data == current.data) {
//					runner和current节点值相同。
					LinkedListNode temp = current.next;
					prevoius.next = temp;
					current = temp;
					break;
				}
				runer = runer.next;
			}
			if (runer == current) {
				prevoius = current;
				current = current.next;
			}
			
		}
		
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
		
		deleteDups2(two);
		LinkedListNode head = two;
		while(head != null){
			System.out.println(head.data);
			head = head.next;
		}
	}

}
