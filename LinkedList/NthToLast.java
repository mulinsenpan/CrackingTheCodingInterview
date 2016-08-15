package LinkedList;


/**
 * Implement an algorithm to find the nth to last element of a 
 * singly linked list
 * 
 * �������⣺�ڵ����������ҵ�������n�������һ��Ԫ�ء�
 * ���ⱳ���������������飺֮��һ��nextָ��
 * 		������n�������һ��Ԫ�أ��������е�Ԫ������nʱ��δ�����
 *
 *����ת�������������нڵ�ĸ�������n������ҵ�������n��Ԫ�أ�
 *˼·��˫ָ�뷽��������ָ���ľ���Ϊn����һ��ָ��ﵽ���ʱ����һ��ָ��ָ������n��Ԫ��
 *
 *���ɣ�˫ָ�뷽����ָ��֮�����̶���
 *
 *
 *�ݹ鷽����
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
