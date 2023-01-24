import java.awt.*;
import java.awt.Frame;
import java.awt.event.*;
import javax.swing.JFrame;

public class sumoftwofeilds extends Frame {

  sumoftwofeilds() {
    JFrame frame = new JFrame();
    TextField t1 = new TextField();
    TextField t2 = new TextField();
    t1.setBounds(0, 30, 200, 40);
    t2.setBounds(0, 80, 200, 40);
    Button b = new Button("ADD");
    b.setBounds(110, 220, 60, 40);
    Label newl = new Label("Sum: ");
    newl.setBounds(110, 120, 40, 40);

    frame.setVisible(true);
    frame.add(t1);
    frame.add(t2);
    frame.add(b);
    frame.add(newl);
    frame.setSize(400, 400);
    b.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          int a = Integer.parseInt(t1.getText());
          int b = Integer.parseInt(t2.getText());
          int c = a + b;
          newl.setText("sum" + String.valueOf(c));
          Dialog d = new Dialog(frame);
          d.setSize(300, 300);
          d.add(newl);
          d.setVisible(true);
        }
      }
    );
  }

  public static void main(String[] args) {
    sumoftwofeilds s = new sumoftwofeilds();
  }
}
