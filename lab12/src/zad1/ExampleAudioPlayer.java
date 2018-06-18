package zad1;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 * This is an example program that demonstrates how to play back an audio file
 * using the Clip in Java Sound API.
 * based on example from  www.codejava.net
 */

public class ExampleAudioPlayer extends JFrame implements LineListener, ActionListener {
     
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String audioFilePath = "";
	String inFileName;
	Clip audioClip = null;
	File audioFile = null;
	AudioInputStream audioStream = null;
	
	JButton openFile;
	JButton play;
	JButton pause;
	JButton reasume;
	JButton stop;
	
	boolean playing = true;
	long clipTime;
	
    boolean playCompleted = false;
    
    Thread thread;
	
    ExampleAudioPlayer(){
    	setSize(600,400);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	this.setLayout(new FlowLayout());
    	
    	openFile = new JButton("Open File");
    	play = new JButton("Play");
    	pause = new JButton("Pause");
    	reasume = new JButton("Reasume");
    	stop = new JButton("Stop");
    	
    
    	openFile.addActionListener(this);
    	play.addActionListener(this);
    	pause.addActionListener(this);
    	reasume.addActionListener(this);
    	stop.addActionListener(this);
    	
    	this.add(openFile);
    	this.add(play);
    	this.add(pause);
    	this.add(reasume);
    	this.add(stop);
    }
    
  
    /**
     * Play a given audio file.
     * @param audioFilePath Path of the audio file.
     */
    void play(String audioFilePath) {
    	
        try {
            
            
            /**
             *  Play the audio clip in a new thread not to block the GUI.
             *  It helps in this case, but is not really necessary. 
             */
            
            if (playing == true) {
            		audioFile = new File(audioFilePath);
            		audioStream = AudioSystem.getAudioInputStream(audioFile);
            		AudioFormat format = audioStream.getFormat();
            		DataLine.Info info = new DataLine.Info(Clip.class, format);
            		audioClip = (Clip) AudioSystem.getLine(info);
            		audioClip.addLineListener(this);
            		audioClip.open(audioStream);

            		thread = new Thread(() -> {
            			audioClip.start();
            			playing = false;	
     	            while(!playCompleted){
     	                	            	
     	            }
     	            audioClip.close();

     	            try {
     	            		audioStream.close();
     	            		playing = true;
 					} catch (IOException e) {
 						e.printStackTrace();
 					}      
            		});
            		thread.start();
            }
            
            if (playing == false) {
            		JOptionPane.showMessageDialog(null, "Wait untill audio ends.");
            }
       
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        } catch (IOException e1) {
            System.out.println("Error playing the audio file.");
			e1.printStackTrace();
		} 
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == openFile) {
			JFileChooser fc = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("AUDIO FILES", "wav", "mp3");
			fc.setFileFilter(filter);
			fc.showDialog(null, "Open");
			inFileName = fc.getSelectedFile().getAbsolutePath();
			System.out.println(inFileName);
		}
		if (ob == play) {
			this.play(inFileName);
		}
		if (ob == pause) {
			clipTime = audioClip.getMicrosecondPosition();
			audioClip.stop();
			playing = true;
		}
		if (ob == reasume) {
			playing = false;
			audioClip.setMicrosecondPosition(clipTime);
			audioClip.start();
		}
		if (ob == stop) {
			audioClip.stop();
			audioClip.close();
			try {
				audioStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			playCompleted = false;
			playing = true;
		}
		
	}
     
    /**
     * Listens to the START and STOP events of the audio line.
     */
    @Override
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();
         
        if (type == LineEvent.Type.START) {
            System.out.println("Playback started.");
             
        } 
        else if (type == LineEvent.Type.STOP) {
            playCompleted = true;
            System.out.println("Playback completed.");
        }
 
    }
 
    public static void main(String[] args) {
    	
    	 SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				new ExampleAudioPlayer().setVisible(true);
			}
		});
    }
 
}

