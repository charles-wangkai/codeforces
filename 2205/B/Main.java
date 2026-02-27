import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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

  static int solve(int n) {
    return buildTerms(n).stream()
        .mapToInt(term -> pow(term.prime(), Math.ceilDiv(term.exponent(), n)))
        .reduce(1, (acc, x) -> acc * x);
  }

  static List<Term> buildTerms(int n) {
    List<Term> result = new ArrayList<>();
    for (int i = 2; i * i <= n; ++i) {
      int exponent = 0;
      while (n % i == 0) {
        ++exponent;
        n /= i;
      }

      if (exponent != 0) {
        result.add(new Term(i, exponent));
      }
    }
    if (n != 1) {
      result.add(new Term(n, 1));
    }

    return result;
  }

  static int pow(int base, int exponent) {
    return IntStream.range(0, exponent).reduce(1, (acc, x) -> acc * base);
  }
}

record Term(int prime, int exponent) {}
