// import DSAw.Bicycle;
// import DSAw.mountainBike;

class Bicycle {

  public int gear;
  public int speed;

  public Bicycle(int gear_val, int speed_val) {
    gear = gear_val;
    speed = speed_val;
  }

  public void applyBrake(int decrement) {
    speed -= decrement;
  }

  public void speedUp(int increment) {
    speed += increment;
  }

  public String toString() {
    return ("No of gears are " + gear + "\n" + "Speed of bicycle is " + speed);
  }
}

class mountainBike extends Bicycle {

  public int seatHeight;

  public mountainBike(int speed_val, int gear_val, int seatheight_val) {
    super(gear_val, speed_val);
    seatHeight = seatheight_val;
  }

  public void setHeight(int newValue) {
    seatHeight = newValue;
  }

  @Override
  public String toString() {
    return (super.toString() + "\n seat height is" + seatHeight);
  }
}

class Test {

  public static void main(String args[]) {
    mountainBike mb = new mountainBike(3, 100, 25);
    System.out.println(mb.toString());
  }
}
