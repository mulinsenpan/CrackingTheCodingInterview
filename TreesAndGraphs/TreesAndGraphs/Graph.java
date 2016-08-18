package TreesAndGraphs;
public class Graph {
	private GraphNode vertices[];
	public int count;
	public Graph(int num){
		vertices = new GraphNode[num];
		count = 0;
	}
	
	public void addNode(GraphNode x){
		if (count < 30) {
			vertices[count] = x;
			count ++ ;
		}else{
			System.out.println("graph full");
		}
	}
	
	public GraphNode[] getNodes() {
		return vertices;
	}

}
