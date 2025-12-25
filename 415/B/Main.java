import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int[] x = new int[n];
    for (int i = 0; i < x.length; ++i) {
      x[i] = sc.nextInt();
    }

    System.out.println(solve(x, a, b));

    sc.close();
  }

  static String solve(int[] x, int a, int b) {
    return Arrays.stream(x)
        .map(xi -> xi - (int) Math.ceilDiv((long) xi * a / b * b, a))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}