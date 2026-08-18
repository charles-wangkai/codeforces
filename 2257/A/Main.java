import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      String[] w = new String[n];
      for (int i = 0; i < w.length; ++i) {
        w[i] = sc.next();
      }
      String[] a = new String[m];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.next();
      }

      System.out.println(solve(w, a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String[] w, String[] a) {
    Set<Character> firstLetters =
        Arrays.stream(w).map(wi -> wi.charAt(0)).collect(Collectors.toSet());

    return Arrays.stream(a)
        .allMatch(
            ai -> ai.chars().allMatch(c -> firstLetters.contains((char) Character.toLowerCase(c))));
  }
}