import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] p = new int[n];
    for (int i = 0; i < p.length; ++i) {
      p[i] = sc.nextInt();
    }
    String assignment = sc.next();

    System.out.println(solve(p, assignment));

    sc.close();
  }

  static long solve(int[] p, String assignment) {
    return Math.max(
        computeMaxForB(p, assignment, 0, 1), computeMaxForB(p, assignment, p.length - 1, -1));
  }

  static long computeMaxForB(int[] p, String assignment, int index, int offset) {
    long total =
        IntStream.range(0, assignment.length())
            .filter(i -> assignment.charAt(i) == 'B')
            .map(i -> p[i])
            .asLongStream()
            .sum();

    long result = total;
    long delta = 0;
    while (index >= 0 && index < assignment.length()) {
      delta += ((assignment.charAt(index) == 'A') ? 1 : -1) * p[index];
      result = Math.max(result, total + delta);

      index += offset;
    }

    return result;
  }
}