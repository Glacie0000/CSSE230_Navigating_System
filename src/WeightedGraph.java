import java.util.ArrayList;
import java.util.LinkedList;

public class WeightedGraph {

	private LinkedList<Edge> adj[];
	Vertex[] vertices;
	private int vNum;
	
	public WeightedGraph(int vNum){
		this.vNum = vNum;
		Vertex[] vertices = new Vertex[this.vNum];
		for(int i = 0; i < vNum; i++)
			this.adj[i] = new LinkedList<Edge>();
	}
	
	public void addEdge(int source, int destination, int weight) {
		this.adj[source].add(new Edge(source, destination, weight));
	}
	
	public void addVertex(int id, int x, int y) {
		vertices[id] = new Vertex(id,x,y);
	}
	
	private class Vertex {
		public int x, y;
		public int distance;
		public int id;
		public int f;
		
		public Vertex(int id, int x, int y) {
			this.x = x;
			this.y = y;
			this.id = id;
			this.f = Integer.MAX_VALUE;
			this.distance = Integer.MAX_VALUE;
		}
		
	}
	
	private class Edge {
		private int source;
		private int destination;
		double weight;
		
		public Edge(int source, int destination, double weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
		
	}
	
	public void Astar() {
		//To be implemented
	}
	
	
}
