import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static String solve(int[] a, int[] b) {
    List<String> moves = new ArrayList<>();
    while (true) {
      boolean changed = false;
      for (int i = 0; i < a.length - 1; ++i) {
        if (a[i] >= a[i + 1] && b[i] >= b[i + 1] && !(a[i] == a[i + 1] && b[i] == b[i + 1])) {
          moves.add(String.format("%d %d", i + 1, i + 2));

          swap(a, i, i + 1);
          swap(b, i, i + 1);

          changed = true;
        }
      }

      if (!changed) {
        break;
      }
    }

    return IntStream.range(0, a.length - 1).allMatch(i -> a[i] <= a[i + 1] && b[i] <= b[i + 1])
        ? String.format("%d\n%s", moves.size(), String.join("\n", moves))
        : "-1";
  }

  static void swap(int[] x, int index1, int index2) {
    int temp = x[index1];
    x[index1] = x[index2];
    x[index2] = temp;
  }
}