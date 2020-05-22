import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

public class NavigationScreen extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	
	private ImageIcon logo = new ImageIcon("images/checkered.jpeg");
	
	private String[] options = {"View Map", "Find Best Route", "Plan a Trip"};

	/**
	 * Create the frame.
	 */
	public NavigationScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton settingsButton = new JButton("SETTINGS");
		settingsButton.setBackground(Color.GRAY);
		settingsButton.setOpaque(true);
		settingsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SettingScreen();
			}
		});
		contentPane.add(settingsButton, BorderLayout.NORTH);
		
		JButton exitButton = new JButton("EXIT");
		exitButton.setBackground(Color.RED);
		exitButton.setOpaque(true);
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(exitButton, BorderLayout.SOUTH);
		
		JPanel imagePanel = new JPanel();
		contentPane.add(imagePanel, BorderLayout.WEST);
		
		Image g = logo.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		logo = new ImageIcon(g);
		JLabel logoLabel = new JLabel(logo);
		imagePanel.add(logoLabel);
		
		JPanel screenOptions = new JPanel();
		contentPane.add(screenOptions, BorderLayout.CENTER);
		screenOptions.setLayout(new GridLayout(3,0,0,0));
		
		JButton mapScreen = new JButton("View Map");
		mapScreen.setFont(new Font("High Tower Text", Font.BOLD, 30));
		mapScreen.setBackground(Color.BLACK);
		mapScreen.setForeground(Color.WHITE);
		mapScreen.setOpaque(true);
		mapScreen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MapScreen();
			}
		});
		screenOptions.add(mapScreen);
		
		JButton optionScreen = new JButton("Select Destination");
		optionScreen.setFont(new Font("High Tower Text", Font.BOLD, 30));
		optionScreen.setBackground(Color.WHITE);
		optionScreen.setForeground(Color.BLACK);
		optionScreen.setOpaque(true);
		optionScreen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new OptionScreen();
			}
		});
		screenOptions.add(optionScreen);
		
		JButton tripScreen = new JButton("Plan A Trip");
		tripScreen.setFont(new Font("High Tower Text", Font.BOLD, 30));
		tripScreen.setBackground(Color.BLACK);
		tripScreen.setForeground(Color.WHITE);
		tripScreen.setOpaque(true);
		tripScreen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TripPlannerScreen();
			}
		});
		screenOptions.add(tripScreen);
		
		
		setLocationRelativeTo(null);
		setVisible(true);
		
		
	}
}
