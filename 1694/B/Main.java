import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String S = sc.next();

      System.out.println(solve(S));
    }

    sc.close();
  }

  static long solve(String S) {
    long result = 0;
    for (int i = 0; i < S.length(); ++i) {
      ++result;
      if ((i != 0 && S.charAt(i) != S.charAt(i - 1))) {
        result += i;
      }
    }

    return result;
  }
}