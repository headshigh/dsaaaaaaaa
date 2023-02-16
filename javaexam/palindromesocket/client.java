package palindromesocket;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class client {

  public static void main(String[] args) {
    try {
      Socket s = new Socket("localhost", 5000);
      DataOutputStream dout = new DataOutputStream(s.getOutputStream());
      DataInputStream din = new DataInputStream(s.getInputStream());
      Scanner inputtaker = new Scanner(System.in);
      String input = "";
      while (true) {
        System.out.println("Enter the String you wanted to check");
        input = inputtaker.next();
        if (input.equalsIgnoreCase("exit")) {
          System.out.println("session terminated");
          break;
        }
      }
      dout.writeUTF(input);
      String output = din.readUTF(); //server le send gareko lai receive garne
      System.out.println(output);
      System.out.println(output);
      dout.close();
      din.close();

      inputtaker.close();
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}
