import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String w = sc.next();
      int p = sc.nextInt();

      System.out.println(solve(w, p));
    }

    sc.close();
  }

  static String solve(String w, int p) {
    int[] sortedIndices =
        IntStream.range(0, w.length())
            .boxed()
            .sorted(Comparator.comparing(w::charAt).reversed())
            .mapToInt(x -> x)
            .toArray();

    boolean[] deleted = new boolean[w.length()];
    int price = w.chars().map(c -> c - 'a' + 1).sum();
    int index = 0;
    while (price > p) {
      deleted[sortedIndices[index]] = true;
      price -= w.charAt(sortedIndices[index]) - 'a' + 1;

      ++index;
    }

    return IntStream.range(0, w.length())
        .filter(i -> !deleted[i])
        .mapToObj(i -> String.valueOf(w.charAt(i)))
        .collect(Collectors.joining());
  }
}