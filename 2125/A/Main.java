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
    return s.replaceAll("[FN]", "")
        + "F".repeat((int) s.chars().filter(c -> c == 'F').count())
        + "N".repeat((int) s.chars().filter(c -> c == 'N').count());
  }
}