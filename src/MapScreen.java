import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.SpringLayout;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.Icon;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class MapScreen extends JFrame {

	static final String[] LOCATION_OPTIONS = {"Restaurants", "Gas Stations", "Attractions", "All"};
	private ImageIcon gas = new ImageIcon("images/gas.png");
	private ImageIcon attractions = new ImageIcon("images/atta.png");
	private ImageIcon restaurants = new ImageIcon("images/rest.png");
	private ImageIcon map = new ImageIcon("images/locs.png");
	private String currentDisplay; 

	/**
	 * Create the frame.
	 */
	
	/*
	 * Create selection areas and with each node / location,
	 * a popup of the 5 neighboring locations will appear
	 */
	public MapScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		
		Image m = map.getImage().getScaledInstance(625, 700, Image.SCALE_SMOOTH);
		map = new ImageIcon(m);
		
		// gas station map
		Image g = gas.getImage().getScaledInstance(625, 700, Image.SCALE_SMOOTH);
		gas = new ImageIcon(g);
		
		// attractions map
		Image a = attractions.getImage().getScaledInstance(625, 700, Image.SCALE_SMOOTH);
		attractions = new ImageIcon(a);
		
		// restaurants map
		Image r = restaurants.getImage().getScaledInstance(625, 700, Image.SCALE_SMOOTH);
		restaurants = new ImageIcon(r);
		
		JPanel mapPanel = new JPanel();
		getContentPane().add(mapPanel, BorderLayout.WEST);
		mapPanel.setLayout(new BoxLayout(mapPanel, BoxLayout.X_AXIS));
		
		JLabel mapHere = new JLabel(map);
		mapPanel.add(mapHere);
		
		JPanel display = new JPanel();
		getContentPane().add(display, BorderLayout.EAST);
		
		JLabel curShow = new JLabel("Currently displaying all locations");
		curShow.setFont(new Font("High Tower Text", Font.PLAIN, 25));
		display.add(curShow, "cell 0 0,alignx left,aligny center");
		
		JButton backHome = new JButton("BACK TO HOME SCREEN");
		backHome.setFont(new Font("High Tower Text", Font.PLAIN, 15));
		backHome.setBackground(Color.RED);
		backHome.setOpaque(true);
		backHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new NavigationScreen();
			}
			
		});
		
		JComboBox locationOps = new JComboBox(LOCATION_OPTIONS);
		locationOps.setBackground(Color.GREEN);
		locationOps.setSelectedIndex(3);
		locationOps.setFont(new Font("High Tower Text", Font.PLAIN, 30));
		locationOps.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<?> b = (JComboBox<?>)e.getSource();
				currentDisplay = (String)b.getSelectedItem();
				curShow.setText("Currently displaying " + currentDisplay);
				if(currentDisplay.compareTo("Restaurants") == 0) {
					changeMap(mapPanel, restaurants);
				}else if(currentDisplay.compareTo("Attractions") == 0) {
					changeMap(mapPanel, attractions);
				}else if(currentDisplay.compareTo("Gas Stations") == 0) {
					changeMap(mapPanel, gas);
				}else {
					changeMap(mapPanel, map);
				}
			}
		});
		display.add(locationOps, "cell 0 6,growx,aligny center");
		display.add(backHome, "cell 0 20,alignx left,aligny center");
		
		
		setVisible(true);
		setLocationRelativeTo(null);
	
	}
	
		
	public void changeMap(JPanel m, ImageIcon i) {
			m.removeAll();
			JLabel mapping = new JLabel(i);
			m.add(mapping);
			m.validate();
			m.repaint();
	}	
}

