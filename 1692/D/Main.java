import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();
      int x = sc.nextInt();

      System.out.println(solve(s, x));
    }

    sc.close();
  }

  static int solve(String s, int x) {
    int result = 0;
    Set<Integer> seen = new HashSet<>();
    int time = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3));
    while (!seen.contains(time)) {
      seen.add(time);

      if (isPalindrome(String.format("%02d:%02d", time / 60, time % 60))) {
        ++result;
      }

      time = (time + x) % 1440;
    }

    return result;
  }

  static boolean isPalindrome(String str) {
    return str.equals(new StringBuilder(str).reverse().toString());
  }
}