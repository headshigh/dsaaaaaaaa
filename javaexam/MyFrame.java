import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {

  public MyFrame() {
    setVisible(true);
    setSize(700, 700);
  }

  public void paint(Graphics g) {
    g.drawLine(50, 100, 50, 500);
    g.drawPolygon(new int[] { 50, 120, 50 }, new int[] { 100, 200, 300 }, 3);
    g.drawPolygon(new int[] { 50, 120, 50 }, new int[] { 300, 400, 500 }, 3);
    g.setColor(Color.red);
    g.fillPolygon(new int[] { 50, 120, 50 }, new int[] { 300, 400, 500 }, 3);
    g.fillPolygon(new int[] { 50, 120, 50 }, new int[] { 100, 200, 300 }, 3);
  }

  public static void main(String[] args) {
    new MyFrame();
  }
}
