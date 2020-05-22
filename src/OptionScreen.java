import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;

import org.w3c.dom.Node;

import javax.swing.SpringLayout;
import javax.imageio.ImageIO;
import javax.sound.sampled.Line;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Color;

public class OptionScreen extends JFrame {

	static final String[] LOCATION_OPTIONS = { "Restaurants", "Gas Stations", "Attractions" };
	static final String[] REST_LETTERS = { "A", "E", "I", "K", "L", "O", "S", "U" };
	static final String[] GAS_LETTERS = { "C", "G", "H", "J", "M", "N", "P", "Q" };
	static final String[] ATTR_LETTERS = { "B", "D", "F", "R", "T", "V", "W" };
	static final String[] ALL_LETTERS = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
			"P", "Q", "R", "S", "T", "U", "V", "W" };

	public static final String[] RESTAURANT_LIST = { "Bistro Aracosia", "Thip Khao Restaurant", "Clydes of Georgetown",
			"Founding Farmers DC", "Le Diplomate", "All-Purpose Shaw", "Ambar Capitol Hill", "Zaytinya" };
	public static final String[] GAS_STATION_LIST = { "Davis EXXON", "Sunco", "Sunco", "Sunco", "Marathon", "BP",
			"Florida Avenue EXXON", "Marathon" };
	public static final String[] ATTRACTION_LIST = { "Washington National Cathedral",
			"Smithsonian National Zoological Park", "Basilica of the National Shrine of the Immaculate Conception",
			"United States National Arboretum", "Smithsonian National Air and Space Museum", "Lafayette Square",
			"United States Holocaust Memorial Museum" };
	public static final int W_AND_H = 15;

	Double distanceTravel = 0.0;
	
	JComboBox startingLoc;
	JComboBox endingLoc;
	JComboBox restaurants = new JComboBox(REST_LETTERS);
	JComboBox gasStations = new JComboBox(GAS_LETTERS);
	JComboBox attractions = new JComboBox(ATTR_LETTERS);
	JLabel placeStart;
	JLabel placeEnd;
	JLabel shortestLabel;
	JPanel testingP;

	public String startLetter = null;
	public String endLetter = null;

	public SpecificPlaceListener startAttractionListener = new SpecificPlaceListener(ATTR_LETTERS);
	public SpecificPlaceListener startRestaurantListener = new SpecificPlaceListener(REST_LETTERS);
	public SpecificPlaceListener startGasListener = new SpecificPlaceListener(GAS_LETTERS);

	public SpecificPlaceListener endAttractionListener = new SpecificPlaceListener(ATTR_LETTERS);
	public SpecificPlaceListener endRestaurantListener = new SpecificPlaceListener(REST_LETTERS);
	public SpecificPlaceListener endGasListener = new SpecificPlaceListener(GAS_LETTERS);

	public HashMap<String, Integer> exes = new HashMap<String, Integer>(23);
	public HashMap<String, Integer> whys = new HashMap<String, Integer>(23);
	public HashMap<String, int[]> lines = new HashMap<String, int[]>();

	private BufferedImage nodes;

	/**
	 * Create the frame.
	 */
	public OptionScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);

		setLocationRelativeTo(null);
		getContentPane().setLayout(new GridLayout(0, 2, 0, 0));

		// creating button group for starting locations
		ButtonGroup locButtons = new ButtonGroup();

		// button group for ending locations
		ButtonGroup endLocs = new ButtonGroup();

		// button group for method of transportation selection
		ButtonGroup methods = new ButtonGroup();

		// adding all letters, representation of locations, to HashMaps
		for (String letter : REST_LETTERS) {
			exes.put(letter, 1);
			whys.put(letter, 1);
		}

		for (String letter : ATTR_LETTERS) {
			exes.put(letter, 1);
			whys.put(letter, 1);
		}

		for (String letter : GAS_LETTERS) {
			exes.put(letter, 1);
			whys.put(letter, 1);
		}

		// setting x and y coordinates of each node
		exes.replace("A", 5);
		whys.replace("A", 340);
		exes.replace("B", 50);
		whys.replace("B", 260);
		exes.replace("C", 208);
		whys.replace("C", 160);
		exes.replace("D", 110);
		whys.replace("D", 240);
		exes.replace("E", 208);
		whys.replace("E", 210);
		exes.replace("F", 353);
		whys.replace("F", 258);
		exes.replace("G", 225);
		whys.replace("G", 258);
		exes.replace("H", 180);
		whys.replace("H", 290);
		exes.replace("I", 98);
		whys.replace("I", 360);
		exes.replace("J", 127);
		whys.replace("J", 406);
		exes.replace("K", 175);
		whys.replace("K", 400);
		exes.replace("L", 213);
		whys.replace("L", 320);
		exes.replace("M", 257);
		whys.replace("M", 320);
		exes.replace("N", 278);
		whys.replace("N", 313);
		exes.replace("O", 228);
		whys.replace("O", 373);
		exes.replace("P", 298);
		whys.replace("P", 350);
		exes.replace("Q", 375);
		whys.replace("Q", 340);
		exes.replace("R", 415);
		whys.replace("R", 350);
		exes.replace("S", 380);
		whys.replace("S", 458);
		exes.replace("T", 252);
		whys.replace("T", 437);
		exes.replace("U", 252);
		whys.replace("U", 395);
		exes.replace("V", 198);
		whys.replace("V", 377);
		exes.replace("W", 205);
		whys.replace("W", 455);

		try {
			nodes = ImageIO.read(new File("images/map.jpg"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		// panel for lines and dots
		testingP = new JPanel() {

			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g.create();
				if (nodes != null) {
					int x = (testingP.getWidth() - nodes.getWidth()) / 2;
					int y = (testingP.getHeight() - nodes.getHeight()) / 2;
					g2.drawImage(nodes, x, y, testingP);
					g2.setStroke(new BasicStroke(4f));
					for (String dots : exes.keySet()) {
						g2.fillOval(exes.get(dots), whys.get(dots), W_AND_H, W_AND_H);
						int[] coords = { exes.get(dots) + 5, whys.get(dots) + 5 };
						lines.put(dots, coords);
					}
					if (startLetter != null && endLetter != null) {
						LinkedList<String> curLocation = getLocations(startLetter, endLetter);
						for (int k = 0; k < curLocation.size() - 1; k++) {
							g2.drawLine(lines.get(curLocation.get(k))[0], lines.get(curLocation.get(k))[1],
									lines.get(curLocation.get(k + 1))[0], lines.get(curLocation.get(k + 1))[1]);
						}
					}
				}
			}
		};

		testingP.setLayout(new GridLayout(1, 0, 0, 0));
		getContentPane().add(testingP);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setMaximumSize(getPreferredSize());
		getContentPane().add(buttonPanel);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		// label for starting Location
		JLabel startingTxt = new JLabel("Choose type of starting location.");
		startingTxt.setFont(new Font("High Tower Text", Font.BOLD, 25));
		buttonPanel.add(startingTxt);

		// restaurant Radio Button
		JRadioButton restaurantB = new JRadioButton("Restaurants");
		restaurantB.setFont(new Font("High Tower Text", Font.PLAIN, 25));
		buttonPanel.add(restaurantB);

		// attraction Radio Button
		JRadioButton attractionB = new JRadioButton("Attractions");
		attractionB.setFont(new Font("High Tower Text", Font.PLAIN, 25));
		buttonPanel.add(attractionB);

		// gas Radio Button
		JRadioButton gasB = new JRadioButton("Gas Stations");
		gasB.setFont(new Font("High Tower Text", Font.PLAIN, 25));
		buttonPanel.add(gasB);
		locButtons.add(restaurantB);
		locButtons.add(gasB);
		locButtons.add(attractionB);

		// adding startinglocationlistener to buttons
		restaurantB.addActionListener(new StartingLocationListener(restaurantB));
		gasB.addActionListener(new StartingLocationListener(gasB));
		attractionB.addActionListener(new StartingLocationListener(attractionB));

		// starting location combo box WITH LETTERS
		startingLoc = new JComboBox(REST_LETTERS);
		startingLoc.setEnabled(false);
		startingLoc.setFont(new Font("High Tower Text", Font.PLAIN, 25));

		buttonPanel.add(startingLoc);

		// Label to display selected STARTING location
		placeStart = new JLabel("You have not selected anywhere.");
		placeStart.setFont(new Font("Rockwell", Font.ITALIC, 20));
		buttonPanel.add(placeStart);

		// label for instructions
		JLabel endingTxt = new JLabel("Choose type of ending location.");
		endingTxt.setFont(new Font("High Tower Text", Font.BOLD, 25));
		buttonPanel.add(endingTxt);

		// radio button for restaurants
		JRadioButton restaurantB_1 = new JRadioButton("Restaurants");
		restaurantB_1.setFont(new Font("High Tower Text", Font.PLAIN, 25));
		buttonPanel.add(restaurantB_1);

		// radio button for attractions
		JRadioButton attractionB_1 = new JRadioButton("Attractions");
		attractionB_1.setFont(new Font("High Tower Text", Font.PLAIN, 25));
		buttonPanel.add(attractionB_1);

		// radio button for gas stations
		JRadioButton gasB_1 = new JRadioButton("Gas Stations");
		gasB_1.setFont(new Font("High Tower Text", Font.PLAIN, 25));
		buttonPanel.add(gasB_1);
		endLocs.add(gasB_1);
		endLocs.add(restaurantB_1);
		endLocs.add(attractionB_1);

		// adding endinglocationlistener to buttons
		gasB_1.addActionListener(new EndingLocationListener(gasB_1));
		restaurantB_1.addActionListener(new EndingLocationListener(restaurantB_1));
		attractionB_1.addActionListener(new EndingLocationListener(attractionB_1));

		// JComboBox for ending location
		endingLoc = new JComboBox(REST_LETTERS);
		endingLoc.setFont(new Font("High Tower Text", Font.PLAIN, 25));
		endingLoc.setEnabled(false);
		buttonPanel.add(endingLoc);

		// label to display selected ENDING location
		placeEnd = new JLabel("You have not selected anywhere.");
		placeEnd.setFont(new Font("Rockwell", Font.ITALIC, 20));
		buttonPanel.add(placeEnd);

		JLabel spaceFiller = new JLabel("<html> How would you like to reach <br/> your destination?</html>");
		spaceFiller.setFont(new Font("High Tower Text", Font.PLAIN, 25));
		buttonPanel.add(spaceFiller);

		JRadioButton shortDist = new JRadioButton("Shortest Distance");
		shortDist.setFont(new Font("High Tower Text", Font.PLAIN, 25));
		shortDist.addActionListener(new DistanceorTimeDisplayListener(shortDist));
		buttonPanel.add(shortDist);

		JRadioButton shortTime = new JRadioButton("Shortest Time");
		shortTime.setFont(new Font("High Tower Text", Font.PLAIN, 25));
		shortTime.addActionListener(new DistanceorTimeDisplayListener(shortTime));
		buttonPanel.add(shortTime);
		
		shortestLabel = new JLabel("Please select one of the above for more info.");
		shortestLabel.setFont(new Font("High Tower Text", Font.PLAIN, 25));
		buttonPanel.add(shortestLabel);
		
		JButton homeScreenButton = new JButton("Return to Home Screen");
		homeScreenButton.setBackground(Color.YELLOW);
		homeScreenButton.setFont(new Font("High Tower Text", Font.BOLD, 20));
		buttonPanel.add(homeScreenButton);
		homeScreenButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new NavigationScreen();
			}
		});
		
		methods.add(shortTime);
		methods.add(shortDist);

		setVisible(true);
	}

	public LinkedList<String> getLocations(String start, String end) {
		GraphGenerator gg = new GraphGenerator(23);
		WeightedGraph graph = gg.generateGraph();

		ArrayList<String> easy = new ArrayList<String>();
		for (int p = 0; p < ALL_LETTERS.length; p++) {
			easy.add(ALL_LETTERS[p]);
		}

		int begin = easy.indexOf(start);
		int stop = easy.indexOf(end);

		LinkedList<Integer> indices = graph.shortestPath(graph.Astar(graph, begin, stop));
		System.out.println(indices);
		LinkedList<String> letters = new LinkedList<String>();
		
		for(int i=0; i<graph.getLogicDistances().size(); i++) {
			distanceTravel  += graph.getLogicDistances().get(i);
		}
		
		distanceTravel = (double) Math.round(distanceTravel / 1000)*0.5;

		for (int i = 0; i < indices.size(); i++) {
			letters.add(easy.get(indices.get(i)));
		}

		return letters;
	}
	

	public class DistanceorTimeDisplayListener implements ActionListener{
		
		JRadioButton button;
		
		public DistanceorTimeDisplayListener(JRadioButton b) {
			this.button = b;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(button.getText().equals("Shortest Distance")) {
				shortestLabel.setText("The shortest route is " + distanceTravel + " miles.");
			} else if(button.getText().equals("Shortest Time")) {
				shortestLabel.setText("<html>It will take you " + (int)((distanceTravel*15) - (distanceTravel*2)) + "<br/>less minutes to travel by car <br/> than by foot</html>");
			}
		}
	}

	public class StartingLocationListener implements ActionListener {

		JRadioButton button;

		StartingLocationListener(JRadioButton b) {
			button = b;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			if (button.getText().equals("Attractions")) {
				startingLoc.setEnabled(true);
				startingLoc.setModel(attractions.getModel());
				startingLoc.removeActionListener(startGasListener);
				startingLoc.removeActionListener(startRestaurantListener);
				startingLoc.addActionListener(startAttractionListener);
			} else if (button.getText().equals("Restaurants")) {
				startingLoc.setEnabled(true);
				startingLoc.setModel(restaurants.getModel());
				startingLoc.removeActionListener(startAttractionListener);
				startingLoc.removeActionListener(startGasListener);
				startingLoc.addActionListener(startRestaurantListener);
			} else if (button.getText().contentEquals("Gas Stations")) {
				startingLoc.setEnabled(true);
				startingLoc.setModel(gasStations.getModel());
				startingLoc.removeActionListener(startAttractionListener);
				startingLoc.removeActionListener(startRestaurantListener);
				startingLoc.addActionListener(startGasListener);
			}
		}

	}

	public class SpecificPlaceListener implements ActionListener {

		String[] lets;

		public SpecificPlaceListener(String[] p) {
			lets = p;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(startingLoc)) {
				if (lets.equals(REST_LETTERS)) {
					placeStart.setText("<html>You have selected <br/>" + RESTAURANT_LIST[startingLoc.getSelectedIndex()]
							+ "</html>");
					startLetter = REST_LETTERS[startingLoc.getSelectedIndex()];
				} else if (lets.equals(ATTR_LETTERS)) {
					placeStart.setText("<html>You have selected <br/>" + ATTRACTION_LIST[startingLoc.getSelectedIndex()]
							+ "</html>");
					startLetter = ATTR_LETTERS[startingLoc.getSelectedIndex()];
				} else if (lets.equals(GAS_LETTERS)) {
					placeStart.setText("<html>You have selected <br/>"
							+ GAS_STATION_LIST[startingLoc.getSelectedIndex()] + "</html>");
					startLetter = GAS_LETTERS[startingLoc.getSelectedIndex()];
				}
			} else if (e.getSource().equals(endingLoc)) {
				if (lets.equals(REST_LETTERS)) {
					placeEnd.setText("<html>You have selected <br/>" + RESTAURANT_LIST[endingLoc.getSelectedIndex()]
							+ "</html>");
					endLetter = REST_LETTERS[endingLoc.getSelectedIndex()];
				} else if (lets.equals(ATTR_LETTERS)) {
					placeEnd.setText("<html>You have selected <br/>" + ATTRACTION_LIST[endingLoc.getSelectedIndex()]
							+ "</html>");
					endLetter = ATTR_LETTERS[endingLoc.getSelectedIndex()];
				} else if (lets.equals(GAS_LETTERS)) {
					placeEnd.setText("<html>You have selected <br/>" + GAS_STATION_LIST[endingLoc.getSelectedIndex()]
							+ "</html>");
					endLetter = GAS_LETTERS[endingLoc.getSelectedIndex()];
				}
			}
			System.out.println("End Letter is: " + endLetter);
			System.out.println("Start Letter is: " + startLetter);
			testingP.repaint();
		}
	}

	public class EndingLocationListener implements ActionListener {

		String button;
		Boolean disable;

		public EndingLocationListener(JRadioButton b) {
			this.button = b.getText();
			disable = true;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (button.equals("Attractions")) {
				endingLoc.setEnabled(true);
				endingLoc.setModel(attractions.getModel());
				endingLoc.removeActionListener(endGasListener);
				endingLoc.removeActionListener(endRestaurantListener);
				endingLoc.addActionListener(endAttractionListener);
			} else if (button.equals("Restaurants")) {
				endingLoc.setEnabled(true);
				endingLoc.setModel(restaurants.getModel());
				endingLoc.removeActionListener(endAttractionListener);
				endingLoc.removeActionListener(endGasListener);
				endingLoc.addActionListener(endRestaurantListener);
			} else if (button.equals("Gas Stations")) {
				endingLoc.setEnabled(true);
				endingLoc.setModel(gasStations.getModel());
				endingLoc.removeActionListener(endAttractionListener);
				endingLoc.removeActionListener(endRestaurantListener);
				endingLoc.addActionListener(endGasListener);
			}
		}
	}
}
