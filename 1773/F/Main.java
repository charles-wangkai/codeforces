import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();

    System.out.println(solve(n, a, b));

    sc.close();
  }

  static String solve(int n, int a, int b) {
    int[] scored = new int[n];
    int[] conceded = new int[n];
    for (int i = 0; i < n; ++i) {
      if (i == n - 1) {
        scored[i] = a;
        conceded[i] = b;
      } else if (a < b) {
        if (a == 0) {
          scored[i] = 0;
          conceded[i] = 1;
        } else {
          scored[i] = 1;
          conceded[i] = 0;
        }
      } else if (a > b) {
        if (b == 0) {
          scored[i] = 1;
          conceded[i] = 0;
        } else {
          scored[i] = 0;
          conceded[i] = 1;
        }
      } else if (a == 0) {
        scored[i] = 0;
        conceded[i] = 0;
      } else {
        scored[i] = 1;
        conceded[i] = 0;
      }

      a -= scored[i];
      b -= conceded[i];
    }

    return String.format(
        "%d\n%s",
        IntStream.range(0, n).filter(i -> scored[i] == conceded[i]).count(),
        IntStream.range(0, n)
            .mapToObj(i -> String.format("%d:%d", scored[i], conceded[i]))
            .collect(Collectors.joining("\n")));
  }
}