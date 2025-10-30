import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();

    System.out.println(solve(n, k));

    sc.close();
  }

  static String solve(int n, int k) {
    return (k * n <= n * (n - 1) / 2)
        ? "%d\n%s"
            .formatted(
                k * n,
                IntStream.range(0, n)
                    .boxed()
                    .flatMap(
                        i ->
                            IntStream.rangeClosed(1, k)
                                .mapToObj(d -> "%d %d".formatted(i + 1, (i + d) % n + 1)))
                    .collect(Collectors.joining("\n")))
        : "-1";
  }
}