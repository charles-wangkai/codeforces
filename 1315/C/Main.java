import java.util.Arrays;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(b));
    }

    sc.close();
  }

  static String solve(int[] b) {
    Set<Integer> bSet = Arrays.stream(b).boxed().collect(Collectors.toSet());
    int[] others = IntStream.rangeClosed(1, 2 * b.length).filter(x -> !bSet.contains(x)).toArray();

    int[] bSorted = Arrays.stream(b).sorted().toArray();
    if (IntStream.range(0, bSorted.length).anyMatch(i -> bSorted[i] > others[i])) {
      return "-1";
    }

    NavigableSet<Integer> rests = new TreeSet<>();
    for (int x : others) {
      rests.add(x);
    }

    int[] result = new int[2 * b.length];
    for (int i = 0; i < b.length; ++i) {
      result[i * 2] = b[i];

      result[i * 2 + 1] = rests.higher(b[i]);
      rests.remove(result[i * 2 + 1]);
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
