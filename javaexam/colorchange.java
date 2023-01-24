import java.awt.*;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.*;
import java.rmi.StubNotFoundException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class colorchange extends Frame {

  colorchange() {
    JFrame frame = new JFrame();

    Button b = new Button("Blue");
    b.setBounds(5, 10, 100, 40);
    frame.setSize(400, 400);

    frame.setVisible(true);

    b.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          frame.getContentPane().setBackground(Color.blue);
          System.out.println("hi");
        }
      }
    );
    frame.add(b);
  }

  public static void main(String[] args) {
    colorchange c = new colorchange();
  }
}
