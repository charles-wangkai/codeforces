import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String[] patterns = new String[n];
    for (int i = 0; i < patterns.length; ++i) {
      patterns[i] = sc.next();
    }

    System.out.println(solve(patterns));

    sc.close();
  }

  static String solve(String[] patterns) {
    return IntStream.range(0, patterns[0].length())
        .mapToObj(
            i -> {
              Character[] letters =
                  IntStream.range(0, patterns.length)
                      .mapToObj(j -> patterns[j].charAt(i))
                      .filter(c -> c != '?')
                      .distinct()
                      .toArray(Character[]::new);

              if (letters.length == 0) {
                return 'a';
              }
              if (letters.length == 1) {
                return letters[0];
              }

              return '?';
            })
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}