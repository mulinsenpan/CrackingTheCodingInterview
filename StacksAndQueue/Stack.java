package StacksAndQueue;

public class Stack {
	
	class Node{
		Object data = 0;
		Node next = null;
		public Node(Object obj) {
			// TODO Auto-generated constructor stub
			data = obj;
		}
	}
	
	Node top;
	Node pop(){
		if (top != null) {
			Object item = top.data;
			top = top.next;
			return (Node) item;
		}
		return null;
	}
	
	void push(Object item){
		Node t = new Node(item);
		t.next = top;
		top = t;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
