import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class client {

  public static void main(String[] args) {
    try {
      Socket ss = new Socket("localhost", 5000);
      DataOutputStream dout = new DataOutputStream(ss.getOutputStream());
      dout.writeUTF("fuck fooo");
      dout.flush(); //sends immidiatels
      dout.close();
      ss.close();
    } catch (IOException e) {
      System.out.println(e);
      e.printStackTrace();
    }
  }
}
