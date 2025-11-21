import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] c = new int[n];
    for (int i = 0; i < c.length; ++i) {
      c[i] = sc.nextInt();
    }

    System.out.println(solve(c));

    sc.close();
  }

  static String solve(int[] c) {
    int[] positives = Arrays.stream(c).filter(x -> x > 0).toArray();
    int[] negatives = Arrays.stream(c).filter(x -> x < 0).sorted().toArray();

    if (positives.length != 0 || negatives.length >= 2) {
      return IntStream.concat(
              Arrays.stream(positives),
              IntStream.range(0, negatives.length / 2 * 2).map(i -> negatives[i]))
          .mapToObj(String::valueOf)
          .collect(Collectors.joining(" "));
    }
    if (Arrays.stream(c).anyMatch(x -> x == 0)) {
      return "0";
    }

    return String.valueOf(negatives[negatives.length - 1]);
  }
}