import java.util.Arrays;
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

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    int typeNum = (int) Arrays.stream(a).distinct().count();

    return IntStream.rangeClosed(1, a.length)
        .map(i -> Math.max(typeNum, i))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}