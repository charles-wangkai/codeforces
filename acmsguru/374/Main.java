import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int k = sc.nextInt();

    System.out.println(solve(a, b, k));

    sc.close();
  }

  static BigInteger solve(int a, int b, int k) {
    List<BigInteger> coeffs = List.of(BigInteger.ONE);
    for (int i = 0; i < k; ++i) {
      List<BigInteger> coeffs_ = coeffs;
      coeffs =
          add(
              coeffs.stream().map(coeff -> coeff.multiply(BigInteger.valueOf(b))).toList(),
              IntStream.range(0, coeffs.size() + 1)
                  .mapToObj(
                      j ->
                          (j == 0)
                              ? BigInteger.ZERO
                              : coeffs_.get(j - 1).multiply(BigInteger.valueOf(a)))
                  .toList());
    }

    return coeffs.stream().reduce((acc, x) -> acc.add(x)).get();
  }

  static List<BigInteger> add(List<BigInteger> coeffs1, List<BigInteger> coeffs2) {
    return IntStream.range(0, Math.max(coeffs1.size(), coeffs2.size()))
        .mapToObj(
            i ->
                ((i < coeffs1.size()) ? coeffs1.get(i) : BigInteger.ZERO)
                    .add((i < coeffs2.size()) ? coeffs2.get(i) : BigInteger.ZERO))
        .toList();
  }
}
