import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    int[] evenIndices = IntStream.range(0, a.length).filter(i -> a[i] % 2 == 0).toArray();
    int[] oddIndices = IntStream.range(0, a.length).filter(i -> a[i] % 2 == 1).toArray();

    if (oddIndices.length >= 3) {
      return String.format(
          "YES\n%d %d %d", oddIndices[0] + 1, oddIndices[1] + 1, oddIndices[2] + 1);
    }
    if (oddIndices.length >= 1 && evenIndices.length >= 2) {
      return String.format(
          "YES\n%d %d %d", oddIndices[0] + 1, evenIndices[0] + 1, evenIndices[1] + 1);
    }

    return "NO";
  }
}
