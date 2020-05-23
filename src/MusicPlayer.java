import java.io.File; 
import java.io.IOException; 
import java.util.Scanner; 

import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 

public class MusicPlayer { 
	AudioInputStream audioInputStream; 
	Long currentFrame; 
	Clip clip;  
	
	boolean isPlaying;
	static String filePath; 
	
	
	public MusicPlayer(String f) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		filePath = f;
		audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile()); 
		
		clip = AudioSystem.getClip(); 
		clip.open(audioInputStream); 
		clip.loop(Clip.LOOP_CONTINUOUSLY); 
	} 
	
	public void play() {
		clip.start(); 
		isPlaying = true; 
	} 
	
	public void pause(){ 
		if (!isPlaying) {
			return; 
		} 
		this.currentFrame = 
		this.clip.getMicrosecondPosition(); 
		clip.stop(); 
		isPlaying = false; 
	} 
	

} 
