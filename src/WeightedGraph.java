import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class WeightedGraph {

	private LinkedList<Edge> adj[];
	public Vertex[] vertices;
	public double distance;
	private int vNum;
	
	public WeightedGraph(int vNum){
		this.vNum = vNum;
		vertices = new Vertex[this.vNum];
		this.adj = new LinkedList[vNum];
		for(int i = 0; i < vNum; i++)
			this.adj[i] = new LinkedList<Edge>();
	}
	
	public void addEdge(int source, int destination, double weight) {
		this.adj[source].add(new Edge(source, destination, weight));
	}
	
	public void addVertex(int id, double x, double y) {
		vertices[id] = new Vertex(id,x,y);
		System.out.println(id);
	}
	
	private class Vertex implements Comparable<Vertex>{
		public double x, y;
		public int id;
	    public double heuristic;
	    public double logical;
	    public double function;
	    
		public Vertex(int id, double x, double y) {
			this.x = x;
			this.y = y;
			this.id = id;
			this.function = Double.MAX_VALUE;
			this.heuristic = Double.MAX_VALUE;
			this.logical = Double.MAX_VALUE;
		}
		@Override
		public int compareTo(Vertex vertex) {
			// TODO Auto-generated method stub
			if(vertex == null) return -1;
			if((heuristic+logical) > (vertex.heuristic + vertex.logical)) {
				return 1;
			}else if((heuristic+logical) < (vertex.heuristic + vertex.logical)) {
				return -1;
			}
			
			return 0;
		}
		
		@Override
		public String toString() {
			return "id: " + id + " heuristic: " + heuristic + " logical: " + logical + "\n";
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
	
	public double distance(Vertex v1, Vertex v2) {
		return Math.sqrt(Math.pow((v2.x - v1.x), 2.0)+ Math.pow((v2.y - v1.y), 2.0)) * 75000;
	}
	
	public LinkedList<Integer> Astar(WeightedGraph graph, int source, int destination) {
		LinkedList<Integer> path = new LinkedList<Integer>();
		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>(this.vNum);
		
		vertices[source].logical = 0;
		vertices[source].function = 0;
		queue.add(vertices[source]);
		
		
		while(!queue.isEmpty()) {
			System.out.println(queue.toString());
			Vertex minVertex = queue.poll();
			path.add(minVertex.id);
			
			
			for(int i = 0; i < graph.adj[minVertex.id].size(); i++) {
				Edge edge = graph.adj[minVertex.id].get(i);
				Vertex vertex = vertices[edge.destination];
				
				if(vertex.id == destination) {
					queue.clear();
					break;
				}
				
				if((minVertex.logical + edge.weight) < vertex.logical) {
					vertex.logical = minVertex.logical + edge.weight;
					vertex.heuristic = distance(vertex, vertices[destination]);
					vertex.function = vertex.logical + vertex.heuristic;
				
					if(queue.contains(vertex) == false) {
						queue.add(vertex);
					}else {
						queue.remove(vertex);
						queue.add(vertex);
					}
					
				}
			}
		}
		return path;
		
	}
	
	
}
