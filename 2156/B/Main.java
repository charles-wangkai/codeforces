import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int q = sc.nextInt();
      String s = sc.next();
      for (int i = 0; i < q; ++i) {
        int a = sc.nextInt();

        System.out.println(solve(s, a));
      }
    }

    sc.close();
  }

  static int solve(String s, int a) {
    if (s.chars().allMatch(c -> c == 'A')) {
      return a;
    }

    int result = 0;
    int index = 0;
    while (a != 0) {
      if (s.charAt(index) == 'A') {
        --a;
      } else {
        a /= 2;
      }

      ++result;
      index = (index + 1) % s.length();
    }

    return result;
  }
}