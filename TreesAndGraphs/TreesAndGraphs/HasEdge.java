package TreesAndGraphs;

import java.util.LinkedList;

import TreesAndGraphs.GraphNode.State;

/**
 * Given a directed graph, design an algorithm to find out whether there is a route
between two nodes
 * @author Chi
 *
 *�������⣺�ж�����ͼ�������ڵ�֮���Ƿ����һ��·��
 *���ⱳ��������ͼ��ֻ�ܵ�������
 *		·������A�㾭�����ɸ����ܹ�����B�㣬AB֮�����һ��·����
 *����ת��������ҵ�����֮���·����
 *���������A�������ɸ��ڽӵ㣬ÿһ���ڽӵ��������ɸ��ڽӵ㣬��B����A��ֱ�ӻ��߼���ڽӵ㣨�����ڽӵ���ڽӵ㣩������
 *��AB֮�����һ��·����
 *��ˣ����ճ�Ϊͼ�ı������⣬ֻ����ֻ��һ����ʼ��A���ж�B�Ƿ�����ڱ����Ľڵ㵱�У������֣����������һ��·������������
 *��û�С�
 *
 *��ͼΪ����ͼ����Ҫ���α���������AΪ��ʼ�㣬�ж�B������BΪ��ʼ�㣬�ж�A��
 *
 *
 *ע��㣺ÿ���ʹ�һ���ڵ㣬��Ҫ�Ѹýڵ��״̬��Ϊ�ѷ��ʣ��Ӷ�����������ѭ����
 */
public class HasEdge {
	
	/**
	 * ������ȱ����������������������Ĳ�α���
	 * 
	 * ���ɣ�ʹ��һ�����д洢�ڽӵ�
	 */
	
	
	private static boolean search(Graph g, GraphNode start, GraphNode end) {
		LinkedList<GraphNode> q = new LinkedList<>();
		for(GraphNode node: g.getNodes()){
			node.state = State.Unvisited;
		}
		start.state = State.Visiting;
		q.add(start);
		GraphNode n;
		while(!q.isEmpty()){
			n = q.removeFirst();
			if (n != null) {
				for(GraphNode v: n.getAdjacent()){
				
					if (v.state == State.Unvisited) {
						if (v == end) {
							return true;
						}else {
							v.state = State.Visiting;
							q.add(v);
						}
					}
				}
			n.state = State.Vsited;
			}
			
		}
		return false;
		
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * A:B,C��
		 * B:C,D;
		 * D:C
		 * 
		 */
		GraphNode a = new GraphNode("A",2);
		GraphNode b = new GraphNode("B",2);
		GraphNode c = new GraphNode("C",0);
		GraphNode d = new GraphNode("D",1);
		
		a.addAdjacent(b);
		a.addAdjacent(c);
		b.addAdjacent(c);
		b.addAdjacent(d);
		d.addAdjacent(c);
		c.addAdjacent(b);
		
		Graph g = new Graph(4);
		g.addNode(a);
		g.addNode(b);
		g.addNode(c);
		g.addNode(d);
		
		System.out.println(search(g, a, d));

	}

}
