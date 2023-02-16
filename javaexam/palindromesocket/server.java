package palindromesocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

  public static void main(String[] args) {
    try {
      ServerSocket ss = new ServerSocket(5000);
      Socket s = ss.accept();
      DataInputStream din = new DataInputStream(s.getInputStream());
      DataOutputStream dout = new DataOutputStream(s.getOutputStream());
      String input = din.readUTF();
      System.out.println("Input received: " + input);
      dout.writeUTF(new String("" + checkpalindrome(input)));
      dout.close();
      ss.close();
    } catch (IOException e) {
      System.out.println(e);
    }
  }

  public static Boolean checkpalindrome(String s) {
    String newString = "";
    for (int i = 0; i < s.length(); i++) {
      newString = s.charAt(i) + newString;
    }
    if (newString.equalsIgnoreCase(s)) {
      return true;
    }
    return false;
  }
}
