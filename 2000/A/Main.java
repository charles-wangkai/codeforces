import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int a) {
    String s = String.valueOf(a);

    return s.length() >= 3
        && s.startsWith("10")
        && s.charAt(2) != '0'
        && Integer.parseInt(s.substring(2)) >= 2;
  }
}