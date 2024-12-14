import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  static final int MODULUS = 1_000_000_007;

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
    Map<Integer, Integer> diffToLeftSum = new HashMap<>();
    diffToLeftSum.put(0, 1);

    int result = 0;
    int diff = 0;
    for (int i = 0; i < s.length(); ++i) {
      diff += (s.charAt(i) == '0') ? 1 : -1;
      result = addMod(result, multiplyMod(diffToLeftSum.getOrDefault(diff, 0), s.length() - i));

      diffToLeftSum.put(diff, addMod(diffToLeftSum.getOrDefault(diff, 0), i + 2));
    }

    return result;
  }

  static int addMod(int x, int y) {
    return Math.floorMod(x + y, MODULUS);
  }

  static int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }
}