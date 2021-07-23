import java.util.Arrays;
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
    int[] counts = new int[26];
    for (char ch : s.toCharArray()) {
      ++counts[ch - 'a'];
    }

    int oneCount = (int) Arrays.stream(counts).filter(count -> count == 1).count();
    int moreCounts = (int) Arrays.stream(counts).filter(count -> count >= 2).count();

    return moreCounts + oneCount / 2;
  }
}
