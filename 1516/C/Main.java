import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static String solve(int[] a) {
    Set<Integer> sums = Set.of(0);
    for (int ai : a) {
      Set<Integer> nextSums = new HashSet<>(sums);
      for (int sum : sums) {
        nextSums.add(sum + ai);
      }

      sums = nextSums;
    }

    int total = Arrays.stream(a).sum();
    if (total % 2 != 0 || !sums.contains(total / 2)) {
      return "0";
    }

    while (Arrays.stream(a).allMatch(x -> x % 2 == 0)) {
      for (int i = 0; i < a.length; ++i) {
        a[i] /= 2;
      }
    }

    return String.format(
        "1\n%d", IntStream.range(0, a.length).filter(i -> a[i] % 2 != 0).findAny().getAsInt() + 1);
  }
}
