import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String[] types = new String[n];
    int[] values = new int[n];
    for (int i = 0; i < n; ++i) {
      types[i] = sc.next();
      values[i] = sc.nextInt();
    }

    System.out.println(solve(types, values));

    sc.close();
  }

  static String solve(String[] types, int[] values) {
    List<String> result = new ArrayList<>();
    int rest = 0;
    for (int i = 0; i < types.length; ++i) {
      if (types[i].equals("B")) {
        result.add((values[i] > rest) ? "YES" : "NO");
        rest -= Math.min(values[i], rest);
      } else {
        rest += values[i];
      }
    }

    return String.join("\n", result);
  }
}