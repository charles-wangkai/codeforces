import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String time = sc.next();

    System.out.println(solve(time));

    sc.close();
  }

  static String solve(String time) {
    int hour = Integer.parseInt(time.substring(0, 2));
    int minute = Integer.parseInt(time.substring(3));

    double hourAngle = (hour % 12 + minute / 60.0) * (360 / 12);
    double minuteAngle = minute * (360 / 60);

    return "%.9f %.9f".formatted(hourAngle, minuteAngle);
  }
}