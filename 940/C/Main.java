import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int k = sc.nextInt();
    String s = sc.next();

    System.out.println(solve(s, k));

    sc.close();
  }

  static String solve(String s, int k) {
    Character[] letters =
        s.chars().mapToObj(c -> (char) c).distinct().sorted().toArray(Character[]::new);

    if (k > s.length()) {
      return s + String.valueOf(letters[0]).repeat(k - s.length());
    }

    int index =
        IntStream.range(0, k)
            .filter(i -> s.charAt(i) != letters[letters.length - 1])
            .max()
            .getAsInt();

    return "%s%c%s"
        .formatted(
            s.substring(0, index),
            letters[
                IntStream.range(0, letters.length)
                        .filter(i -> letters[i] == s.charAt(index))
                        .findAny()
                        .getAsInt()
                    + 1],
            String.valueOf(letters[0]).repeat(k - index - 1));
  }
}