import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int l = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();

      System.out.println(solve(l, a, b));
    }

    sc.close();
  }

  static int solve(int l, int a, int b) {
    Set<Integer> seen = new HashSet<>();
    while (!seen.contains(a)) {
      seen.add(a);
      a = (a + b) % l;
    }

    return seen.stream().mapToInt(Integer::intValue).max().getAsInt();
  }
}