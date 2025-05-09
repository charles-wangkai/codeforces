import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

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
    int[] p = new int[n];
    if (p.length % 2 == 0) {
      Set<Integer> seen = new HashSet<>();
      int index = p.length - 1;
      int power = Integer.highestOneBit(n);
      while (power != 1) {
        index = fill(seen, p, index, power);
        index = fill(seen, p, index, power - 1);

        power /= 2;
      }
      index = fill(seen, p, index, 5);

      for (int i = 1; i <= n; ++i) {
        if (!seen.contains(i)) {
          index = fill(seen, p, index, i);
        }
      }
    } else {
      p[0] = 2;
      p[1] = 1;
      for (int i = 2; i < p.length; ++i) {
        p[i] = i + 1;
      }
    }

    return "%d\n%s"
        .formatted(
            computeK(p),
            Arrays.stream(p).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }

  static int fill(Set<Integer> seen, int[] p, int index, int value) {
    p[index] = value;
    seen.add(value);

    return index - 1;
  }

  static int computeK(int[] p) {
    int result = 0;
    for (int i = 0; i < p.length; ++i) {
      if (i % 2 == 0) {
        result &= p[i];
      } else {
        result |= p[i];
      }
    }

    return result;
  }
}