import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, k));
    }

    sc.close();
  }

  static String solve(int n, int k) {
    if (k == n - 1) {
      return "-1";
    }

    StringBuilder[] segments = new StringBuilder[2];
    for (int i = 0; i < segments.length; ++i) {
      segments[i] = new StringBuilder().append(i);
    }

    StringBuilder tail = new StringBuilder();
    for (int i = 0; i < n - k - 2; ++i) {
      tail.append(i % 2);
    }

    for (int i = 0; i < k; ++i) {
      int index = 1 - i % 2;
      segments[index].append(index);
    }

    return "%s%s%s".formatted(segments[0], segments[1], tail);
  }
}