import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static int solve(String s) {
    Map<Integer, Integer> diffToMinLength = new HashMap<>();
    diffToMinLength.put(0, 0);

    int result = 0;
    int diff = 0;
    for (int i = 0; i < s.length(); ++i) {
      diff += (s.charAt(i) == '1') ? 1 : -1;
      if (diffToMinLength.containsKey(diff)) {
        result = Math.max(result, i + 1 - diffToMinLength.get(diff));
      } else {
        diffToMinLength.put(diff, i + 1);
      }
    }

    return result;
  }
}