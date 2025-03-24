import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    List<String> operations = new ArrayList<>();
    if (Arrays.stream(a).allMatch(ai -> ai != 0)) {
      operations.add("%d %d".formatted(1, a.length));
    } else if (a[0] != 0) {
      operations.add("2 %d".formatted(a.length));
      operations.add("1 2");
    } else if (a[a.length - 1] != 0) {
      operations.add("1 %d".formatted(a.length - 1));
      operations.add("1 2");
    } else {
      operations.add("3 %d".formatted(a.length));
      operations.add("1 2");
      operations.add("1 2");
    }

    return "%d\n%s".formatted(operations.size(), String.join("\n", operations));
  }
}