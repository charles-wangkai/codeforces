import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String a = sc.next();
      String b = sc.next();

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static int solve(String a, String b) {
    return IntStream.range(0, b.length())
        .map(i -> i + computeLength(a, b.substring(i)))
        .min()
        .getAsInt();
  }

  static int computeLength(String a, String subsequence) {
    int index = 0;
    for (char c : a.toCharArray()) {
      if (index != subsequence.length() && c == subsequence.charAt(index)) {
        ++index;
      }
    }

    return a.length() + (subsequence.length() - index);
  }
}