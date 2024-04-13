import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String x = sc.next();
      String y = sc.next();

      System.out.println(solve(x, y));
    }

    sc.close();
  }

  static String solve(String x, String y) {
    StringBuilder value1 = new StringBuilder();
    StringBuilder value2 = new StringBuilder();
    boolean diffFound = false;
    for (int i = 0; i < x.length(); ++i) {
      int min = Math.min(x.charAt(i), y.charAt(i)) - '0';
      int max = Math.max(x.charAt(i), y.charAt(i)) - '0';
      if (min == max || diffFound) {
        value1.append(min);
        value2.append(max);
      } else {
        value1.append(max);
        value2.append(min);

        diffFound = true;
      }
    }

    return String.format("%s\n%s", value1.toString(), value2.toString());
  }
}