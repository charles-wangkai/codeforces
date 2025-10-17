import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    int[] twoSums = new int[N - 1];
    for (int i = 0; i < twoSums.length; ++i) {
      twoSums[i] = query(sc, i, i + 1);
    }

    int threeSum = query(sc, 0, 2);

    int[] result = new int[N];
    result[0] = threeSum - twoSums[1];
    for (int i = 1; i < result.length; ++i) {
      result[i] = twoSums[i - 1] - result[i - 1];
    }

    System.out.println(
        "! %s"
            .formatted(
                Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "))));
    System.out.flush();

    sc.close();
  }

  static int query(Scanner sc, int beginIndex, int endIndex) {
    System.out.println("? %d %d".formatted(beginIndex + 1, endIndex + 1));
    System.out.flush();

    return sc.nextInt();
  }
}