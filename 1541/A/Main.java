import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(int n) {
    int[] result = IntStream.rangeClosed(1, n).toArray();

    int beginIndex;
    if (result.length % 2 == 0) {
      beginIndex = 0;
    } else {
      swap(result, 0, 1);
      swap(result, 0, 2);

      beginIndex = 3;
    }

    while (beginIndex != result.length) {
      swap(result, beginIndex, beginIndex + 1);

      beginIndex += 2;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static void swap(int[] a, int index1, int index2) {
    int temp = a[index1];
    a[index1] = a[index2];
    a[index2] = temp;
  }
}
