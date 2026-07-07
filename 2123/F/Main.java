import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
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

  static String solve(int n) {
    int[] primes =
        Arrays.stream(buildPrimes(n))
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    int[] result = new int[n];
    result[0] = 1;

    boolean[] visited = new boolean[n + 1];
    for (int prime : primes) {
      List<Integer> multiples = new ArrayList<>();
      for (int i = prime; i <= n; i += prime) {
        if (!visited[i]) {
          visited[i] = true;
          multiples.add(i);
        }
      }

      for (int i = 0; i < multiples.size(); ++i) {
        result[multiples.get(i) - 1] = multiples.get((i + 1) % multiples.size());
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static int[] buildPrimes(int n) {
    boolean[] primes = new boolean[n + 1];
    Arrays.fill(primes, true);

    for (int i = 2; i < primes.length; ++i) {
      if (primes[i]) {
        for (int j = i * 2; j < primes.length; j += i) {
          primes[j] = false;
        }
      }
    }

    return IntStream.range(2, primes.length).filter(i -> primes[i]).toArray();
  }
}