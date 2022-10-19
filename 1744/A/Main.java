import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      String s = sc.next();

      System.out.println(solve(a, s) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, String s) {
    Map<Integer, Character> digitToLetter = new HashMap<>();
    for (int i = 0; i < a.length; ++i) {
      if (digitToLetter.containsKey(a[i]) && digitToLetter.get(a[i]) != s.charAt(i)) {
        return false;
      }

      digitToLetter.put(a[i], s.charAt(i));
    }

    return true;
  }
}
