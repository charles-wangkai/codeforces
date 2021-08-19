import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int k = sc.nextInt();

      System.out.println(solve(k));
    }

    sc.close();
  }

  static int solve(int k) {
    int result = 0;
    for (int i = 0; i < k; ++i) {
      ++result;
      while (result % 3 == 0 || result % 10 == 3) {
        ++result;
      }
    }

    return result;
  }
}
