import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String m = sc.next();

    System.out.println(solve(n, m) ? "OK" : "WRONG_ANSWER");

    sc.close();
  }

  static boolean solve(int n, String m) {
    int[] digits = String.valueOf(n).chars().map(c -> c - '0').sorted().toArray();

    int nonZeroIndex = 0;
    while (nonZeroIndex != digits.length && digits[nonZeroIndex] == 0) {
      ++nonZeroIndex;
    }
    if (nonZeroIndex != digits.length) {
      int temp = digits[0];
      digits[0] = digits[nonZeroIndex];
      digits[nonZeroIndex] = temp;
    }

    return Arrays.stream(digits).mapToObj(String::valueOf).collect(Collectors.joining()).equals(m);
  }
}