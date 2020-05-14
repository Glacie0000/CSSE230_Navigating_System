import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class WeightedGraph {

	private ArrayList<Edge> adj[];
	public Vertex[] vertices;
	public double distance;
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
	
	private class Vertex implements Comparable<Vertex>{
		public double x, y;
		public int id;
	    public double heuristic;
	    public double logical;
	    public double function;
		public Vertex(int id, int x, int y) {
			this.x = x;
			this.y = y;
			this.id = id;
			function = Integer.MAX_VALUE;
			this.heuristic = Integer.MAX_VALUE;
			this.logical = Integer.MAX_VALUE;
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
		
	}
	
	private class Edge {
		private int source;
		private int destination;
		int weight;
		
		public Edge(int source, int destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
		
	}
	
	public double manhattanDistance(Vertex v1, Vertex v2) {
		return Math.sqrt(Math.pow((v2.x - v1.x), 2.0)+ Math.pow((v2.y - v1.y), 2.0));
	}
	
	public LinkedList<Integer> Astar(WeightedGraph graph, int source, int destination) {
		//To be implemented to implement a new graph everytime
		LinkedList<Integer> path = new LinkedList<Integer>();
		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>(this.vNum);
		
		boolean[] inqueue = new boolean[this.vNum];
		
		vertices[source].logical = 0;
		vertices[source].function = 0;
		queue.add(vertices[source]);
		inqueue[source] = true;
		
		while(!queue.isEmpty()) {
			Vertex minVertex = queue.poll();
			path.add(minVertex.id);
			for(int i = 0; i < graph.adj[minVertex.id].size(); i++) {
				Edge edge = graph.adj[minVertex.id].get(i);
				Vertex vertex = vertices[edge.destination];
				
				if((minVertex.logical + edge.weight) < vertex.logical) {
					vertex.logical = minVertex.logical + edge.weight;
					vertex.heuristic = manhattanDistance(vertex, vertices[destination]);
					vertex.function = vertex.logical + vertex.heuristic;
				}
				
				if(inqueue[vertex.id] == false) {
					queue.add(vertex);
					inqueue[vertex.id] = true;
				}else {
					queue.add(vertex);
				}
				
				
				if(vertex.id == destination) {
					queue.clear();
					break;
				}
				
			}
		}
		return path;
		
	}
	
	
}
