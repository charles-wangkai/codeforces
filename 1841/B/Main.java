import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int q = sc.nextInt();
      int[] x = new int[q];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
      }

      System.out.println(solve(x));
    }

    sc.close();
  }

  static String solve(int[] x) {
    char[] result = new char[x.length];
    boolean lessFound = false;
    int first = x[0];
    int last = x[0];
    for (int i = 0; i < result.length; ++i) {
      if (lessFound) {
        if (x[i] <= first && x[i] >= last) {
          result[i] = '1';
          last = x[i];
        } else {
          result[i] = '0';
        }
      } else {
        if (x[i] >= last || x[i] <= first) {
          if (x[i] < last) {
            lessFound = true;
          }

          result[i] = '1';
          last = x[i];
        } else {
          result[i] = '0';
        }
      }
    }

    return new String(result);
  }
}
