import javax.swing.Box;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.JPanel;

/////////////////////////////////////////////////////////////
// public class boxlayout extends JFrame {

//   public boxlayout() {
//     JFrame frame = new JFrame();
//     frame.setSize(200, 200);
//     frame.setVisible(true);
//     JPanel jpanel = new JPanel();
//     jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.Y_AXIS));
//     JButton b1 = new JButton("Button 1");
//     JButton b2 = new JButton("Button 1");
//     JButton b3 = new JButton("Button 1");
//     JButton b4 = new JButton("very long button Button 1");
//     jpanel.setAlignmentX(CENTER_ALIGNMENT);
//     jpanel.add(Box.createHorizontalGlue());
//     jpanel.add(b2);
//     jpanel.add(Box.createHorizontalGlue());
//     jpanel.add(b1);
//     jpanel.add(Box.createHorizontalGlue());
//     jpanel.add(b3);
//     jpanel.add(Box.createHorizontalGlue());
//     jpanel.add(b4);
//     jpanel.add(Box.createHorizontalGlue());
//     frame.add(jpanel);
//     pack();
//   }

//   public static void main(String[] args) {
//     boxlayout b = new boxlayout();
//   }
// }
/////////////////////////////////////////////

// public class MyFrame2 extends JFrame {

//   public MyFrame2() {
//     super("My Frame");
//     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//     JPanel panel = new JPanel();
//     panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//     panel.setAlignmentX(CENTER_ALIGNMENT);

//     JButton button1 = new JButton("Button 1");
//     JButton button2 = new JButton("Button 2");

//     panel.add(Box.createHorizontalGlue());
//     panel.add(button1);
//     panel.add(Box.createHorizontalGlue());
//     panel.add(button2);
//     panel.add(Box.createHorizontalGlue());

//     add(panel);

//     pack();
//     setVisible(true);
//   }

//   public static void main(String[] args) {
//     new MyFrame2();
//   }
// }
/////////////////////////////////////////////////////////

public class MyFrame2 extends JFrame {

  public MyFrame2() {
    super("My Frame");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    // create top box
    Box topBox = Box.createVerticalBox();
    // topBox.setAlignmentX(CENTER_ALIGNMENT);
    topBox.add(new JButton("Button 1"));
    // topBox.add(Box.createHorizontalStrut(10)); // add some spacing
    topBox.add(new JButton("Button 2"));
    topBox.add(new JButton("Button 2"));

    // create bottom box
    Box bottomBox = Box.createVerticalBox();
    // bottomBox.setAlignmentX(CENTER_ALIGNMENT);
    bottomBox.add(new JButton("Button  a very long button yar2"));
    // bottomBox.add(Box.createHorizontalStrut(10)); // add some spacing
    // bottomBox.add(new JButton("Button 4"));

    // add the boxes to the panel
    panel.add(topBox);
    panel.add(Box.createHorizontalGlue()); // add some top padding
    // panel.add(Box.createVerticalStrut(20)); // add some spacing between the boxes
    panel.add(bottomBox);
    panel.add(Box.createHorizontalGlue()); // add some bottom padding

    add(panel);

    pack();
    setVisible(true);
  }

  public static void main(String[] args) {
    new MyFrame2();
  }
}
