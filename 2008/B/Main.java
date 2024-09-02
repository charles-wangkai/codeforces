import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(String s) {
    int size = (int) Math.round(Math.sqrt(s.length()));

    return size * size == s.length()
        && IntStream.range(0, s.length())
            .allMatch(
                i -> {
                  int r = i / size;
                  int c = i % size;

                  return s.charAt(i)
                      == ((r == 0 || r == size - 1 || c == 0 || c == size - 1) ? '1' : '0');
                });
  }
}