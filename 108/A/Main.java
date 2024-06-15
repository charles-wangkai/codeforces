import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    int time = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3));
    while (true) {
      time = (time + 1) % 1440;

      String result = String.format("%02d:%02d", time / 60, time % 60);
      if (new StringBuilder(result).reverse().toString().equals(result)) {
        return result;
      }
    }
  }
}