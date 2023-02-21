public class customexception extends Exception {

  public customexception() {
    super();
  }

  public customexception(String message) {
    super(message);
  }

  public customexception(String message, Throwable cause) {
    super(message, cause);
  }
}

class demo {

  public static void main(String[] args) {
    try {
      throw new customexception("pyaak error");
    } catch (customexception error) {
      System.out.println(error.getMessage());
    }
  }
}
