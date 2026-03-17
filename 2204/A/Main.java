import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static int solve(String s) {
    int n = s.length();

    int index = 0;
    Set<Integer> seen = new HashSet<>();
    seen.add(index);
    for (int i = 0; i < n; ++i) {
      index += (s.charAt(index) == 'L') ? -1 : 1;
      seen.add(index);
    }

    return seen.size();
  }
}