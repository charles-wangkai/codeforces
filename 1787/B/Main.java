import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
    int result = 0;
    Set<Integer> primeFactors = buildPrimeFactors(n);
    while (n != 1) {
      int product = 1;
      for (int primeFactor : primeFactors) {
        if (n % primeFactor == 0) {
          product *= primeFactor;
          n /= primeFactor;
        }
      }

      result += product;
    }

    return result;
  }

  static Set<Integer> buildPrimeFactors(int n) {
    Set<Integer> result = new HashSet<>();
    for (int i = 2; i * i <= n; ++i) {
      if (n % i == 0) {
        result.add(i);

        while (n % i == 0) {
          n /= i;
        }
      }
    }
    if (n != 1) {
      result.add(n);
    }

    return result;
  }
}
