import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String[] initials = new String[3];
    for (int i = 0; i < initials.length; ++i) {
      initials[i] = sc.next();
    }
    int n = sc.nextInt();
    String[] s = new String[n];
    for (int i = 0; i < s.length; ++i) {
      s[i] = sc.next();
    }

    System.out.println(solve(initials, s));

    sc.close();
  }

  static String solve(String[] initials, String[] s) {
    Set<String> solutions =
        Stream.of(
                initials[0] + initials[1] + initials[2],
                initials[0] + initials[2] + initials[1],
                initials[1] + initials[0] + initials[2],
                initials[1] + initials[2] + initials[0],
                initials[2] + initials[0] + initials[1],
                initials[2] + initials[1] + initials[0])
            .map(Main::normalize)
            .collect(Collectors.toSet());

    return Arrays.stream(s)
        .map(x -> solutions.contains(normalize(x)) ? "ACC" : "WA")
        .collect(Collectors.joining("\n"));
  }

  static String normalize(String x) {
    return x.toLowerCase()
        .chars()
        .filter(Character::isLetter)
        .mapToObj(c -> (char) c)
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}