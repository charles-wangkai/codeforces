import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String square = sc.next();

      System.out.println(solve(square));
    }

    sc.close();
  }

  static String solve(String square) {
    return Stream.concat(
            IntStream.rangeClosed('1', '8')
                .filter(c -> c != square.charAt(1))
                .mapToObj(c -> String.format("%c%c", square.charAt(0), c)),
            IntStream.rangeClosed('a', 'h')
                .filter(c -> c != square.charAt(0))
                .mapToObj(c -> String.format("%c%c", c, square.charAt(1))))
        .collect(Collectors.joining("\n"));
  }
}