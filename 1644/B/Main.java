import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    List<String> result = new ArrayList<>();
    if (n == 3) {
      result.add("3 2 1");
      result.add("3 1 2");
      result.add("1 3 2");
    } else {
      for (int i = 1; i <= n; ++i) {
        int i_ = i;
        result.add(
            IntStream.concat(
                    IntStream.range(0, i).map(j -> i_ - j),
                    IntStream.range(0, n - i).map(j -> n - j))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
      }
    }

    return String.join("\n", result);
  }
}