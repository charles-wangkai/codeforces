import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    return Stream.of(
            Arrays.stream(a).filter(x -> x % 6 == 0),
            Arrays.stream(a).filter(x -> x % 6 != 0 && x % 2 == 0),
            Arrays.stream(a).filter(x -> x % 2 != 0 && x % 3 != 0),
            Arrays.stream(a).filter(x -> x % 6 != 0 && x % 3 == 0))
        .flatMapToInt(x -> x)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}