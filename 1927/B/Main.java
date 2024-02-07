import java.util.Scanner;

public class Main {
  static final int ALPHABET_SIZE = 26;

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
    StringBuilder result = new StringBuilder();
    int[] counts = new int[ALPHABET_SIZE];
    for (int ai : a) {
      for (int i = 0; ; ++i) {
        if (counts[i] == ai) {
          result.append((char) (i + 'a'));
          ++counts[i];

          break;
        }
      }
    }

    return result.toString();
  }
}