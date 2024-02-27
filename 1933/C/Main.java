import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int l = sc.nextInt();

      System.out.println(solve(a, b, l));
    }

    sc.close();
  }

  static int solve(int a, int b, int l) {
    Set<Integer> ks = new HashSet<>();
    for (int pa = 1; l % pa == 0; pa *= a) {
      for (int pb = 1; l / pa % pb == 0; pb *= b) {
        ks.add(l / pa / pb);
      }
    }

    return ks.size();
  }
}