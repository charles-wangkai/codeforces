import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static long solve(int[] a) {
    if (IntStream.range(1, a.length).anyMatch(i -> a[i] == 1 && a[i - 1] != 1)) {
      return -1;
    }

    int[] actNums = new int[a.length];
    for (int i = 1; i < actNums.length; ++i) {
      actNums[i] = actNums[i - 1];

      long prev = a[i - 1];
      long curr = a[i];
      if (curr >= prev) {
        while (prev != 1 && actNums[i] != 0 && prev * prev <= curr) {
          prev *= prev;
          --actNums[i];
        }
      } else {
        while (curr < prev) {
          curr *= curr;
          ++actNums[i];
        }
      }
    }

    return Arrays.stream(actNums).asLongStream().sum();
  }
}