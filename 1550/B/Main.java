import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s, a, b));
    }

    sc.close();
  }

  static int solve(String s, int a, int b) {
    int eraseCount;
    if (b >= 0) {
      eraseCount = s.length();
    } else {
      eraseCount = 0;
      int leftIndex = 0;
      int rightIndex = s.length() - 1;
      while (leftIndex <= rightIndex) {
        if (s.charAt(leftIndex) == s.charAt(rightIndex)) {
          while (leftIndex != s.length() - 1 && s.charAt(leftIndex + 1) == s.charAt(leftIndex)) {
            ++leftIndex;
          }
          ++leftIndex;

          while (rightIndex != 0 && s.charAt(rightIndex - 1) == s.charAt(rightIndex)) {
            --rightIndex;
          }
          --rightIndex;
        } else {
          while (leftIndex != s.length() - 1 && s.charAt(leftIndex + 1) == s.charAt(leftIndex)) {
            ++leftIndex;
          }
          ++leftIndex;
        }

        ++eraseCount;
      }
    }

    return s.length() * a + eraseCount * b;
  }
}
