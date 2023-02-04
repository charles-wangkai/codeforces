import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      char c = sc.next().charAt(0);

      System.out.println(solve(c) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(char c) {
    return "codeforces".indexOf(c) >= 0;
  }
}
