import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int k = sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s, k));
    }

    sc.close();
  }

  static int solve(String s, int k) {
    int[] oneIndices = IntStream.range(0, s.length()).filter(i -> s.charAt(i) == '1').toArray();

    int result = oneIndices.length * 11;
    if (oneIndices.length >= 2
        && oneIndices[0] + (s.length() - 1 - oneIndices[oneIndices.length - 1]) <= k) {
      result -= 11;
    } else if (oneIndices.length >= 1 && s.length() - 1 - oneIndices[oneIndices.length - 1] <= k) {
      result -= 10;
    } else if (oneIndices.length >= 1 && oneIndices[0] <= k) {
      --result;
    }

    return result;
  }
}