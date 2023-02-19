import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class boxlayout2 extends JFrame {

  public boxlayout2() {
    JFrame frame = new JFrame();
    frame.setSize(400, 400);
    frame.setVisible(true);
    Box box = new Box(BoxLayout.X_AXIS);
    JButton b1 = new JButton("HI");
    JButton b2 = new JButton("HI2");
    box.add(b1);
    box.add(b2);
    frame.add(box);
  }

  public static void main(String[] args) {
    boxlayout2 b = new boxlayout2();
  }
}
