import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int X = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, X));
    }

    sc.close();
  }

  static String solve(int[] a, int X) {
    Arrays.sort(a);

    long bonus = 0;
    List<Integer> prices = new ArrayList<>();
    int leftIndex = 0;
    int rightIndex = a.length - 1;
    int remainder = 0;
    while (leftIndex <= rightIndex) {
      if (remainder + a[rightIndex] >= X) {
        prices.add(a[rightIndex]);
        remainder = (remainder + a[rightIndex]) % X;
        bonus += a[rightIndex];
        --rightIndex;
      } else {
        prices.add(a[leftIndex]);
        remainder += a[leftIndex];
        ++leftIndex;
      }
    }

    return "%d\n%s"
        .formatted(bonus, prices.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}