import java.util.ArrayList;
import java.util.LinkedList;

public class WeightedGraph {

	private ArrayList<Edge> adj[];
	Vertex[] vertices;
	private int vNum;
	
	public WeightedGraph(int vNum){
		this.vNum = vNum;
		Vertex[] vertices = new Vertex[this.vNum];
		for(int i = 0; i < vNum; i++)
			this.adj[i] = new ArrayList<Edge>();
	}
	
	public void addEdge(int source, int destination, int weight) {
		this.adj[source].add(new Edge(source, destination, weight));
	}
	
	public void addVertex(int id, int x, int y) {
		vertices[id] = new Vertex(id,x,y);
	}
	
	private class Vertex {
		public int x, y;
		public int id;
		
		public Vertex(int id, int x, int y) {
			this.x = x;
			this.y = y;
			this.id = id;
			
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
	
	public int manhattanDistance(Vertex v1, Vertex v2) {
		return Math.abs(v1.x - v2.x) + Math.abs(v1.y - v2.y);
	}
	
	public void Astar() {
		//To be implemented to implement a new graph everytime
	}
	
	
}
