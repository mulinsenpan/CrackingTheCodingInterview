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
	 * ������ȷ��ɾ���������ظ��Ľڵ�
	 * ���ⱳ����	��������ͨ��ָ���ȡ��һ���ڵ㡣
	 * 			�����Ȳ��̶����޷�ʹ��һ���̶���С�������¼��Щ�ڵ��Ƿ��ظ�
	 * 			����ʹ�ø������ݽṹ��β�����
	 * 			������ʹ�����ݽṹʱ��β�����
	 * ����ת������μ�¼�������Ѿ����ʹ��Ľڵ��ֵ���Ա��ں��������ܹ������Ƿ��ظ���
	 * ��������� ʹ��HashTable�ȼ�ֵ�Խṹ�ģ��ܹ����ٲ���ĳһ�ڵ�ֵ�Ƿ�����Ѿ������������С�
	 * ����ת�������ɾ������ڵ㡣
	 * ���������ɾ�����ǵ�ǰ�ڵ㣬�����Ҫ�ı䵱ǰ�ڵ����һ���ڵ��ָ��ָ��
	 * 	
	 * step1������һ��ehashtable�� ��������ָ�룺һ��ָ��ǰ�ڵ㣬һ��ָ��ǰ�ڵ����һ���ڵ㡣
	 * step2�����������жϵ�ǰ�ڵ��ֵ�Ƿ������table�У��粻������Ѹýڵ�ֵ����tbale��
	 * 		  ���������ѵ�ǰ�ڵ���һ���ڵ��ָ��ָ��ǰ�ڵ����һ���ڵ㡣
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
	
//	����ʹ��tableʱ������ж��Ƿ����ظ��Ľڵ㣿
	/**
	 * ˫ָ����ԣ�һ������ǰָ�롢һ����ʾ��head����ǰָ��
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
//					runner��current�ڵ�ֵ��ͬ��
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
