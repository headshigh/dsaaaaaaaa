import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.*;
import javax.swing.*;

public class Music extends Applet implements ActionListener {

  ImageIcon pause, play, stop, replay;
  long current;
  Clip clip;

  //Initialize the applet
  public void init() {
    setBackground(Color.white);
    //Create image icons for the buttons
    pause = new ImageIcon("icon_pause.png");
    play = new ImageIcon("icon_play.png");
    stop = new ImageIcon("icon_stop.png");
    replay = new ImageIcon("icon_replay.png");
  }

  //Add buttons to applet and load the sound
  public void start() {
    JButton b_pause = new JButton(pause);
    this.add(b_pause);
    b_pause.addActionListener(this);

    JButton b_play = new JButton(play);
    this.add(b_play);
    b_play.addActionListener(this);

    JButton b_stop = new JButton(stop);
    this.add(b_stop);
    b_stop.addActionListener(this);

    JButton b_replay = new JButton(replay);
    this.add(b_replay);
    b_replay.addActionListener(this);

    try {
      AudioInputStream audio;
      File file = new File("sound.wav");
      audio = AudioSystem.getAudioInputStream(file);
      clip = AudioSystem.getClip();
      clip.open(audio);
      current = 0L;
    } catch (Exception E) {
      System.out.println(E.getMessage());
    }
  }

  //Function to perform the selected option
  public void actionPerformed(ActionEvent e) {
    String icon = ((JButton) e.getSource()).getIcon().toString();

    if (icon.equals(pause.toString())) {
      current = clip.getMicrosecondPosition();
      clip.stop();
    } else if (icon.equals(play.toString())) {
      clip.setMicrosecondPosition(current);
      clip.start();
    } else if (icon.equals(stop.toString())) {
      current = 0L;
      clip.setMicrosecondPosition(0);
      clip.stop();
    } else {
      current = 0L;
      clip.setMicrosecondPosition(0);
      clip.start();
    }
  }
}
