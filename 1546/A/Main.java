import java.util.ArrayList;
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
    List<Integer> decrementIndices = new ArrayList<>();
    List<Integer> incrementIndices = new ArrayList<>();
    for (int i = 0; i < a.length; ++i) {
      if (a[i] > b[i]) {
        for (int j = 0; j < a[i] - b[i]; ++j) {
          decrementIndices.add(i);
        }
      } else if (a[i] < b[i]) {
        for (int j = 0; j < b[i] - a[i]; ++j) {
          incrementIndices.add(i);
        }
      }
    }

    if (decrementIndices.size() != incrementIndices.size()) {
      return "-1";
    }

    return String.format(
        "%d\n%s",
        decrementIndices.size(),
        IntStream.range(0, decrementIndices.size())
            .mapToObj(
                i ->
                    String.format(
                        "%d %d", decrementIndices.get(i) + 1, incrementIndices.get(i) + 1))
            .collect(Collectors.joining("\n")));
  }
}
