import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int b = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, b));

    sc.close();
  }

  static String solve(int[] a, int b) {
    int max = Arrays.stream(a).max().getAsInt();
    if (Arrays.stream(a).map(ai -> max - ai).sum() > b) {
      return "-1";
    }

    double unit = (double) (Arrays.stream(a).sum() + b) / a.length;

    return Arrays.stream(a)
        .mapToDouble(ai -> unit - ai)
        .mapToObj(x -> String.format("%.9f", x))
        .collect(Collectors.joining("\n"));
  }
}