import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static long solve(String s) {
    return Math.min(computeOperationNum(s, 'a'), computeOperationNum(s, 'b'));
  }

  static long computeOperationNum(String s, char letter) {
    int[] indices = IntStream.range(0, s.length()).filter(i -> s.charAt(i) == letter).toArray();

    long result = 0;
    for (int left = 0, right = indices.length - 1; left < right; ++left, --right) {
      result += indices[right] - indices[left] - 1 - (right - left - 1);
    }

    return result;
  }
}