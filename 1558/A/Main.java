import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static String solve(int a, int b) {
    if (a > b) {
      return solve(b, a);
    }

    List<Integer> kValues = new ArrayList<>();
    for (int k = a + (a + b) / 2; k >= (a + b) / 2 - a; k -= 2) {
      kValues.add(k);
    }
    if ((a + b) % 2 != 0) {
      for (int k = a + (a + b) / 2 + 1; k >= (a + b) / 2 + 1 - a; k -= 2) {
        kValues.add(k);
      }
    }

    int[] ks = kValues.stream().distinct().sorted().mapToInt(x -> x).toArray();

    return String.format(
        "%d\n%s",
        ks.length, Arrays.stream(ks).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}