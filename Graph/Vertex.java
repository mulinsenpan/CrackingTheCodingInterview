package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

class Vertex<T> implements VertexInterface<T>, java.io.Serializable {

	private T label;//��ʶ���,�����ò�ͬ��������ʶ������String,Integer....
	private List<Edge> edgeList;//���ö����ڽӵ�ı�,ʵ����java.util.LinkedList�洢
	private boolean visited;//��ʶ�����Ƿ��ѷ���
	private VertexInterface<T> previousVertex;//�ö����ǰ������
	private double cost;//�����Ȩֵ,��ߵ�ȨֵҪ������
	
	public Vertex(T vertexLabel){
		label = vertexLabel;
		edgeList = new LinkedList<Edge>();//��Vertex������,˵��ÿ�����㶼��һ��edgeList�����洢������ö����ϵ�ı�
		visited = false;
		previousVertex = null;
		cost = 0;
	}
	
	/**
	 *Task: ��������һ��������������ʾ��,��Ҫ�ǿ��ǵ���Ȩֵ�ı�
	 *���Կ���,Edge���װ��һ�������һ��double���ͱ��� 
	 *������Ҫ����Ȩֵ,���Բ���Ҫ��������һ��Edge������ʾ��,ֻ��Ҫһ�����涥����б���
	 * @author hapjin
	 */
	protected class Edge implements java.io.Serializable {
		private VertexInterface<T> vertex;// �յ�
		private double weight;//Ȩֵ
		
		//Vertex �౾��ʹ��������,���������ֻ���ṩ endVertex���Ϳ��Ա�ʾһ������
		protected Edge(VertexInterface<T> endVertex, double edgeWeight){
			vertex = endVertex;
			weight = edgeWeight;
		}
		
		protected VertexInterface<T> getEndVertex(){
			return vertex;
		}
		protected double getWeight(){
			return weight;
		}
	}

	/**Task: �����ö����ڽӵ�ĵ�����--Ϊ getNeighborInterator()���� �ṩ������
	 * ���ڶ�����ڽӵ��Աߵ���ʽ�洢��java.util.List��,��˽���List�ĵ�������ʵ��
	 */
	private class NeighborIterator implements Iterator<VertexInterface<T>>{

		Iterator<Edge> edgesIterator;
		private NeighborIterator() {
			edgesIterator = edgeList.iterator();//��� LinkedList �ĵ�����
		}
		@Override
		public boolean hasNext() {
			return edgesIterator.hasNext();
		}

		@Override
		public VertexInterface<T> next() {
			VertexInterface<T> nextNeighbor = null;
			if(edgesIterator.hasNext()){
				Edge edgeToNextNeighbor = edgesIterator.next();//LinkedList�д洢����Edge
				nextNeighbor = edgeToNextNeighbor.getEndVertex();//��Edge������ȡ������
			}
			else
				throw new NoSuchElementException();
			return nextNeighbor;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	/**Task: ����һ�������ö��������ڽӱߵ�Ȩֵ�ĵ�����
	 * Ȩֵ��Edge�������,����Ȼ��һ������Edge����ĵ�����,ȡ��Edge����,�ٻ��Ȩֵ
	 * @author hapjin
	 *
	 * @param <Double> Ȩֵ������
	 */
	private class WeightIterator implements Iterator{//���ﲻ֪��Ϊʲô,�÷��ͱ��������???
		
		private Iterator<Edge> edgesIterator;
		private WeightIterator(){
			edgesIterator = edgeList.iterator();
		}
		@Override
		public boolean hasNext() {
			return edgesIterator.hasNext();
		}
		@Override
		public Object next() {
			Double result;
			if(edgesIterator.hasNext()){
				Edge edge = edgesIterator.next();
				result = edge.getWeight();
			}
			else throw new NoSuchElementException();
			return (Object)result;//�ӵ�������ȡ�ý��ʱ,��Ҫǿ��ת����Double
		}
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	
	@Override
	public T getLabel() {
		return label;
	}

	@Override
	public void visit() {
		this.visited = true;
	}

	@Override
	public void unVisit() {
		this.visited = false;
	}

	@Override
	public boolean isVisited() {
		return visited;
	}

	@Override
	public boolean connect(VertexInterface<T> endVertex, double edgeWeight) {
		// ��"��"(�ߵ�ʵ���Ƕ���)���붥����ڽӱ�
		boolean result = false;
		if(!this.equals(endVertex)){//���㻥����ͬ
			Iterator<VertexInterface<T>> neighbors = this.getNeighborInterator();
			boolean duplicateEdge = false;
			while(!duplicateEdge && neighbors.hasNext()){//��֤������ظ��ı�
				VertexInterface<T> nextNeighbor = neighbors.next();
				if(endVertex.equals(nextNeighbor)){
					duplicateEdge = true;
					break;
				}
			}//end while
			if(!duplicateEdge){
				edgeList.add(new Edge(endVertex, edgeWeight));//���һ���±�
				result = true;
			}//end if
		}//end if
		return result;
	}

	@Override
	public boolean connect(VertexInterface<T> endVertex) {
		return connect(endVertex, 0);
	}

	@Override
	public Iterator<VertexInterface<T>> getNeighborInterator() {
		return new NeighborIterator();
	}

	@Override
	public Iterator getWeightIterator() {
		return new WeightIterator();
	}

	@Override
	public boolean hasNeighbor() {
		return !(edgeList.isEmpty());//�ڽӵ�ʵ���Ǵ洢��List��
	}

	@Override
	public VertexInterface<T> getUnvisitedNeighbor() {//�����¸��Ӷ�ΪO(E)
		VertexInterface<T> result = null;
		Iterator<VertexInterface<T>> neighbors = getNeighborInterator();
		while(neighbors.hasNext() && result == null){//��øö���ĵ�һ��δ�����ʵ��ڽӵ�
			VertexInterface<T> nextNeighbor = neighbors.next();
			if(!nextNeighbor.isVisited())
				result = nextNeighbor;
		}
		return result;
	}

	@Override
	public void setPredecessor(VertexInterface<T> predecessor) {
		this.previousVertex = predecessor;
	}

	@Override
	public VertexInterface<T> getPredecessor() {
		return this.previousVertex;
	}

	@Override
	public boolean hasPredecessor() {
		return this.previousVertex != null;
	}

	@Override
	public void setCost(double newCost) {
		cost = newCost;
	}

	@Override
	public double getCost() {
		return cost;
	}
	
	//�ж����������Ƿ���ͬ
	public boolean equals(Object other){
		boolean result;
		if((other == null) || (getClass() != other.getClass()))
			result = false;
		else
		{
			Vertex<T> otherVertex = (Vertex<T>)other;
			result = label.equals(otherVertex.label);//�ڵ��Ƿ���ͬ���ջ����ɱ�ʶ �ڵ����͵����equals() ����
		}
		return result;
	}
}