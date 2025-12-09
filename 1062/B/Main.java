import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n));

    sc.close();
  }

  static String solve(int n) {
    if (n == 1) {
      return "1 0";
    }

    List<Factor> factors = new ArrayList<>();
    for (int i = 2; i * i <= n; ++i) {
      if (n % i == 0) {
        int exponent = 0;
        while (n % i == 0) {
          ++exponent;
          n /= i;
        }

        factors.add(new Factor(i, exponent));
      }
    }
    if (n != 1) {
      factors.add(new Factor(n, 1));
    }

    return "%d %d"
        .formatted(
            factors.stream().mapToInt(Factor::prime).reduce((acc, x) -> acc * x).getAsInt(),
            computeOperationNum(factors.stream().mapToInt(Factor::exponent).toArray()));
  }

  static int computeOperationNum(int[] exponents) {
    int maxExponent = Arrays.stream(exponents).max().getAsInt();

    int targetExponent = Integer.highestOneBit(maxExponent);
    if (targetExponent != maxExponent) {
      targetExponent <<= 1;
    }

    int targetExponent_ = targetExponent;
    return Integer.numberOfTrailingZeros(targetExponent)
        + (Arrays.stream(exponents).anyMatch(exponent -> exponent != targetExponent_) ? 1 : 0);
  }
}

record Factor(int prime, int exponent) {}
