import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] t = new int[n];
    for (int i = 0; i < t.length; ++i) {
      t[i] = sc.nextInt();
    }

    System.out.println(solve(t));

    sc.close();
  }

  static int solve(int[] t) {
    return IntStream.range(1, t.length).allMatch(i -> t[i] - t[i - 1] == t[1] - t[0])
        ? (t[t.length - 1] + (t[1] - t[0]))
        : t[t.length - 1];
  }
}