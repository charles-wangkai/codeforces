import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String n = sc.next();

      System.out.println(solve(n) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String n) {
    Set<Integer> dp = Set.of(0);
    for (char c : n.toCharArray()) {
      Set<Integer> nextDp = new HashSet<>();
      for (int prev : dp) {
        nextDp.add((prev + (c - '0')) % 9);

        if (c <= '3') {
          nextDp.add((prev + (c - '0') * (c - '0')) % 9);
        }
      }

      dp = nextDp;
    }

    return dp.contains(0);
  }
}