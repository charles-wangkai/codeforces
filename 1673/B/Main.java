import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();

      System.out.println(solve(s) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(String s) {
    int letterNum = (int) s.chars().distinct().count();

    return IntStream.range(0, letterNum).map(s::charAt).distinct().count() == letterNum
        && IntStream.range(letterNum, s.length())
            .allMatch(i -> s.charAt(i) == s.charAt(i - letterNum));
  }
}