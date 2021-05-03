import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int[] w = new int[n];
      for (int i = 0; i < w.length; ++i) {
        w[i] = sc.nextInt();
      }

      System.out.println(solve(w, x));
    }

    sc.close();
  }

  static String solve(int[] w, int x) {
    Arrays.sort(w);

    int sum = 0;
    int index = -1;
    while (sum != x && index + 1 != w.length) {
      ++index;
      sum += w[index];
    }

    if (index == w.length - 1) {
      if (sum == x) {
        return "NO";
      }
    } else {
      int temp = w[index];
      w[index] = w[index + 1];
      w[index + 1] = temp;
    }

    return String.format(
        "YES\n%s", Arrays.stream(w).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}
