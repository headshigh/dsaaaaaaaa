import java.applet.*;
import java.awt.*;

public class Test extends Applet {

  String msg = "";

  public void init() {
    msg = "Hello";
  }

  public void start() {
    msg = msg + ",welcome to the world";
  }

  public void paint(Graphics g) {
    g.drawString(msg, 20, 20);
  }
}
