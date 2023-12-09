import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int l = sc.nextInt();
      int r = sc.nextInt();
      int s = sc.nextInt();

      System.out.println(solve(n, l, r, s));
    }

    sc.close();
  }

  static String solve(int n, int l, int r, int s) {
    int length = r - l + 1;
    Range[][] ranges = new Range[n + 1][length + 1];
    ranges[0][0] = new Range(0, 0);
    for (int i = 1; i <= n; ++i) {
      for (int j = 0; j <= i && j <= length; ++j) {
        ranges[i][j] = new Range((1 + j) * j / 2, (i + (i - j + 1)) * j / 2);
      }
    }

    if (ranges[n][length].left() > s || ranges[n][length].right() < s) {
      return "-1";
    }

    Set<Integer> chosen = new HashSet<>();
    int restSum = s;
    int restLength = length;
    for (int i = n; i >= 1; --i) {
      if (restLength != 0
          && ranges[n - 1][restLength - 1] != null
          && ranges[n - 1][restLength - 1].left() <= restSum - i
          && ranges[n - 1][restLength - 1].right() >= restSum - i) {
        chosen.add(i);
        restSum -= i;
        --restLength;
      }
    }

    int[] result = new int[n];

    int index = l - 1;
    for (int x : chosen) {
      result[index] = x;
      index = (index + 1) % result.length;
    }

    for (int i = 1; i <= n; ++i) {
      if (!chosen.contains(i)) {
        result[index] = i;
        index = (index + 1) % result.length;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}

record Range(int left, int right) {}
