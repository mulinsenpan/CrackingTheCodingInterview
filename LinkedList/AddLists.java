package LinkedList;

/**
 * You have two numbers represented by a linked list, where each node contains a single digit The digits are stored in reverse order, such that the 1��s digit is at the head of
the list Write a function that adds the two numbers and returns the sum as a linked
list
 * @author Chi
 * 
 * �������⣺������мӷ�����
 * ���ⱳ����1��ģ���ճ��ļӷ����㣨������У��������Ҫ��¼����λ���֣�
 * 			2����������ĳ����Ƿ�һ�£�
 *
 */
public class AddLists {
	
	public static LinkedListNode addlists(LinkedListNode l1, LinkedListNode l2, int carry) {
		if(l1 == null && l2 == null){
//			�ݹ�߽�����
			return null;
		}
		LinkedListNode result = new LinkedListNode(carry);
		int value = carry;
		if(l1 != null){
			value += l1.data;
		}
		if(l2 != null){
			value += l2.data;
		}
		result.data = value % 10;
		LinkedListNode more = addlists(
				l1 == null ?null : l1.next , 
				l2 == null ? null:l2.next,
				value > 10 ? 1:0);
		result.next = more;
		return result;				
				
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode two = new LinkedListNode(9);
		LinkedListNode three = new LinkedListNode(8);
		LinkedListNode four = new LinkedListNode(2);
		
		LinkedListNode five = new LinkedListNode(4);
		LinkedListNode six = new LinkedListNode(3);
		LinkedListNode seven = new LinkedListNode(1);
		
//		 134 + 289  = 423 
		two.next = three;
		three.next = four;
		
		five.next = six;
		six.next = seven;
		
		LinkedListNode result = addlists(two, five, 0);
		while (result != null) {
			System.out.println(result.data);
			result = result.next;
		}
	}

}
