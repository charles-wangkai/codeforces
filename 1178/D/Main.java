import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n));

    sc.close();
  }

  static String solve(int n) {
    List<String> edges = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      edges.add("%d %d".formatted(i + 1, (i + 1) % n + 1));
    }

    Set<Integer> seen = new HashSet<>();
    int node = 1;
    while (!isPrime(edges.size())) {
      while (seen.contains(node)) {
        ++node;
      }

      edges.add("%d %d".formatted(node, node + 2));
      seen.add(node);
      seen.add(node + 2);

      ++node;
    }

    return "%d\n%s".formatted(edges.size(), String.join("\n", edges));
  }

  static boolean isPrime(int x) {
    for (int i = 2; i * i <= x; ++i) {
      if (x % i == 0) {
        return false;
      }
    }

    return true;
  }
}