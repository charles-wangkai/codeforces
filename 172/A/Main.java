import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String[] s = new String[n];
    for (int i = 0; i < s.length; ++i) {
      s[i] = sc.next();
    }

    System.out.println(solve(s));

    sc.close();
  }

  static int solve(String[] s) {
    int result = 0;
    while (check(s, result)) {
      ++result;
    }

    return result;
  }

  static boolean check(String[] s, int index) {
    return Arrays.stream(s).map(si -> si.charAt(index)).distinct().count() == 1;
  }
}