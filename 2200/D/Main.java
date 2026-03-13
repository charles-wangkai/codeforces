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
      int x = sc.nextInt();
      int y = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(p, x, y));
    }

    sc.close();
  }

  static String solve(int[] p, int x, int y) {
    int[] middlePart =
        IntStream.range(0, p.length).filter(i -> i >= x && i < y).map(i -> p[i]).toArray();
    int middleBeginIndex =
        IntStream.range(0, middlePart.length)
            .boxed()
            .min(Comparator.comparing(i -> middlePart[i]))
            .get();
    int[] middleRotated =
        IntStream.concat(
                IntStream.range(middleBeginIndex, middlePart.length),
                IntStream.range(0, middleBeginIndex))
            .map(i -> middlePart[i])
            .toArray();

    int[] outerPart =
        IntStream.range(0, p.length).filter(i -> i < x || i >= y).map(i -> p[i]).toArray();
    int outerTailBeginIndex =
        IntStream.range(0, outerPart.length)
            .filter(i -> outerPart[i] > middleRotated[0])
            .findFirst()
            .orElse(outerPart.length);

    return IntStream.concat(
            IntStream.concat(
                IntStream.range(0, outerTailBeginIndex).map(i -> outerPart[i]),
                Arrays.stream(middleRotated)),
            IntStream.range(outerTailBeginIndex, outerPart.length).map(i -> outerPart[i]))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}