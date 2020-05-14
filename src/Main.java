import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		NavigationScreenViewer ss = new NavigationScreenViewer();
		ss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ss.setLocationRelativeTo(null);
		ss.setResizable(false);
		ss.setVisible(true);
		
	}
}
