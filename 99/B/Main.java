import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] volumes = new int[n];
    for (int i = 0; i < volumes.length; ++i) {
      volumes[i] = sc.nextInt();
    }

    System.out.println(solve(volumes));

    sc.close();
  }

  static String solve(int[] volumes) {
    int sum = Arrays.stream(volumes).sum();
    if (sum % volumes.length == 0) {
      int average = sum / volumes.length;
      int[] diffIndices =
          IntStream.range(0, volumes.length)
              .filter(i -> volumes[i] != average)
              .boxed()
              .sorted(Comparator.comparing(i -> volumes[i]))
              .mapToInt(Integer::intValue)
              .toArray();
      if (diffIndices.length == 0) {
        return "Exemplary pages.";
      }
      if (diffIndices.length == 2) {
        return "%d ml. from cup #%d to cup #%d."
            .formatted(average - volumes[diffIndices[0]], diffIndices[0] + 1, diffIndices[1] + 1);
      }
    }

    return "Unrecoverable configuration.";
  }
}