import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    int[] digits = s.chars().map(c -> c - '0').toArray();

    boolean changed;
    do {
      changed = false;
      for (int i = 0; i < digits.length - 1; ++i) {
        if (digits[i + 1] >= digits[i] + 2) {
          int temp = digits[i];
          digits[i] = digits[i + 1] - 1;
          digits[i + 1] = temp;

          changed = true;
        }
      }
    } while (changed);

    return Arrays.stream(digits).mapToObj(String::valueOf).collect(Collectors.joining());
  }
}