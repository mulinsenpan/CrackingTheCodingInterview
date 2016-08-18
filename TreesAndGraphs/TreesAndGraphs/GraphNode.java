package TreesAndGraphs;

public class GraphNode {
	private GraphNode adjacent[]; // ��¼�ڽӵ�
	public int adjacentCount; // �ڽӵ����
	private String vertex;    // ����
	public State state;
	
	public enum State{
		Unvisited,
		Vsited,
		Visiting;
	}
	
	public GraphNode(String vertex, int adjacentLength){
		this.vertex = vertex;
		adjacentCount = 0;
		adjacent = new GraphNode[adjacentLength];   // �ö�����ڽӱ�
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
