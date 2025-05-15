// https://www.socs.uoguelph.ca/~sawada/papers/euclid.pdf

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();

    System.out.println(solve(N, K));

    sc.close();
  }

  static String solve(int N, int K) {
    return buildEString(N, K).stream().map(String::valueOf).collect(Collectors.joining(" "));
  }

  static List<Integer> buildEString(int n, int k) {
    if (k < n) {
      return expand(buildEString(n - k, k));
    }
    if (k > n) {
      return increment(buildEString(n, k - n));
    }

    return List.of(1);
  }

  static List<Integer> expand(List<Integer> values) {
    List<Integer> result = new ArrayList<>();
    for (int x : values) {
      result.add(0);
      for (int i = 0; i < x; ++i) {
        result.add(1);
      }
    }

    return result;
  }

  static List<Integer> increment(List<Integer> values) {
    List<Integer> result = new ArrayList<>();
    for (int x : values) {
      result.add(x + 1);
    }

    return result;
  }
}