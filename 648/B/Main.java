import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n * 2];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static String solve(int[] a) {
    Arrays.sort(a);

    return IntStream.range(0, a.length / 2)
        .mapToObj(i -> String.format("%d %d", a[i], a[a.length - 1 - i]))
        .collect(Collectors.joining("\n"));
  }
}