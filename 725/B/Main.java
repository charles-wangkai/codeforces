import java.util.Scanner;

public class Main {
  static final String ORDER = "fedabc";

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String seat = sc.next();

    System.out.println(solve(seat));

    sc.close();
  }

  static long solve(String seat) {
    long n = Long.parseLong(seat.substring(0, seat.length() - 1));
    char s = seat.charAt(seat.length() - 1);

    return (n - 1) / 4 * 16 + (n - 1) % 4 % 2 * 7 + (ORDER.indexOf(s) + 1);
  }
}