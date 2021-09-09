import static java.util.Map.entry;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  static final Map<Character, Character> CELL_TO_OTHER =
      Map.ofEntries(entry('L', 'L'), entry('R', 'R'), entry('U', 'D'), entry('D', 'U'));

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

  static String solve(String s) {
    return s.chars()
        .mapToObj(ch -> String.valueOf(CELL_TO_OTHER.get((char) ch)))
        .collect(Collectors.joining());
  }
}
