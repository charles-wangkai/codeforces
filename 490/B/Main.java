import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b));

    sc.close();
  }

  static String solve(int[] a, int[] b) {
    Set<Integer> bSet = Arrays.stream(b).boxed().collect(Collectors.toSet());
    int first = Arrays.stream(a).filter(ai -> ai != 0 && !bSet.contains(ai)).findAny().getAsInt();

    Map<Integer, Integer> prevToNext =
        IntStream.range(0, a.length).boxed().collect(Collectors.toMap(i -> a[i], i -> b[i]));

    int[] sequence = new int[a.length];
    fill(sequence, prevToNext, -1, 0);
    fill(sequence, prevToNext, 0, first);

    return Arrays.stream(sequence).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static void fill(int[] sequence, Map<Integer, Integer> prevToNext, int index, int value) {
    while (true) {
      if (index != -1) {
        sequence[index] = value;
      }

      index += 2;
      if (index >= sequence.length) {
        break;
      }

      value = prevToNext.get(value);
    }
  }
}