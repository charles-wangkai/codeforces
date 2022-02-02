import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static int solve(String s) {
    int[] counts = new int[2];
    for (char c : s.toCharArray()) {
      ++counts[c - '0'];
    }

    return (counts[0] == counts[1]) ? (counts[0] - 1) : Math.min(counts[0], counts[1]);
  }
}