/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.AudioStream;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;


/**
 *
 * @author Moahmed
 */
public class Audio {
   
    public Audio(){}

    public  void playmusic(String filelocation)
    {
    InputStream music;
    try
    {
    music=new FileInputStream(new File(filelocation));
    AudioStream audio=new AudioStream(music);
    AudioPlayer.player.start(audio);
    }
    catch(Exception e)
    {
    JOptionPane.showMessageDialog(null,"Error");
    }
    }
}
