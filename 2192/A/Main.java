import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static int solve(String s) {
    return IntStream.range(0, s.length())
        .map(
            i -> {
              String rotated = s.substring(i) + s.substring(0, i);

              return (int)
                  IntStream.range(0, rotated.length())
                      .filter(j -> j == 0 || rotated.charAt(j) != rotated.charAt(j - 1))
                      .count();
            })
        .max()
        .getAsInt();
  }
}