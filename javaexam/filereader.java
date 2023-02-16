import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class filereader {

  public static void main(String[] args) {
    try {
      File newfile = new File("newfile.txt");
      FileReader reader = new FileReader(newfile);
      ///read comtent of newfile and store it into nextfile
      File nextFile = new File("nextfile.txt");
      FileWriter writer = new FileWriter(nextFile);
      int i;
      String s = "";
      while ((i = reader.read()) != -1) {
        s += (char) i;
      }
      writer.write(s);
      System.out.println(s);
      writer.close();
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
