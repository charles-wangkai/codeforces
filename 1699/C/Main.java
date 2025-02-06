import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final int MODULUS = 1_000_000_007;

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

  static int solve(int[] a) {
    Map<Integer, Integer> valueToIndex =
        IntStream.range(0, a.length).boxed().collect(Collectors.toMap(i -> a[i], i -> i));

    int result = 1;
    int minIndex = valueToIndex.get(0);
    int maxIndex = minIndex;
    int freeNum = 0;
    for (int value = 1; value < valueToIndex.size(); ++value) {
      int index = valueToIndex.get(value);
      if (index < minIndex) {
        freeNum += minIndex - index - 1;
        minIndex = index;
      } else if (index > maxIndex) {
        freeNum += index - maxIndex - 1;
        maxIndex = index;
      } else {
        result = multiplyMod(result, freeNum);
        --freeNum;
      }
    }

    return result;
  }

  static int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }
}