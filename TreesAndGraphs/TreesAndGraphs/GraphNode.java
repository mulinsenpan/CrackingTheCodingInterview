package TreesAndGraphs;

public class GraphNode {
	private GraphNode adjacent[]; // 记录邻接点
	public int adjacentCount; // 邻接点个数
	private String vertex;    // 顶点
	public State state;
	
	public enum State{
		Unvisited,
		Vsited,
		Visiting;
	}
	
	public GraphNode(String vertex, int adjacentLength){
		this.vertex = vertex;
		adjacentCount = 0;
		adjacent = new GraphNode[adjacentLength];   // 该顶点的邻接表
	}
	
	public void addAdjacent(GraphNode x) {
		if (adjacentCount < 30 && this.adjacent.length > 0) {
			this.adjacent[adjacentCount] = x;
			adjacentCount += 1;
		}else{
			System.out.println("no more adjacent can be added");
		}
	}
	public GraphNode[] getAdjacent() {
		return adjacent;
	}
	public String getVertex() {
		return vertex;
	}
	
	

}
