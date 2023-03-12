import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(b));
    }

    sc.close();
  }

  static String solve(int[] b) {
    int posCount = (int) Arrays.stream(b).filter(x -> x > 0).count();
    int negCount = b.length - posCount;

    return String.format(
        "%s\n%s", computeMaxLikeNums(posCount, negCount), computeMinLikeNums(posCount, negCount));
  }

  static String computeMaxLikeNums(int posCount, int negCount) {
    int[] result = new int[posCount + negCount];
    for (int i = 0; i < result.length; ++i) {
      if (posCount != 0) {
        result[i] = ((i == 0) ? 0 : result[i - 1]) + 1;
        --posCount;
      } else {
        result[i] = ((i == 0) ? 0 : result[i - 1]) - 1;
        --negCount;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static String computeMinLikeNums(int posCount, int negCount) {
    int[] result = new int[posCount + negCount];
    for (int i = 0; i < result.length; ++i) {
      if (i == 0 || result[i - 1] == 0 || negCount == 0) {
        result[i] = ((i == 0) ? 0 : result[i - 1]) + 1;
        --posCount;
      } else {
        result[i] = ((i == 0) ? 0 : result[i - 1]) - 1;
        --negCount;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
