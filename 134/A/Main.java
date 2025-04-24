import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static String solve(int[] a) {
    int sum = Arrays.stream(a).sum();
    int[] indices =
        IntStream.range(0, a.length).filter(i -> sum - a[i] == a[i] * (a.length - 1)).toArray();

    return "%d\n%s"
        .formatted(
            indices.length,
            Arrays.stream(indices)
                .map(x -> x + 1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
  }
}