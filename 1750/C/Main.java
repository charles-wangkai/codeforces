import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String a = sc.next();
      String b = sc.next();

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static String solve(String a, String b) {
    int n = a.length();

    if (!a.equals(b) && IntStream.range(0, n).anyMatch(i -> a.charAt(i) == b.charAt(i))) {
      return "NO";
    }

    List<String> operations = new ArrayList<>();
    if (b.charAt(0) == '1') {
      operations.add("%d %d".formatted(2, n));
    }
    for (int i = 1; i < b.length(); ++i) {
      if (b.charAt(i) != ((i == 1) ? '0' : b.charAt(i - 1))) {
        operations.add("1 %d".formatted(i));
      }
    }

    if ((a.charAt(0) - '0' + operations.size()) % 2 != b.charAt(0) - '0') {
      operations.add("1 %d".formatted(n));
    }

    return "YES\n%d\n%s".formatted(operations.size(), String.join("\n", operations));
  }
}