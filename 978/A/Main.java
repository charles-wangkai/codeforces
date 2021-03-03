import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; i++) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static String solve(int[] a) {
    List<Integer> uniques = new LinkedList<>();
    for (int i = a.length - 1; i >= 0; --i) {
      if (!uniques.contains(a[i])) {
        uniques.add(0, a[i]);
      }
    }

    return String.format(
        "%d\n%s",
        uniques.size(), uniques.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}
