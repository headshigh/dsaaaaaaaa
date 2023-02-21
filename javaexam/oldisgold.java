import javax.swing.Box;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class oldisgold {

  public oldisgold() {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    Box top = Box.createHorizontalBox();
    top.setAlignmentX(Box.CENTER_ALIGNMENT);
    JButton b1 = new JButton("HI");
    top.add(b1);
    Box mid = Box.createHorizontalBox();
    mid.add(new JButton("2"));
    mid.add(new JButton("2"));
    mid.add(new JButton("2"));
    Box b3 = Box.createHorizontalBox();
    b3.add(new JButton("3"));
    panel.add(Box.createHorizontalGlue());
    panel.add(top);
    panel.add(Box.createHorizontalGlue());
    panel.add(mid);
    panel.add(b3);
    frame.setVisible(true);
    frame.add(panel);
    frame.setSize(400, 400);
  }

  public static void main(String[] args) {
    oldisgold o = new oldisgold();
  }
}
