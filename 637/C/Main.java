import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String[] promocodes = new String[n];
    for (int i = 0; i < promocodes.length; ++i) {
      promocodes[i] = sc.next();
    }

    System.out.println(solve(promocodes));

    sc.close();
  }

  static int solve(String[] promocodes) {
    int result = promocodes[0].length();
    for (int i = 0; i < promocodes.length; ++i) {
      for (int j = i + 1; j < promocodes.length; ++j) {
        result =
            Math.min(result, Math.max(0, (computeDiffNum(promocodes[i], promocodes[j]) - 1) / 2));
      }
    }

    return result;
  }

  static int computeDiffNum(String s1, String s2) {
    return (int) IntStream.range(0, s1.length()).filter(i -> s1.charAt(i) != s2.charAt(i)).count();
  }
}