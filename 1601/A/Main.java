import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    int[] counts = new int[30];
    for (int ai : a) {
      for (int i = 0; i < counts.length; ++i) {
        if ((ai & (1 << i)) != 0) {
          ++counts[i];
        }
      }
    }

    return IntStream.rangeClosed(1, a.length)
        .filter(i -> Arrays.stream(counts).allMatch(count -> count % i == 0))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}