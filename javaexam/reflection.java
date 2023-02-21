import java.lang.reflect.Constructor;

class reflection {

  public static void main(String[] args) {
    Class<?> hi = reflection.class;
    Constructor<?> constructor = hi.getConstructor(String.class);

    System.out.println(hi.toString());
  }
}
