import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
    List<Integer> b = new ArrayList<>();
    int count = 0;
    int negative = 0;
    for (int i = 0; i <= a.length; ++i) {
      if (i == a.length || (a[i] < 0 && negative == 2)) {
        b.add(count);
        count = 0;
        negative = 0;
      }

      if (i != a.length) {
        ++count;
        if (a[i] < 0) {
          ++negative;
        }
      }
    }

    return String.format(
        "%d\n%s", b.size(), b.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}