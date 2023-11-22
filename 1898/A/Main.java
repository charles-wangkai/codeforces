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

  static String solve(String s, int k) {
    int[] bIndices = IntStream.range(0, s.length()).filter(i -> s.charAt(i) == 'B').toArray();
    if (bIndices.length < k) {
      int[] aIndices = IntStream.range(0, s.length()).filter(i -> s.charAt(i) == 'A').toArray();

      return String.format("1\n%d B", aIndices[k - bIndices.length - 1] + 1);
    }
    if (bIndices.length > k) {
      return String.format("1\n%d A", bIndices[bIndices.length - k - 1] + 1);
    }

    return "0";
  }
}