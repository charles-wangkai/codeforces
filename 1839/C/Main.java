import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
    if (a[a.length - 1] == 1) {
      return "NO";
    }

    List<Integer> operations = new ArrayList<>();
    int oneCount = 0;
    for (int i = a.length - 1; i >= -1; --i) {
      if (i == -1 || a[i] == 0) {
        if (oneCount != 0) {
          operations.remove(operations.size() - 1);
          for (int j = 0; j < oneCount; ++j) {
            operations.add(0);
          }
          operations.add(oneCount);

          oneCount = 0;
        }

        if (i != -1) {
          operations.add(0);
        }
      } else {
        ++oneCount;
      }
    }

    return String.format(
        "YES\n%s", operations.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}
