import java.util.ArrayList;
import java.util.Arrays;
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
    List<String> permutations = new ArrayList<>();
    int[] a = IntStream.rangeClosed(1, n).toArray();
    for (int i = 0; i < n; ++i) {
      permutations.add(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

      if (i != n - 1) {
        int temp = a[i];
        a[i] = a[i + 1];
        a[i + 1] = temp;
      }
    }

    return String.format("%d\n%s", permutations.size(), String.join("\n", permutations));
  }
}