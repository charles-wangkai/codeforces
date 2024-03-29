import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    int hour = Integer.parseInt(s.substring(0, 2));
    int minute = Integer.parseInt(s.substring(3));

    return String.format(
        "%02d:%02d %s", (hour % 12 == 0) ? 12 : (hour % 12), minute, (hour < 12) ? "AM" : "PM");
  }
}