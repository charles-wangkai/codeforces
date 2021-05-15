import java.util.ArrayList;
import java.util.Comparator;
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

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    int minIndex = IntStream.range(0, a.length).boxed().min(Comparator.comparing(i -> a[i])).get();

    List<String> operations = new ArrayList<>();
    for (int i = 0; i < a.length; ++i) {
      if (i != minIndex) {
        operations.add(
            String.format(
                "%d %d %d %d",
                i + 1, minIndex + 1, a[minIndex] + Math.abs(i - minIndex), a[minIndex]));
      }
    }

    return String.format("%d\n%s", operations.size(), String.join("\n", operations));
  }
}
