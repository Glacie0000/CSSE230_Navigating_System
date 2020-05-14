import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class NavigationScreenViewer extends JFrame {
	
	public NavigationScreenViewer() {
		
		this.setTitle("Checkered Treehouse Presents...");
		this.setSize(800, 500);
		
		JPanel starting = new JPanel();
		this.add(starting, BorderLayout.SOUTH);
		
		ImageIcon nav = new ImageIcon("images/navscreen.png");
		Image van = nav.getImage();
		Image sal = van.getScaledInstance(300, 400, Image.SCALE_SMOOTH);
		nav = new ImageIcon(sal);
		
		JLabel lp = new JLabel(nav);
		starting.add(lp);
		
		JButton exit = new JButton("EXIT");
		exit.setBackground(Color.red);
		exit.setOpaque(true);
		exit.setBorderPainted(false);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton cont = new JButton("CONTINUE");
		cont.setBackground(Color.green);
		cont.setOpaque(true);
		cont.setBorderPainted(false);
		cont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new UserScreen();
				
			}
		});
		
		starting.add(exit);
		starting.add(cont);
		
		
	}
	
	public static void main(String[] args) {
		
		NavigationScreenViewer ss = new NavigationScreenViewer();
		ss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ss.setLocationRelativeTo(null);
		ss.setResizable(false);
		ss.setVisible(true);
		
	}
	
	@SuppressWarnings("serial")
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
			Image newin = scal.getScaledInstance(270, 220, Image.SCALE_SMOOTH);
			mapp = new ImageIcon(newin);
			
			ImageIcon dest = new ImageIcon("images/destination.png");
			Image scat = dest.getImage();
			Image nodeds = scat.getScaledInstance(270, 220, Image.SCALE_SMOOTH);
			dest = new ImageIcon(nodeds);
			
			ImageIcon rout = new ImageIcon("images/routeoptions.png");
			Image sat = rout.getImage();
			Image nat = sat.getScaledInstance(270, 220, Image.SCALE_SMOOTH);
			rout = new ImageIcon(nat);
			
			ImageIcon loct = new ImageIcon("images/locations.png");
			Image pat = loct.getImage();
			Image rat = pat.getScaledInstance(270, 220, Image.SCALE_SMOOTH);
			loct = new ImageIcon(rat);
			
			
			map = new JButton(mapp);
			map.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new MapScreen();
				}
			});
			
			routes = new JButton(rout);
			routes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new RouteScreen();
				}
			});
			
			destination = new JButton(dest);
			destination.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new DestinationScreen();
				}
			});
			
			locations = new JButton(loct);			
			locations.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new LocationScreen();
				}
			});

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

	public class MapScreen extends JFrame{
		
		public MapScreen() {
			
			this.setTitle("Map");
			this.setSize(800, 500);
			
			JPanel bod = new JPanel();
			this.add(bod);
			
			JButton back = new JButton("BACK TO HOME SCREEN");
			back.setBackground(Color.ORANGE);
			back.setOpaque(true);
			back.setBorderPainted(false);
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new UserScreen();
				}
			});
			bod.add(back);
			
			ImageIcon mep = new ImageIcon("images/locs.png");
			Image met = mep.getImage();
			Image mek = met.getScaledInstance(600, 450, Image.SCALE_SMOOTH);
			mep = new ImageIcon(mek);
			JLabel mapping = new JLabel(mep);
			bod.add(mapping);
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setVisible(true);
		}
	}
	
	public class RouteScreen extends JFrame{
		
		Font forAll = new Font("Monospaced", Font.BOLD, 30);
		
		public RouteScreen() {
			
			this.setTitle("Routes");
			this.setSize(800, 500);
			
			JPanel rr = new JPanel();
			rr.setLayout(new GridLayout(2,1));
			this.add(rr, BorderLayout.NORTH);
			
			JButton back = new JButton("BACK TO HOME SCREEN");
			back.setBackground(Color.ORANGE);
			back.setOpaque(true);
			back.setBorderPainted(false);
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new UserScreen();
				}
			});
			rr.add(back, BorderLayout.NORTH);
			
			JLabel choices = new JLabel("CHOOSE ROUTE BY...");
			choices.setFont(new Font("Serif", Font.BOLD, 35));
			rr.add(choices);
			
			JPanel buts = new JPanel();
			buts.setLayout(new GridLayout(2,2));
			this.add(buts, BorderLayout.CENTER);
			
			JButton shortestDistance = new JButton("Shortest Distance");
			shortestDistance.setFont(forAll);
			buts.add(shortestDistance);
			
			JButton shortestTime = new JButton("Shortest Time");
			shortestTime.setFont(forAll);
			buts.add(shortestTime);
			
			JButton maxDistance = new JButton("Maximum Distance");
			maxDistance.setFont(forAll);
			buts.add(maxDistance);
			
			JButton maxTime = new JButton("Maximum Time");
			maxTime.setFont(forAll);
			buts.add(maxTime);
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setVisible(true);
		}
	}
	
	public class DestinationScreen extends JFrame{
		
		public DestinationScreen() {
			
			this.setTitle("Destination");
			this.setSize(800, 500);
			
			JPanel ds = new JPanel();
			this.add(ds, BorderLayout.NORTH);
			
			JPanel ps = new JPanel();
			GridLayout gl = new GridLayout(4,2);
			ps.setLayout(gl);
			
			JLabel address = new JLabel("Street Address:");
			JTextField addy = new JTextField("Enter Address Here");
			JLabel cit = new JLabel("City:");
			JTextField city = new JTextField("Enter City Here");
			JLabel stit = new JLabel("City:");
			JTextField state = new JTextField("Enter State Abr. Here");
			JLabel zipy = new JLabel("Zip Code: ");
			JTextField zip = new JTextField("Enter 5 Digit Zip Code Here");
			ps.add(address); ps.add(addy); 
			ps.add(cit); ps.add(city); 
			ps.add(stit); ps.add(state); 
			ps.add(zipy); ps.add(zip);         
			this.add(ps, BorderLayout.CENTER);
			
			JButton back = new JButton("BACK TO HOME SCREEN");
			back.setBackground(Color.ORANGE);
			back.setOpaque(true);
			back.setBorderPainted(false);
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new UserScreen();
				}
			});
			ds.add(back);
			
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setVisible(true);
			
		}
	}
	
	public class LocationScreen extends JFrame{
		
		Font forAll = new Font("Monospaced", Font.BOLD, 30);
		ImageIcon gat = new ImageIcon("images/gas.png");
		ImageIcon att = new ImageIcon("images/atta.png");
		ImageIcon rep = new ImageIcon("images/rest.png");
		ImageIcon reg = new ImageIcon("images/locs.png");
		
		public LocationScreen() {
			
			this.setTitle("Locations");
			this.setSize(800, 500);
			
			
			JPanel ls = new JPanel();
			ls.setLayout(new GridLayout(2,1));
			this.add(ls, BorderLayout.NORTH);
			
			JButton back = new JButton("BACK TO HOME SCREEN");
			back.setBackground(Color.ORANGE);
			back.setOpaque(true);
			back.setBorderPainted(false);
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new UserScreen();
				}
			});
			ls.add(back);
			
			JLabel locs = new JLabel("SELECT ONE FOR MORE OPTIONS");
			locs.setFont(new Font("Serif", Font.BOLD, 30));
			ls.add(locs);
			
			JPanel tons = new JPanel();
			tons.setLayout(new GridLayout(4,1));
			this.add(tons, BorderLayout.EAST);
			
			JButton attraction = new JButton("Attractions");
			attraction.setFont(forAll);
			tons.add(attraction);
			
			JButton rest = new JButton("Restaurants");
			rest.setFont(forAll);
			tons.add(rest);
			
			JButton gas = new JButton("Gas Stations");
			gas.setFont(forAll);
			tons.add(gas);
			
			JButton atm = new JButton("ATM / Banks");
			atm.setFont(forAll);
			tons.add(atm);
			
			JPanel map = new JPanel();
			Image met = reg.getImage();
			Image mek = met.getScaledInstance(600, 450, Image.SCALE_SMOOTH);
			reg = new ImageIcon(mek);
			JLabel mapping = new JLabel(reg);
			map.add(mapping);
			this.add(map);

			
			attraction.addActionListener(new ChangeMapListener(map, att));
			rest.addActionListener(new ChangeMapListener(map, rep));
			gas.addActionListener(new ChangeMapListener(map, gat));
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setVisible(true);
		}
	}
	
	public class ChangeMapListener implements ActionListener{
		
		JPanel map;
		ImageIcon image;
		
		public ChangeMapListener(JPanel m, ImageIcon i) {
			this.map = m;
			this.image = i;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			map.removeAll();
			Image met = image.getImage();
			Image mek = met.getScaledInstance(600, 450, Image.SCALE_SMOOTH);
			image = new ImageIcon(mek);
			JLabel mapping = new JLabel(image);
			map.add(mapping);
			map.validate();
			map.repaint();
			map.printAll(getGraphics());
		}
		
		
	}

}
