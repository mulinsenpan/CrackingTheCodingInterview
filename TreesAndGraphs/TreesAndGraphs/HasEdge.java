package TreesAndGraphs;

import java.util.LinkedList;

import TreesAndGraphs.GraphNode.State;

/**
 * Given a directed graph, design an algorithm to find out whether there is a route
between two nodes
 * @author Chi
 *
 *核心问题：判断有向图中两个节点之间是否存在一条路径
 *问题背景：有向图：只能单向流动
 *		路径：从A点经过若干个点能够到达B点，AB之间存在一条路径。
 *问题转化：如何找到亮点之间的路径？
 *问题分析：A点有若干个邻接点，每一个邻接点又有若干个邻接点，若B点在A的直接或者简介邻接点（包含邻接点的邻接点）集合中
 *则，AB之间存在一条路径。
 *因此：最终成为图的遍历问题，只不过只有一个初始点A，判断B是否出现在遍历的节点当中，若出现，则表明存在一条路径，若不出现
 *则没有。
 *
 *若图为无向图，需要两次遍历：先以A为初始点，判断B；在以B为初始点，判断A。
 *
 *
 *注意点：每访问过一个节点，就要把该节点的状态置为已访问，从而避免陷入死循环。
 */
public class HasEdge {
	
	/**
	 * 广度优先遍历：迭代方法，类似树的层次遍历
	 * 
	 * 技巧：使用一个队列存储邻接点
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
		 * A:B,C；
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
