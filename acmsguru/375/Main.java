import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static String solve(int N) {
    if (N % 2 == 0) {
      return "No solution";
    }

    Deque<Integer> amplifiers = new ArrayDeque<>();
    while (N != 1) {
      int next = N >> 1;
      int amplifier;
      if (next % 2 != 0) {
        amplifier = 2;
      } else {
        amplifier = 1;
        ++next;
      }
      amplifiers.offerFirst(amplifier);

      N = next;
    }

    return String.format(
        "%d\n%s",
        amplifiers.size(),
        amplifiers.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}
