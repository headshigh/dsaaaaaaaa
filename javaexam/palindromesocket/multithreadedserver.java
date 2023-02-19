package palindromesocket;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class ClientHandler extends Thread {

  private Socket socket;

  public ClientHandler(Socket socket) {
    this.socket = socket;
  }

  public void run() {
    try {
      DataInputStream din = new DataInputStream(socket.getInputStream());
      DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
      String input = din.readUTF();
      System.out.println(input);
      String check = "";
      for (int i = 0; i < input.length(); i++) {
        check = input.charAt(i) + check;
      }
      System.out.println("reverse is " + check);
      dout.writeUTF(new String("reverse of the string is" + check));
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}

class MultiThreadingTCPServer {

  public static void main(String[] args) {
    try {
      ServerSocket ss = new ServerSocket(5000);
      System.out.println("server is running");
      while (true) {
        Socket s = ss.accept();
        ClientHandler client_Handler = new ClientHandler(s);
        client_Handler.start();
      }
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}
