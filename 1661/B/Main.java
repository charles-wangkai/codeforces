import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
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

  static String solve(int[] a) {
    return Arrays.stream(a)
        .map(Main::computeMinOperationNum)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  static int computeMinOperationNum(int x) {
    return IntStream.range(0, 15)
        .map(
            i -> {
              int oneBit = Integer.lowestOneBit(Math.floorMod(x + i, 32768));

              return i + ((oneBit == 0) ? 0 : (15 - Integer.numberOfTrailingZeros(oneBit)));
            })
        .min()
        .getAsInt();
  }
}