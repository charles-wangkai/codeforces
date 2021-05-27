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
    int[] indices = IntStream.range(0, s.length()).filter(i -> s.charAt(i) == '*').toArray();

    long result = 0;
    for (int i = 0, j = indices.length - 1; i < j; ++i, --j) {
      result += (indices[j] - indices[i]) - (j - i);
    }

    return result;
  }
}
