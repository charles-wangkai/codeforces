import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    long x = sc.nextLong();
    int y = sc.nextInt();

    System.out.println(solve(n, x, y));

    sc.close();
  }

  static String solve(int n, long x, int y) {
    int[] a = IntStream.range(0, n).map(i -> (i == 0) ? (y - (n - 1)) : 1).toArray();

    return (a[0] > 0 && Arrays.stream(a).mapToLong(ai -> (long) ai * ai).sum() >= x)
        ? Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining("\n"))
        : "-1";
  }
}