import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();

      System.out.println(solve(x));
    }

    sc.close();
  }

  static int solve(int x) {
    int result = 0;
    int pos = 0;
    while (pos != x && pos <= x + 1) {
      ++result;
      pos += result;
    }

    return result;
  }
}
