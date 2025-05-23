import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static String solve(int[] a) {
    if (Arrays.stream(a).allMatch(ai -> ai == 1)) {
      return IntStream.range(0, a.length)
          .map(i -> (i == a.length - 1) ? 2 : 1)
          .mapToObj(String::valueOf)
          .collect(Collectors.joining(" "));
    }

    Arrays.sort(a);

    return IntStream.range(0, a.length)
        .map(i -> (i == 0) ? 1 : a[i - 1])
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}