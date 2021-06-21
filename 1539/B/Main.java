import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int q = sc.nextInt();
    String s = sc.next();
    int[] l = new int[q];
    int[] r = new int[q];
    for (int i = 0; i < q; ++i) {
      l[i] = sc.nextInt();
      r[i] = sc.nextInt();
    }

    System.out.println(solve(l, r, s));

    sc.close();
  }

  static String solve(int[] l, int[] r, String s) {
    int[] prefixSums = new int[s.length() + 1];
    for (int i = 1; i < prefixSums.length; ++i) {
      prefixSums[i] = prefixSums[i - 1] + (s.charAt(i - 1) - 'a' + 1);
    }

    return IntStream.range(0, l.length)
        .mapToObj(i -> String.valueOf(prefixSums[r[i]] - prefixSums[l[i] - 1]))
        .collect(Collectors.joining("\n"));
  }
}
