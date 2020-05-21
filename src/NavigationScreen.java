import java.awt.BorderLayout;
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
import javax.swing.JButton;
import java.awt.Font;

public class NavigationScreen extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	
	private String[] options = {"View Map", "Find Best Route", "Plan a Trip"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NavigationScreen frame = new NavigationScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JLabel nameLabel = new JLabel("Your Name:");
		sl_panel_1.putConstraint(SpringLayout.WEST, nameLabel, 100, SpringLayout.WEST, panel_1);
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel_1.add(nameLabel);
		
		nameField = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.WEST, nameField, 55, SpringLayout.EAST, nameLabel);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, nameField, -460, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, nameField, -320, SpringLayout.EAST, panel_1);
		panel_1.add(nameField);
		nameField.setColumns(10);
		
		JLabel choiceLabel = new JLabel("I want to...");
		sl_panel_1.putConstraint(SpringLayout.NORTH, choiceLabel, 50, SpringLayout.SOUTH, nameLabel);
		sl_panel_1.putConstraint(SpringLayout.WEST, choiceLabel, 0, SpringLayout.WEST, nameLabel);
		choiceLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel_1.add(choiceLabel);
		
		JComboBox screenOptions = new JComboBox(options);
		sl_panel_1.putConstraint(SpringLayout.NORTH, screenOptions, 30, SpringLayout.SOUTH, nameField);
		sl_panel_1.putConstraint(SpringLayout.WEST, screenOptions, 0, SpringLayout.WEST, nameField);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, screenOptions, -330, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, screenOptions, -85, SpringLayout.EAST, panel_1);
		screenOptions.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_1.add(screenOptions);
		
		JButton continueButton = new JButton("Continue");
		sl_panel_1.putConstraint(SpringLayout.NORTH, continueButton, 105, SpringLayout.SOUTH, screenOptions);
		sl_panel_1.putConstraint(SpringLayout.WEST, continueButton, 340, SpringLayout.WEST, panel_1);
		continueButton.setFont(new Font("Tahoma", Font.PLAIN, 40));
		continueButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				if(screenOptions.getSelectedItem().toString().equals("View Map")) {
					dispose();
					new MapScreen();
				} else if(screenOptions.getSelectedItem().toString().equals("Find Best Route")) {
					dispose();
					new OptionScreen();
				} else if(screenOptions.getSelectedItem().toString().equals("Plan a Trip")) {
					dispose();
//					new TripPlannerScreen();
				}
			}

		});
		panel_1.add(continueButton);
		
		JLabel startInstructions = new JLabel("Hello! Enter Your Information Below to Continue:");
		sl_panel_1.putConstraint(SpringLayout.NORTH, nameField, 80, SpringLayout.SOUTH, startInstructions);
		sl_panel_1.putConstraint(SpringLayout.NORTH, nameLabel, 70, SpringLayout.SOUTH, startInstructions);
		sl_panel_1.putConstraint(SpringLayout.NORTH, startInstructions, 25, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, startInstructions, 45, SpringLayout.WEST, panel_1);
		panel_1.add(startInstructions);
		startInstructions.setFont(new Font("Tahoma", Font.PLAIN, 35));
		
		setVisible(true);
		setLocationRelativeTo(null);
		
	}
}
