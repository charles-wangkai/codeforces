import java.util.Arrays;
import java.util.Comparator;
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
      String s = sc.next();

      System.out.println(solve(p, s));
    }

    sc.close();
  }

  static String solve(int[] p, String s) {
    int[] dislikeSortedIndices =
        IntStream.range(0, p.length)
            .filter(i -> s.charAt(i) == '0')
            .boxed()
            .sorted(Comparator.comparing(i -> p[i]))
            .mapToInt(x -> x)
            .toArray();
    int[] likeSortedIndices =
        IntStream.range(0, p.length)
            .filter(i -> s.charAt(i) == '1')
            .boxed()
            .sorted(Comparator.comparing(i -> p[i]))
            .mapToInt(x -> x)
            .toArray();

    int[] result = new int[p.length];
    int rating = 1;
    for (int dislikeIndex : dislikeSortedIndices) {
      result[dislikeIndex] = rating;
      ++rating;
    }
    for (int likeIndex : likeSortedIndices) {
      result[likeIndex] = rating;
      ++rating;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
