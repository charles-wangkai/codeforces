import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int k = sc.nextInt();

    System.out.println(solve(k));

    sc.close();
  }

  static String solve(int k) {
    String figure =
        """
        +------------------------+
        |#.#.#.#.#.#.#.#.#.#.#.|D|)
        |#.#.#.#.#.#.#.#.#.#.#.|.|
        |#.......................|
        |#.#.#.#.#.#.#.#.#.#.#.|.|)
        +------------------------+
        """;

    char[][] result =
        Arrays.stream(figure.split("\n")).map(String::toCharArray).toArray(char[][]::new);

    for (int c = 0; c < result[0].length; ++c) {
      for (int r = 0; r < result.length; ++r) {
        if (result[r][c] == '#' && k != 0) {
          result[r][c] = 'O';
          --k;
        }
      }
    }

    return Arrays.stream(result).map(String::new).collect(Collectors.joining("\n"));
  }
}