import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] m = new int[n];
    for (int i = 0; i < m.length; ++i) {
      m[i] = sc.nextInt();
    }

    System.out.println(solve(m));

    sc.close();
  }

  static String solve(int[] m) {
    int[] result = new int[m.length];
    for (int i = 0; i < m.length; ++i) {
      int[] floorNums = new int[m.length];
      floorNums[i] = m[i];
      for (int j = i - 1; j >= 0; --j) {
        floorNums[j] = Math.min(m[j], floorNums[j + 1]);
      }
      for (int j = i + 1; j < floorNums.length; ++j) {
        floorNums[j] = Math.min(m[j], floorNums[j - 1]);
      }

      if (Arrays.stream(floorNums).asLongStream().sum()
          > Arrays.stream(result).asLongStream().sum()) {
        result = floorNums;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
