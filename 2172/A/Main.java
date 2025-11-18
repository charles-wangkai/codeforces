import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int g = sc.nextInt();
    int c = sc.nextInt();
    int l = sc.nextInt();

    System.out.println(solve(g, c, l));

    sc.close();
  }

  static String solve(int g, int c, int l) {
    int[] sorted = IntStream.of(g, c, l).sorted().toArray();

    return (sorted[2] - sorted[0] >= 10) ? "check again" : "final %d".formatted(sorted[1]);
  }
}