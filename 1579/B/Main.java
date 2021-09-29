import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    List<String> actions = new ArrayList<>();
    for (int i = 0; i < a.length; ++i) {
      int minIndex = i;
      for (int j = i; j < a.length; ++j) {
        if (a[j] < a[minIndex]) {
          minIndex = j;
        }
      }
      if (minIndex != i) {
        actions.add(String.format("%d %d %d", i + 1, a.length, minIndex - i));

        for (int j = 0; j < minIndex - i; ++j) {
          shift(a, i, a.length - 1);
        }
      }
    }

    return String.format("%d\n%s", actions.size(), String.join("\n", actions));
  }

  static void shift(int[] a, int beginIndex, int endIndex) {
    int temp = a[beginIndex];
    for (int i = beginIndex; i < endIndex; ++i) {
      a[i] = a[i + 1];
    }
    a[endIndex] = temp;
  }
}
