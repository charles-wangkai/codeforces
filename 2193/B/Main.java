import java.util.Arrays;
import java.util.OptionalInt;
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
    OptionalInt leftIndex =
        IntStream.range(0, p.length).filter(i -> p[i] != p.length - i).findFirst();
    if (leftIndex.isPresent()) {
      int rightIndex =
          IntStream.range(0, p.length)
              .filter(i -> p[i] == p.length - leftIndex.getAsInt())
              .findAny()
              .getAsInt();
      for (int i = leftIndex.getAsInt(), j = rightIndex; i < j; ++i, --j) {
        int temp = p[i];
        p[i] = p[j];
        p[j] = temp;
      }
    }

    return Arrays.stream(p).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}