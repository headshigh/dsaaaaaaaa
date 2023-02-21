import javax.swing.*;

class MyMenu extends JFrame {

  public MyMenu() {
    // Set up the frame
    setSize(300, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a menu bar
    JMenuBar menuBar = new JMenuBar();

    // Create a menu
    JMenu fileMenu = new JMenu("File");

    // Create two menu items
    JMenuItem openItem = new JMenuItem("Open");
    JMenuItem exitItem = new JMenuItem("Exit");

    // Add the menu items to the menu
    fileMenu.add(openItem);
    // fileMenu.addSeparator();
    fileMenu.add(exitItem);

    // Add the menu to the menu bar
    menuBar.add(fileMenu);

    // Set the menu bar for the frame
    setJMenuBar(menuBar);
  }

  public static void main(String[] args) {
    MyMenu menu = new MyMenu();
    menu.setVisible(true);
  }
}
