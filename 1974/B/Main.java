import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String b = sc.next();

      System.out.println(solve(b));
    }

    sc.close();
  }

  static String solve(String b) {
    String r =
        b.chars()
            .distinct()
            .sorted()
            .mapToObj(c -> (char) c)
            .map(String::valueOf)
            .collect(Collectors.joining());
    Map<Character, Character> translation =
        IntStream.range(0, r.length())
            .boxed()
            .collect(Collectors.toMap(r::charAt, i -> r.charAt(r.length() - 1 - i)));

    return b.chars()
        .mapToObj(c -> (char) c)
        .map(translation::get)
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}