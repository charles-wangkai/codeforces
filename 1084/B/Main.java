import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    long s = sc.nextLong();
    int[] v = new int[n];
    for (int i = 0; i < v.length; ++i) {
      v[i] = sc.nextInt();
    }

    System.out.println(solve(v, s));

    sc.close();
  }

  static int solve(int[] v, long s) {
    int result = -1;
    int lower = 0;
    int upper = Arrays.stream(v).min().getAsInt();
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(v, s, middle)) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }

  static boolean check(int[] v, long s, int target) {
    return Arrays.stream(v).map(x -> x - target).asLongStream().sum() >= s;
  }
}