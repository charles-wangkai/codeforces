import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();

      System.out.println(solve(n, a, b));
    }

    sc.close();
  }

  static String solve(int n, int a, int b) {
    if (a >= b + 2) {
      return "-1";
    }

    int half = n / 2;

    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    List<Integer> rests = new ArrayList<>();
    for (int i = 1; i <= n; ++i) {
      if (i == a || i > b) {
        left.add(i);
      } else if (i == b || i < a) {
        right.add(i);
      } else {
        rests.add(i);
      }
    }
    if (left.size() > half || right.size() > half) {
      return "-1";
    }

    int restIndex = 0;
    while (left.size() != half) {
      left.add(rests.get(restIndex));
      ++restIndex;
    }
    while (right.size() != half) {
      right.add(rests.get(restIndex));
      ++restIndex;
    }

    return Stream.concat(left.stream(), right.stream())
        .map(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}
