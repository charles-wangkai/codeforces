import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      String[] bigrams = new String[n - 2];
      for (int i = 0; i < bigrams.length; ++i) {
        bigrams[i] = sc.next();
      }

      System.out.println(solve(bigrams));
    }

    sc.close();
  }

  static String solve(String[] bigrams) {
    boolean inserted = false;
    StringBuilder result = new StringBuilder(bigrams[0]);
    for (int i = 1; i < bigrams.length; ++i) {
      if (result.charAt(result.length() - 1) == bigrams[i].charAt(0)) {
        result.append(bigrams[i].charAt(1));
      } else {
        result.append(bigrams[i]);
        inserted = true;
      }
    }

    if (!inserted) {
      result.append('a');
    }

    return result.toString();
  }
}
