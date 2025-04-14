import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int m = sc.nextInt();
      String program = sc.next();
      int[] l = new int[m];
      int[] r = new int[m];
      for (int i = 0; i < m; ++i) {
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
      }

      System.out.println(solve(program, l, r));
    }

    sc.close();
  }

  static String solve(String program, int[] l, int[] r) {
    int n = program.length();

    int[] leftLasts = new int[n + 1];
    int[] leftMins = new int[n + 1];
    int[] leftMaxs = new int[n + 1];
    for (int i = 1; i <= n; ++i) {
      leftLasts[i] += leftLasts[i - 1] + ((program.charAt(i - 1) == '+') ? 1 : -1);
      leftMins[i] = Math.min(leftMins[i - 1], leftLasts[i]);
      leftMaxs[i] = Math.max(leftMaxs[i - 1], leftLasts[i]);
    }

    int[] rightMins = new int[n + 1];
    int[] rightMaxs = new int[n + 1];
    for (int i = n - 1; i >= 0; --i) {
      if (program.charAt(i) == '+') {
        rightMins[i] = rightMins[i + 1] + 1;
        rightMaxs[i] = rightMaxs[i + 1] + 1;
        if (rightMins[i] == 1) {
          rightMins[i] = 0;
        }
      } else {
        rightMins[i] = rightMins[i + 1] - 1;
        rightMaxs[i] = rightMaxs[i + 1] - 1;
        if (rightMaxs[i] == -1) {
          rightMaxs[i] = 0;
        }
      }
    }

    return IntStream.range(0, l.length)
        .map(
            i -> {
              int min = Math.min(leftMins[l[i] - 1], leftLasts[l[i] - 1] + rightMins[r[i]]);
              int max = Math.max(leftMaxs[l[i] - 1], leftLasts[l[i] - 1] + rightMaxs[r[i]]);

              return max - min + 1;
            })
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}