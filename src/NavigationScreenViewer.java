import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NavigationScreenViewer extends JFrame {
	
	public NavigationScreenViewer() {
		
		this.setTitle("Checkered Treehouse Presents...");
		this.setSize(800, 500);
		
		JPanel starting = new JPanel();
		
		this.add(starting, BorderLayout.SOUTH);
		
		JButton exit = new JButton("EXIT");
		exit.setBackground(Color.red);
		exit.setOpaque(true);
		exit.setBorderPainted(false);
		exit.addActionListener(new ExitListener());
		
		JButton cont = new JButton("CONTINUE");
		cont.setBackground(Color.green);
		cont.setOpaque(true);
		cont.setBorderPainted(false);
		cont.addActionListener(new ContinueListener());
		
		starting.add(exit);
		starting.add(cont);
		
		
	}
	
	public static void main(String[] args) {
		
		NavigationScreenViewer ss = new NavigationScreenViewer();
		ss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ss.setLocationRelativeTo(null);
		ss.setVisible(true);
		
	}
	
	public class ExitListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
		
	}
	
	public class ContinueListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			UserScreen us = new UserScreen();
			
			
		}
		
		
	}
	
	public class UserScreen extends JFrame{
		
		JButton map;
		JButton routes;
		JButton destination;
		JButton locations;
		
		public UserScreen() {
			
			this.setTitle("Navigation Options");
			this.setSize(800, 500);
			
			JPanel selection = new JPanel();
			this.add(selection);
			
			ImageIcon mapp = new ImageIcon("images/viewmap.png");
			Image scal = mapp.getImage();
			Image newin = scal.getScaledInstance(270, 200, java.awt.Image.SCALE_SMOOTH);
			mapp = new ImageIcon(newin);
			
			ImageIcon dest = new ImageIcon("images/destination.png");
			Image scat = dest.getImage();
			Image nodeds = scat.getScaledInstance(270, 200, java.awt.Image.SCALE_SMOOTH);
			dest = new ImageIcon(nodeds);
			
			ImageIcon rout = new ImageIcon("images/routeoptions.png");
			Image sat = rout.getImage();
			Image nat = sat.getScaledInstance(270, 200, java.awt.Image.SCALE_SMOOTH);
			rout = new ImageIcon(nat);
			
			ImageIcon loct = new ImageIcon("images/locations.png");
			Image pat = loct.getImage();
			Image rat = pat.getScaledInstance(270, 200, java.awt.Image.SCALE_SMOOTH);
			loct = new ImageIcon(rat);
			
			
			map = new JButton(mapp);
			routes = new JButton(rout);
			destination = new JButton(dest);
			locations = new JButton(loct);			

			selection.add(map, BorderLayout.NORTH);
			selection.add(routes, BorderLayout.PAGE_END);
			selection.add(destination, BorderLayout.EAST);
			selection.add(locations, BorderLayout.WEST);
			
			this.setBackground(Color.BLACK);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		}
	
	}

}
