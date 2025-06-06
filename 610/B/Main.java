import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static long solve(int[] a) {
    int min = Arrays.stream(a).min().getAsInt();

    int[] deltas = IntStream.concat(Arrays.stream(a), Arrays.stream(a)).map(x -> x - min).toArray();

    long result = (long) min * a.length;
    int count = 0;
    for (int delta : deltas) {
      if (delta == 0) {
        count = 0;
      } else {
        ++count;
      }

      result = Math.max(result, (long) min * a.length + count);
    }

    return result;
  }
}