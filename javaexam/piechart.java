import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

class PieChartExample extends JPanel {

  private static final long serialVersionUID = 1L;
  private int[] data;
  private Color[] colors;

  public PieChartExample() {
    // Initialize the data and colors for the pie chart
    Random random = new Random();
    data = new int[5];
    colors = new Color[5];
    for (int i = 0; i < data.length; i++) {
      data[i] = random.nextInt(10) + 1;
      colors[i] =
        new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Get the size of the panel

    int width = getWidth();
    int height = getHeight();

    // Calculate the radius and center point of the pie chart
    int radius = (int) (Math.min(width, height) * 0.4);
    int centerX = width / 2;
    int centerY = height / 2;

    // Initialize the start and end angles for each slice
    int startAngle = 0;
    int endAngle = 0;

    // Draw each slice of the pie chart
    for (int i = 0; i < data.length; i++) {
      // Calculate the end angle for this slice
      endAngle = (int) (360 * (double) data[i] / getTotal(data));

      // Set the color for this slice
      g.setColor(colors[i]);

      // Draw the slice
      g.fillArc(
        centerX - radius,
        centerY - radius,
        radius * 2,
        radius * 2,
        startAngle,
        endAngle
      );

      // Update the start angle for the next slice
      startAngle += endAngle;
    }

    // Draw a circle in the center of the pie chart
    g.setColor(Color.white);
    g.fillOval(centerX - radius / 2, centerY - radius / 2, radius, radius);
  }

  private int getTotal(int[] data) {
    int total = 0;
    for (int i = 0; i < data.length; i++) {
      total += data[i];
    }
    return total;
  }

  public static void main(String[] args) {
    // Create a frame and add the pie chart panel to it
    JFrame frame = new JFrame("Pie Chart Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new PieChartExample());
    frame.pack();
    frame.setVisible(true);
  }
}
