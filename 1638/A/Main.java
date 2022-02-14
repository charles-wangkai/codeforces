import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(p));
    }

    sc.close();
  }

  static String solve(int[] p) {
    int[] sorted = Arrays.stream(p).boxed().sorted().mapToInt(x -> x).toArray();

    int diffIndex = 0;
    while (diffIndex != p.length && sorted[diffIndex] == p[diffIndex]) {
      ++diffIndex;
    }
    if (diffIndex != p.length) {
      int diffIndex_ = diffIndex;
      int endIndex =
          IntStream.range(0, p.length).filter(i -> p[i] == sorted[diffIndex_]).findAny().getAsInt();

      for (int i = diffIndex, j = endIndex; i < j; ++i, --j) {
        int temp = p[i];
        p[i] = p[j];
        p[j] = temp;
      }
    }

    return Arrays.stream(p).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}