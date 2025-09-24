import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int l = sc.nextInt();
    int r = sc.nextInt();
    int sAll = sc.nextInt();
    int sK = sc.nextInt();

    System.out.println(solve(n, k, l, r, sAll, sK));

    sc.close();
  }

  static String solve(int n, int k, int l, int r, int sAll, int sK) {
    return IntStream.concat(
            Arrays.stream(buildPoints(sK, k)), Arrays.stream(buildPoints(sAll - sK, n - k)))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  static int[] buildPoints(int sum, int size) {
    return IntStream.range(0, size).map(i -> sum / size + ((i < sum % size) ? 1 : 0)).toArray();
  }
}