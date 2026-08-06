import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String a = sc.next();
      String b = sc.next();

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static long solve(String a, String b) {
    long operationNum0 = computeoperationNum(a, b, 0);
    long operationNum1 = computeoperationNum(a, b, 1);

    return (operationNum0 == -1 || operationNum1 == -1) ? -1 : (operationNum0 + operationNum1);
  }

  static long computeoperationNum(String a, String b, int remainder) {
    int[] aIndices =
        IntStream.range(0, a.length())
            .filter(i -> i % 2 == remainder && a.charAt(i) == '0')
            .map(i -> i / 2)
            .toArray();
    int[] bIndices =
        IntStream.range(0, b.length())
            .filter(i -> i % 2 == remainder && b.charAt(i) == '0')
            .map(i -> i / 2)
            .toArray();

    return (aIndices.length == bIndices.length)
        ? IntStream.range(0, aIndices.length)
            .map(i -> Math.abs(aIndices[i] - bIndices[i]))
            .asLongStream()
            .sum()
        : -1;
  }
}