import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int k = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s, k));
    }

    sc.close();
  }

  static int solve(String s, int k) {
    int result = 0;
    int index = 0;
    while (index < s.length()) {
      if (s.charAt(index) == 'B') {
        ++result;
        index += k;
      } else {
        ++index;
      }
    }

    return result;
  }
}
