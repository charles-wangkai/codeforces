import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, k));

    sc.close();
  }

  static String solve(int[] a, int k) {
    int total = Arrays.stream(a).sum();
    if (total % k != 0) {
      return "No";
    }

    int unit = total / k;
    int[] s = new int[k];
    int rest = unit;
    int index = 0;
    for (int ai : a) {
      if (ai > rest) {
        return "No";
      }

      ++s[index];
      rest -= ai;
      if (rest == 0) {
        rest = unit;
        ++index;
      }
    }

    return "Yes\n%s"
        .formatted(Arrays.stream(s).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}