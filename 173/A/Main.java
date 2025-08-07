import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String A = sc.next();
    String B = sc.next();

    System.out.println(solve(n, A, B));

    sc.close();
  }

  static String solve(int n, String A, String B) {
    int[] spotNums = new int[2];

    int base = lcm(A.length(), B.length());
    for (int i = 0; i < base; ++i) {
      int loser = findLoser(A.charAt(i % A.length()), B.charAt(i % B.length()));
      if (loser != -1) {
        ++spotNums[loser];
      }
    }
    for (int i = 0; i < spotNums.length; ++i) {
      spotNums[i] *= n / base;
    }
    for (int i = 0; i < n % base; ++i) {
      int loser = findLoser(A.charAt(i % A.length()), B.charAt(i % B.length()));
      if (loser != -1) {
        ++spotNums[loser];
      }
    }

    return "%d %d".formatted(spotNums[0], spotNums[1]);
  }

  static int lcm(int x, int y) {
    return x / gcd(x, y) * y;
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }

  static int findLoser(char item1, char item2) {
    if (item1 == item2) {
      return -1;
    }

    if (item1 == 'R') {
      return (item2 == 'S') ? 1 : 0;
    }
    if (item1 == 'S') {
      return (item2 == 'P') ? 1 : 0;
    }

    return (item2 == 'R') ? 1 : 0;
  }
}