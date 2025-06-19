import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final char[] COLORS = {'B', 'G', 'R'};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    return IntStream.range(0, COLORS.length)
        .filter(i -> check(s, i))
        .mapToObj(i -> COLORS[i])
        .map(String::valueOf)
        .collect(Collectors.joining());
  }

  static boolean check(String s, int index) {
    return s.contains(String.valueOf(COLORS[(index + 1) % COLORS.length]))
            == s.contains(String.valueOf(COLORS[(index + 2) % COLORS.length]))
        || (s.contains(String.valueOf(COLORS[index]))
            && s.chars().filter(c -> c != COLORS[index]).count() >= 2);
  }
}