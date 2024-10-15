import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final int MODULUS = 1_000_000_007;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    int[] n = new int[t];
    for (int i = 0; i < n.length; ++i) {
      n[i] = sc.nextInt();
    }
    int[] k = new int[t];
    for (int i = 0; i < k.length; ++i) {
      k[i] = sc.nextInt();
    }

    System.out.println(solve(n, k));

    sc.close();
  }

  static String solve(int[] n, int[] k) {
    return IntStream.range(0, n.length)
        .map(
            i ->
                (k[i] == n[i])
                    ? 1
                    : BigInteger.valueOf(2)
                        .modPow(BigInteger.valueOf(k[i]), BigInteger.valueOf(MODULUS))
                        .intValue())
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}