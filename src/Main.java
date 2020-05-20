import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		NavigationScreenViewer ss = new NavigationScreenViewer();
		ss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ss.setLocationRelativeTo(null);
		ss.setResizable(false);
		ss.setVisible(true);
		
		GraphGenerator gg = new GraphGenerator(23);
		WeightedGraph graph = gg.generateGraph();
		
		//this is just to test
		
		System.out.println(graph.shortestPath(graph.Astar(graph, 0, 11)).toString());
	}
}
