import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

// extending Frame class to our class AWTExample1
public class AWTExample1 extends Frame {

  AWTExample1() {
    JFrame frame = new JFrame();
    frame.setSize(400, 400);
    frame.setVisible(true);
    Label firstName = new Label("hi");
    firstName.setBounds(20, 20, 80, 20);
    TextField text = new TextField();
    text.setBounds(0, 10, 300, 20);
    Button reset = new Button("reset");
    reset.setBounds(10, 30, 50, 20);
    frame.add(text);
    frame.add(reset);
    frame.add(firstName);
  }

  public static void main(String[] args) {
    AWTExample1 awt = new AWTExample1();
  }
}
