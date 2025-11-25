import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int m = sc.nextInt();
    String[] expressions = new String[m];
    for (int i = 0; i < expressions.length; ++i) {
      expressions[i] = sc.next();
    }

    System.out.println(solve(expressions));

    sc.close();
  }

  static String solve(String[] expressions) {
    Rational[] rationals =
        Arrays.stream(expressions)
            .map(
                expression -> {
                  int[] fields =
                      Arrays.stream(expression.split("[(+)/]"))
                          .filter(s -> !s.isEmpty())
                          .mapToInt(Integer::parseInt)
                          .toArray();

                  int numerator = fields[0] + fields[1];
                  int denominator = fields[2];
                  int g = gcd(numerator, denominator);

                  return new Rational(numerator / g, denominator / g);
                })
            .toArray(Rational[]::new);

    Map<Rational, Integer> rationalToCount = new HashMap<>();
    for (Rational rational : rationals) {
      rationalToCount.put(rational, rationalToCount.getOrDefault(rational, 0) + 1);
    }

    return Arrays.stream(rationals)
        .mapToInt(rationalToCount::get)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}

record Rational(int numerator, int denominator) {}
