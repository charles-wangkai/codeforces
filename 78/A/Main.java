import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int[] TARGET_SYLLABLE_NUM = {5, 7, 5};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String[] phrases = new String[3];
    for (int i = 0; i < phrases.length; ++i) {
      phrases[i] = sc.nextLine();
    }

    System.out.println(solve(phrases) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(String[] phrases) {
    return IntStream.range(0, phrases.length)
        .allMatch(
            i ->
                phrases[i].chars().filter(c -> "aeiou".indexOf(c) != -1).count()
                    == TARGET_SYLLABLE_NUM[i]);
  }
}
