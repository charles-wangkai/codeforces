import java.util.Scanner;

public class Main {
  static final int LIMIT = 300000;
  static final int[] PREFIX_XORS = buildPrefixXors();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int a = sc.nextInt();
      int b = sc.nextInt();

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static int[] buildPrefixXors() {
    int[] prefixXors = new int[LIMIT + 1];
    for (int i = 0; i < prefixXors.length; ++i) {
      prefixXors[i] = i ^ ((i == 0) ? 0 : prefixXors[i - 1]);
    }

    return prefixXors;
  }

  static int solve(int a, int b) {
    if (PREFIX_XORS[a - 1] == b) {
      return a;
    }
    if (PREFIX_XORS[a] == b) {
      return a + 2;
    }

    return a + 1;
  }
}
