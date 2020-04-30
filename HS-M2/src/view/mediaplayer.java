package view;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class mediaplayer {
	private Clip clip;
	private AudioInputStream AIS;
	
	public void playsound(String path)
	{
		
		try {
			AIS = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
			 clip = AudioSystem.getClip();
			clip.open(AIS);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException  | LineUnavailableException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	public void stopsound()
	{
		clip.stop();
	}
	public Clip getClip() {
		return clip;
	}
	public AudioInputStream getAIS() {
		return AIS;
	}

}
