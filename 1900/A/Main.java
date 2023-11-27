import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    List<Integer> lengths = new ArrayList<>();
    int length = 0;
    for (int i = 0; i <= s.length(); ++i) {
      if (i != s.length() && s.charAt(i) == '.') {
        ++length;
      } else {
        if (length != 0) {
          lengths.add(length);
        }
        length = 0;
      }
    }

    return lengths.stream().anyMatch(l -> l >= 3) ? 2 : lengths.stream().mapToInt(l -> l).sum();
  }
}