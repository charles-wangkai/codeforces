import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();

      System.out.println(solve(n, m));
    }

    sc.close();
  }

  static String solve(int n, int m) {
    if (m < n || (n % 2 == 0 && m % 2 != 0)) {
      return "No";
    }

    int[] sequence = new int[n];
    Arrays.fill(sequence, m / n);
    if (n % 2 == 0) {
      sequence[0] += m % n / 2;
      sequence[1] += m % n / 2;
    } else {
      sequence[0] += m % n;
    }

    return String.format(
        "Yes\n%s",
        Arrays.stream(sequence).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}