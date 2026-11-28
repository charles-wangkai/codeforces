import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int t = sc.nextInt();
      for (int tc = 0; tc < t; ++tc) {
        int l = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(solve(l, a, b));
      }
    }
  }

  static int solve(int l, int a, int b) {
    boolean[] aVisited = buildVisited(l, a);
    boolean[] bVisited = buildVisited(l, b);

    return (int) IntStream.range(0, l).filter(i -> aVisited[i] && bVisited[i]).count();
  }

  static boolean[] buildVisited(int l, int step) {
    boolean[] result = new boolean[l];
    int index = 0;
    while (!result[index]) {
      result[index] = true;
      index = (index + step) % result.length;
    }

    return result;
  }
}