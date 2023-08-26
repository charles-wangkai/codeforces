import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(b));
    }

    sc.close();
  }

  static String solve(int[] b) {
    List<Integer> result = new ArrayList<>();
    result.add(b[0]);
    for (int i = 1; i < b.length; ++i) {
      if (b[i] < b[i - 1]) {
        result.add(b[i]);
      }
      result.add(b[i]);
    }

    return String.format(
        "%d\n%s",
        result.size(), result.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}
