import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();
    int[] p = new int[k];
    for (int i = 0; i < p.length; ++i) {
      p[i] = sc.nextInt();
    }
    int[][] a = new int[n][m];
    for (int i = 0; i < a.length; ++i) {
      for (int j = 0; j < a[i].length; ++j) {
        a[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(a, p));

    sc.close();
  }

  static int solve(int[][] a, int[] p) {
    int result = 0;
    for (int[] ai : a) {
      for (int aij : ai) {
        int[] p_ = p;
        int index = IntStream.range(0, p.length).filter(i -> p_[i] == aij).findAny().getAsInt();
        result += index + 1;

        p =
            IntStream.concat(
                    IntStream.of(aij),
                    IntStream.range(0, p.length).filter(i -> i != index).map(i -> p_[i]))
                .toArray();
      }
    }

    return result;
  }
}