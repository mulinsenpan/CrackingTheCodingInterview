package LinkedList;

public class LinkedListNode {
	
//	创建节点类
	
		LinkedListNode next = null;
		int data;
		
		public LinkedListNode(int d){
			data = d;
		}
		
		void appendToTail(int d){
			LinkedListNode end = new LinkedListNode(d);
			LinkedListNode current = this;
			while(current.next != null){
				current = current.next;
			}
			current.next = end;
		}
		
		LinkedListNode deletNode(int d){
			
			LinkedListNode current = this;
			if (current.data == d) {
				return current.next;
			}
			while(current.next != null){
				if (current.data == d) {
					current.next = current.next.next;
					break;
				}
			}
			return this;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
