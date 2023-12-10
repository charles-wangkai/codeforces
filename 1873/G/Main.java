import java.util.Scanner;
import java.util.stream.IntStream;

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

  static int solve(String s) {
    int[] bIndices = IntStream.range(0, s.length()).filter(i -> s.charAt(i) == 'B').toArray();

    return IntStream.rangeClosed(0, bIndices.length)
        .map(
            i ->
                ((i == bIndices.length) ? s.length() : bIndices[i])
                    - ((i == 0) ? -1 : bIndices[i - 1])
                    - 1)
        .sorted()
        .skip(1)
        .sum();
  }
}