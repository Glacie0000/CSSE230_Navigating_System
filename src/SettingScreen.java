import java.awt.Color;
import java.awt.EventQueue;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JToggleButton;
import java.awt.Font;
import javax.swing.JLabel;

public class SettingScreen extends JFrame {
	
	MusicPlayer music;

	public SettingScreen() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		setBounds(100, 100, 300, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(2, 2, 0, 0));
		
		music = new MusicPlayer("images/music.wav");
		
		JLabel musicLabel = new JLabel("Music/Sound");
		musicLabel.setFont(new Font("High Tower Text", Font.BOLD, 15));
		getContentPane().add(musicLabel);
		
		JToggleButton musicToggleButton = new JToggleButton("");
		musicToggleButton.setBackground(Color.BLACK);
		musicToggleButton.setForeground(Color.RED);
		musicToggleButton.setOpaque(true);
		musicToggleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(musicToggleButton.isSelected()) {
					music.play();
				} else {
					music.pause();
				}
			}
		});
		getContentPane().add(musicToggleButton);
		
		JButton backButton = new JButton("BACK");
		backButton.setFont(new Font("High Tower Text", Font.BOLD, 15));
		backButton.setBackground(Color.YELLOW);
		backButton.setBounds(740, 75, 250, 30);
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new NavigationScreen();
			}
		});
		getContentPane().add(backButton);

		setLocationRelativeTo(null);
		setVisible(true);
	}

}
