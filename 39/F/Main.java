import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();
    int[] d = new int[m];
    for (int i = 0; i < d.length; ++i) {
      d[i] = sc.nextInt();
    }
    int[] hills = new int[k];
    for (int i = 0; i < hills.length; ++i) {
      hills[i] = sc.nextInt();
    }

    System.out.println(solve(n, d, hills));

    sc.close();
  }

  static String solve(int n, int[] d, int[] hills) {
    int[] smashNums =
        Arrays.stream(d)
            .map(di -> (int) Arrays.stream(hills).filter(hill -> hill % di == 0).count())
            .toArray();
    int minSmashNum = Arrays.stream(smashNums).min().getAsInt();
    int[] frogIndices =
        IntStream.range(0, smashNums.length).filter(i -> smashNums[i] == minSmashNum).toArray();

    return "%d\n%s"
        .formatted(
            frogIndices.length,
            Arrays.stream(frogIndices)
                .map(x -> x + 1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
  }
}