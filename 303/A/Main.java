import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n));

    sc.close();
  }

  static String solve(int n) {
    if (n % 2 == 0) {
      return "-1";
    }

    int[] a = IntStream.range(0, n).toArray();
    int[] b = IntStream.range(0, n).map(i -> (i + n - 1) % n).toArray();
    int[] c = IntStream.range(0, n).map(i -> (a[i] + b[i]) % n).toArray();

    return "%s\n%s\n%s"
        .formatted(
            Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")),
            Arrays.stream(b).mapToObj(String::valueOf).collect(Collectors.joining(" ")),
            Arrays.stream(c).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}