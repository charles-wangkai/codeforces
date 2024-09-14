import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final String VOWELS = "aeiou";

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(int n) {
    return IntStream.range(0, VOWELS.length())
        .mapToObj(
            i ->
                String.valueOf(VOWELS.charAt(i))
                    .repeat(n / VOWELS.length() + ((i < n % VOWELS.length()) ? 1 : 0)))
        .collect(Collectors.joining());
  }
}