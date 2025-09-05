import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long q = sc.nextLong();

    System.out.println(solve(q));

    sc.close();
  }

  static String solve(long q) {
    List<Long> primes = new ArrayList<>();
    for (int i = 2; (long) i * i <= q; ++i) {
      while (q % i == 0) {
        primes.add((long) i);
        q /= i;
      }
    }
    if (q != 1) {
      primes.add(q);
    }

    if (primes.size() == 2) {
      return "2";
    }

    return "1\n%d".formatted((primes.size() < 2) ? 0 : ((long) primes.get(0) * primes.get(1)));
  }
}