import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

  public static void main(String[] args) {
    try {
      ServerSocket ss = new ServerSocket(10);
      Socket s = ss.accept();
      DataInputStream din = new DataInputStream(s.getInputStream());
      String str = (String) din.readUTF();
      System.out.println(str);
      ss.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
