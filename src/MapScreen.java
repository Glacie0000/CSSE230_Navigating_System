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
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.Icon;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JToggleButton;

public class MapScreen extends JFrame {

	static final String[] LOCATION_OPTIONS = {"Restaurants", "Gas Stations", "Attractions", "All"};
	private ImageIcon gas = new ImageIcon("images/gas.png");
	private ImageIcon attractions = new ImageIcon("images/atta.png");
	private ImageIcon restaurants = new ImageIcon("images/rest.png");
	private ImageIcon map = new ImageIcon("images/locs.png");
	private String currentDisplay; 
	
	JPanel mapPanel;
	JLabel joke;
	JLabel curLocations;
	
	public String[] posLocs = {"Attractions", "Restaurants", "Gas Stations"};
	public String[] jokes = {"<html>I cannot believe I <br/> got fired from the calendar <br/>factory: all I did was<br/> take a day off!</html>", 
			"<html>Money talks: <br/>mine always says <br/>is goodbye.</html>", 
			"<html>Today a man asked me for a small donation towards the local swimming pool. I gave him a glass of water.</html>",
			"<html>Most people are <br/>shocked when they find<br/> out how bad I am as<br/> an electrician.</html>", 
			"<html>Do not trust atoms,<br/> they make up everything.</html>", 
			"<html>I am reading a <br/>book about anti-gravity. <br/>It is impossible <br/>to put down.</html>", 
			"<html>What is the best<br/> thing about living in<br/> Switzerland? Well, <br/>the flag is a big plus.</html>", 
			"<html>The worst time<br/> to have a heart<br/> attack is during <br/>a game of charades.</html>",
			"<html>My boss is going to fire <br/>the employee with the worst posture. I have a hunch, <br/> it might be me.</html>",
			"<html>I started out<br/> with nothing, and <br/>I still have<br/> most of it.</html>", 
			"<html>The first time <br/>I got a universal remote control I thought to myself, <br/> This changes everything.</html>",
			"<html>When everything <br/>is coming your way<br/> — you’re in the<br/> wrong lane.</html>",
			"<html>Where there’s <br/>a will,<br/> there’s a relative.",
			"<html>If money doesn’t<br/> grow on trees,<br/> how come banks<br/> have branches?</html>",
			"<html>When my boss asked me<br/> who was stupid, me or him, <br/>I told him he doesn’t hire stupid people.</html>"};


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
		getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		mapPanel = new JPanel();
		getContentPane().add(mapPanel);
		
		JPanel textPanel = new JPanel();
		getContentPane().add(textPanel);
		SpringLayout sl_textPanel = new SpringLayout();
		textPanel.setLayout(sl_textPanel);
		
		curLocations = new JLabel("<html> CURRENTLY DISPLAYING <br/> ALL LOCATIONS</html>");
		sl_textPanel.putConstraint(SpringLayout.NORTH, curLocations, 5, SpringLayout.NORTH, textPanel);
		sl_textPanel.putConstraint(SpringLayout.WEST, curLocations, 15, SpringLayout.WEST, textPanel);
		curLocations.setFont(new Font("High Tower Text", Font.BOLD, 30));
		textPanel.add(curLocations);
		
		JComboBox possibleLocations = new JComboBox(posLocs);
		possibleLocations.setFont(new Font("High Tower Text", Font.ITALIC, 40));
		sl_textPanel.putConstraint(SpringLayout.NORTH, possibleLocations, 47, SpringLayout.SOUTH, curLocations);
		sl_textPanel.putConstraint(SpringLayout.WEST, possibleLocations, 0, SpringLayout.WEST, curLocations);
		sl_textPanel.putConstraint(SpringLayout.SOUTH, possibleLocations, 119, SpringLayout.SOUTH, curLocations);
		sl_textPanel.putConstraint(SpringLayout.EAST, possibleLocations, -10, SpringLayout.EAST, textPanel);
		textPanel.add(possibleLocations);
		
		possibleLocations.addActionListener(new DisplayListener(possibleLocations));
		
		JButton homeScreen = new JButton("Return to Home Screen");
		homeScreen.setBackground(Color.YELLOW);
		homeScreen.setFont(new Font("High Tower Text", Font.BOLD, 20));
		sl_textPanel.putConstraint(SpringLayout.SOUTH, homeScreen, -10, SpringLayout.SOUTH, textPanel);
		sl_textPanel.putConstraint(SpringLayout.EAST, homeScreen, 0, SpringLayout.EAST, possibleLocations);
		textPanel.add(homeScreen);
		homeScreen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new NavigationScreen();
			}
		});
		
		joke = new JLabel(jokes[jokes.length - 1]);
		sl_textPanel.putConstraint(SpringLayout.WEST, joke, 100, SpringLayout.WEST, textPanel);
		sl_textPanel.putConstraint(SpringLayout.SOUTH, joke, 340, SpringLayout.SOUTH, possibleLocations);
		sl_textPanel.putConstraint(SpringLayout.EAST, joke, 384, SpringLayout.WEST, textPanel);
		joke.setVerticalAlignment(SwingConstants.TOP);
		joke.setFont(new Font("Jokerman", Font.PLAIN, 20));
		textPanel.add(joke);
		
		JButton jokeButton = new JButton("CLICK HERE FOR A GOOD LAUGH!");
		sl_textPanel.putConstraint(SpringLayout.NORTH, joke, 30, SpringLayout.SOUTH, jokeButton);
		sl_textPanel.putConstraint(SpringLayout.SOUTH, jokeButton, -342, SpringLayout.SOUTH, textPanel);
		sl_textPanel.putConstraint(SpringLayout.WEST, jokeButton, 57, SpringLayout.WEST, textPanel);
		jokeButton.setBackground(Color.ORANGE);
		jokeButton.setOpaque(true);
		jokeButton.setFont(new Font("High Tower Text", Font.ITALIC, 20));
		textPanel.add(jokeButton);
		jokeButton.addActionListener(new JokeListener());
		
		Image m = map.getImage().getScaledInstance(625, 500, Image.SCALE_SMOOTH);
		map = new ImageIcon(m);
		JLabel forMaps = new JLabel(map);
		mapPanel.add(forMaps, BorderLayout.CENTER);
		
		// gas station map
		Image g = gas.getImage().getScaledInstance(625, 500, Image.SCALE_SMOOTH);
		gas = new ImageIcon(g);
		
		// attractions map
		Image a = attractions.getImage().getScaledInstance(625, 500, Image.SCALE_SMOOTH);
		attractions = new ImageIcon(a);
		
		// restaurants map
		Image r = restaurants.getImage().getScaledInstance(625, 500, Image.SCALE_SMOOTH);
		restaurants = new ImageIcon(r);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public class JokeListener implements ActionListener{
		
		int count = 0;
		
		public void actionPerformed(ActionEvent e) {
			joke.setText(jokes[count]);
			count++;
			if(count == jokes.length) {
				count = 0;
			}
		}
	}
	
	public class DisplayListener implements ActionListener{
		
		JComboBox box;
		
		public DisplayListener(JComboBox j) {
			this.box = j;
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(box.getSelectedItem().equals("Attractions")) {
				changeMap(mapPanel, attractions);
				curLocations.setText("Currently Displaying Attractions");
			} else if(box.getSelectedItem().equals("Restaurants")) {
				changeMap(mapPanel, restaurants);
				curLocations.setText("Currently Displaying Restaurants");
			} else if(box.getSelectedItem().equals("Gas Stations")) {
				changeMap(mapPanel, gas);
				curLocations.setText("Currently Displaying Gas Stations");
			}
		}
	}
		
	public void changeMap(JPanel m, ImageIcon i) {
			m.removeAll();
			JLabel mapping = new JLabel(i);
			m.add(mapping);
			m.validate();
			m.repaint();
	}	
}

