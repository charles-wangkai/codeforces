import java.util.OptionalInt;
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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b) {
    int result = 0;
    for (int i = 0; i < a.length; ++i) {
      int i_ = i;
      OptionalInt index = IntStream.range(i, a.length).filter(j -> a[j] <= b[i_]).findFirst();
      if (index.isEmpty()) {
        return -1;
      }

      for (int j = index.getAsInt(); j > i; --j) {
        int temp = a[j];
        a[j] = a[j - 1];
        a[j - 1] = temp;

        ++result;
      }
    }

    return result;
  }
}