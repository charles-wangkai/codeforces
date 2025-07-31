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
    List<Integer> years = new ArrayList<>();
    for (int i = 0; i < a.length; ++i) {
      if (a[i] == years.size() + 1) {
        years.add(2001 + i);
      }
    }

    return "%d\n%s"
        .formatted(
            years.size(), years.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}