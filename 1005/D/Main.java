import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static int solve(String s) {
    int result = 0;
    Set<Integer> seen = new HashSet<>();
    seen.add(0);
    int sum = 0;
    for (char c : s.toCharArray()) {
      sum = (sum + (c - '0')) % 3;
      if (seen.contains(sum)) {
        ++result;

        seen.clear();
        seen.add(0);
        sum = 0;
      } else {
        seen.add(sum);
      }
    }

    return result;
  }
}