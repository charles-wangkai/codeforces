import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String S = sc.next();
      String T = sc.next();

      System.out.println(solve(S, T));
    }

    sc.close();
  }

  static int solve(String S, String T) {
    int forwardDiffNum = computeDiffNum(S, T);
    int reverseDiffNum = computeDiffNum(S, new StringBuilder(T).reverse().toString());

    return Math.min(
        forwardDiffNum * 2 - forwardDiffNum % 2,
        (reverseDiffNum == 0) ? 2 : (reverseDiffNum * 2 - (1 - reverseDiffNum % 2)));
  }

  static int computeDiffNum(String str1, String str2) {
    return (int)
        IntStream.range(0, str1.length()).filter(i -> str1.charAt(i) != str2.charAt(i)).count();
  }
}
