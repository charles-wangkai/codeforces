import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
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
    int[] result = new int[n];
    Set<Integer> seen = new HashSet<>();
    for (int i = 1; i < result.length - 1; ++i) {
      result[i] = (i + 1) ^ 1;
      seen.add(result[i]);
    }

    int[] notSeen = IntStream.rangeClosed(1, n).filter(x -> !seen.contains(x)).toArray();
    result[result.length - 1] = notSeen[0];
    result[0] = notSeen[1];

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}