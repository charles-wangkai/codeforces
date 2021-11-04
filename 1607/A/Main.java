import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String keyboard = sc.next();
      String s = sc.next();

      System.out.println(solve(keyboard, s));
    }

    sc.close();
  }

  static int solve(String keyboard, String s) {
    Map<Character, Integer> letterToIndex =
        IntStream.range(0, keyboard.length())
            .boxed()
            .collect(Collectors.toMap(keyboard::charAt, i -> i));

    return IntStream.range(0, s.length() - 1)
        .map(i -> Math.abs(letterToIndex.get(s.charAt(i)) - letterToIndex.get(s.charAt(i + 1))))
        .sum();
  }
}
