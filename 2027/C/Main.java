import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      long[] a = new long[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextLong();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static long solve(long[] a) {
    Transition[] transitions =
        IntStream.range(0, a.length)
            .mapToObj(i -> new Transition(a[i] + i, i))
            .sorted(Comparator.comparing(Transition::length))
            .toArray(Transition[]::new);

    Set<Long> lengths = new HashSet<>();
    lengths.add((long) a.length);

    for (Transition transition : transitions) {
      if (lengths.contains(transition.length())) {
        lengths.add(transition.length() + transition.addition());
      }
    }

    return lengths.stream().mapToLong(Long::longValue).max().getAsLong();
  }
}

record Transition(long length, int addition) {}
