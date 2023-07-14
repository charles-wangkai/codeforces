import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws Throwable {
    Scanner sc = new Scanner(new File("input.txt"));
    PrintWriter out = new PrintWriter("output.txt");

    int n = sc.nextInt();
    int[] c = new int[n];
    for (int i = 0; i < c.length; ++i) {
      c[i] = sc.nextInt();
    }

    out.println(solve(c));

    out.close();
    sc.close();
  }

  static int solve(int[] c) {
    Arrays.sort(c);

    int result = Integer.MAX_VALUE;
    int endIndex = 0;
    for (int i = 0; i < c.length; ++i) {
      while (endIndex != c.length - 1 && c[endIndex + 1] <= 2 * c[i]) {
        ++endIndex;
      }

      result = Math.min(result, c.length - (endIndex - i + 1));
    }

    return result;
  }
}
