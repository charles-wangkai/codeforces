import java.util.Arrays;
import java.util.List;
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
    int max = Arrays.stream(a).max().getAsInt();
    int min = Arrays.stream(a).min().getAsInt();

    List<Integer> rests = Arrays.stream(a).boxed().collect(Collectors.toList());
    rests.remove(Integer.valueOf(max));
    rests.remove(Integer.valueOf(min));

    return IntStream.concat(
            IntStream.concat(
                IntStream.of(max), rests.stream().mapToInt(Integer::intValue).sorted()),
            IntStream.of(min))
        .boxed()
        .map(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}