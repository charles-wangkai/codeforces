import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[k];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(n, a));

    sc.close();
  }

  static String solve(int n, int[] a) {
    Set<Integer> aSet = Arrays.stream(a).boxed().collect(Collectors.toSet());
    int[] rests = IntStream.rangeClosed(1, n * a.length).filter(i -> !aSet.contains(i)).toArray();

    return IntStream.range(0, a.length)
        .mapToObj(
            i ->
                IntStream.concat(
                        IntStream.of(a[i]),
                        IntStream.range(i * (n - 1), (i + 1) * (n - 1)).map(j -> rests[j]))
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }
}