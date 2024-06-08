import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    System.out.println(solve(n, m));

    sc.close();
  }

  static String solve(int n, int m) {
    int[] a = new int[m];
    for (int i = 0; i < a.length; ++i) {
      a[i] = n / m + ((i < n % m) ? 1 : 0);
    }

    return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}