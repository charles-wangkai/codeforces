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
    return (n * (n - 1) / 2 > k)
        ? IntStream.range(0, n).mapToObj(i -> "0 %d".formatted(i)).collect(Collectors.joining("\n"))
        : "no solution";
  }
}