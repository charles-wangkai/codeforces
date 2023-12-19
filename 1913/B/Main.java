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

    int length = 0;
    while (length != s.length() && counts[1 - (s.charAt(length) - '0')] != 0) {
      --counts[1 - (s.charAt(length) - '0')];
      ++length;
    }

    return s.length() - length;
  }
}