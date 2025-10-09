import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  static final int MODULUS = 1_000_000_007;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static int solve(String s) {
    List<Integer> segments = new ArrayList<>();
    int segment = 0;
    for (int i = 0; i <= s.length(); ++i) {
      if (i == s.length() || s.charAt(i) == 'b') {
        if (segment != 0) {
          segments.add(segment);
        }

        segment = 0;
      } else if (s.charAt(i) == 'a') {
        ++segment;
      }
    }

    int result = 0;
    for (int seg : segments) {
      result = addMod(result, addMod(multiplyMod(result, seg), seg));
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