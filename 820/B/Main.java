import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int a = sc.nextInt();

    System.out.println(solve(n, a));

    sc.close();
  }

  static String solve(int n, int a) {
    return "2 1 %d"
        .formatted(
            IntStream.range(2, n)
                    .boxed()
                    .min(Comparator.comparing(i -> Math.abs(180.0 / n * (i - 1) - a)))
                    .get()
                + 1);
  }
}
