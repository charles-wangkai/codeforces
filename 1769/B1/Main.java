import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

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
    Set<Integer> result = new HashSet<>();
    result.add(0);

    int total = Arrays.stream(a).sum();
    int count = 0;
    for (int ai : a) {
      for (int x = 1; x <= ai; ++x) {
        ++count;

        int percentage1 = 100 * x / ai;
        int percentage2 = 100 * count / total;
        if (percentage1 == percentage2) {
          result.add(percentage1);
        }
      }
    }

    return result.stream()
        .distinct()
        .sorted()
        .map(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}