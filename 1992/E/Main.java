import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(int n) {
    List<String> pairs = new ArrayList<>();
    for (int a = 1; a <= 10000; ++a) {
      String s = String.valueOf(n).repeat(a);
      for (int restLength = 1; restLength <= 7 && restLength < s.length(); ++restLength) {
        int b = s.length() - restLength;
        int value = n * a - b;
        if (b <= 10000
            && String.valueOf(value).length() == restLength
            && s.startsWith(String.valueOf(value))) {
          pairs.add("%d %d".formatted(a, b));
        }
      }
    }

    return "%d\n%s".formatted(pairs.size(), String.join("\n", pairs));
  }
}