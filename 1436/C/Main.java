import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int MODULUS = 1_000_000_007;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int x = sc.nextInt();
    int pos = sc.nextInt();

    System.out.println(solve(n, x, pos));

    sc.close();
  }

  static int solve(int n, int x, int pos) {
    int leftCount = x - 1;
    int rightCount = n - 1 - leftCount;

    int result = 1;
    int left = 0;
    int right = n;
    while (left < right) {
      int middle = (left + right) / 2;

      if (middle <= pos) {
        if (middle != pos) {
          result = multiplyMod(result, leftCount);
          --leftCount;
        }

        left = middle + 1;
      } else if (middle > pos) {
        result = multiplyMod(result, rightCount);
        --rightCount;

        right = middle;
      } else {
        break;
      }
    }

    result =
        multiplyMod(
            result, IntStream.rangeClosed(1, leftCount + rightCount).reduce(1, Main::multiplyMod));

    return result;
  }

  static int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }
}
