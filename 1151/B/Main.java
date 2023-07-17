import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final int BIT_LIMIT = 10;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] a = new int[n][m];
    for (int i = 0; i < a.length; ++i) {
      for (int j = 0; j < a[i].length; ++j) {
        a[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(a));

    sc.close();
  }

  static String solve(int[][] a) {
    int n = a.length;
    int m = a[0].length;

    for (int p = 0; p < BIT_LIMIT; ++p) {
      int[][] bits = new int[n][m];
      for (int i = 0; i < bits.length; ++i) {
        for (int j = 0; j < bits[i].length; ++j) {
          bits[i][j] = (a[i][j] >> p) & 1;
        }
      }

      int[] indices = findIndices(bits);
      if (indices != null) {
        return String.format(
            "TAK\n%s",
            Arrays.stream(indices)
                .map(i -> i + 1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
      }
    }

    return "NIE";
  }

  static int[] findIndices(int[][] bits) {
    int[] result = new int[bits.length];
    for (int i = 0; i < result.length; ++i) {
      if (Arrays.stream(bits[i]).distinct().count() == 2) {
        int i_ = i;
        int bit =
            IntStream.range(0, bits.length)
                    .filter(j -> j != i_)
                    .map(j -> bits[j][0])
                    .reduce(0, (acc, x) -> acc ^ x)
                ^ 1;
        result[i] =
            IntStream.range(0, bits[i].length).filter(j -> bits[i_][j] == bit).findAny().getAsInt();

        break;
      }
    }

    return (IntStream.range(0, result.length)
                .map(i -> bits[i][result[i]])
                .reduce((acc, x) -> acc ^ x)
                .getAsInt()
            == 1)
        ? result
        : null;
  }
}
