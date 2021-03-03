import java.util.Scanner;

public class Main {
  static final int[] DELTAS = {1, -1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String a = sc.next();

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String a) {
    for (int A : DELTAS) {
      for (int B : DELTAS) {
        for (int C : DELTAS) {
          if (check(a, A, B, C)) {
            return true;
          }
        }
      }
    }

    return false;
  }

  static boolean check(String a, int A, int B, int C) {
    int depth = 0;
    for (char ch : a.toCharArray()) {
      if (ch == 'A') {
        depth += A;
      } else if (ch == 'B') {
        depth += B;
      } else {
        depth += C;
      }

      if (depth == -1) {
        return false;
      }
    }

    return depth == 0;
  }
}
