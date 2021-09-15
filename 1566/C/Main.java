import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String row1 = sc.next();
      String row2 = sc.next();

      System.out.println(solve(row1, row2));
    }

    sc.close();
  }

  static int solve(String row1, String row2) {
    int[] sums =
        IntStream.range(0, row1.length())
            .map(i -> (row1.charAt(i) - '0') + (row2.charAt(i) - '0'))
            .toArray();

    int result = 0;
    int index = 0;
    while (index != sums.length) {
      if (sums[index] == 0) {
        if (index != sums.length - 1 && sums[index + 1] == 2) {
          result += 2;
          index += 2;
        } else {
          ++result;
          ++index;
        }
      } else if (sums[index] == 1) {
        result += 2;
        ++index;
      } else {
        if (index != sums.length - 1 && sums[index + 1] == 0) {
          result += 2;
          index += 2;
        } else {
          ++index;
        }
      }
    }

    return result;
  }
}
