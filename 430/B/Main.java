import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int x = sc.nextInt();
    int[] c = new int[n];
    for (int i = 0; i < c.length; ++i) {
      c[i] = sc.nextInt();
    }

    System.out.println(solve(c, k, x));

    sc.close();
  }

  static int solve(int[] c, int k, int x) {
    return IntStream.rangeClosed(0, c.length)
        .map(
            firstLength ->
                computeDestroyNum(
                    IntStream.concat(
                            IntStream.concat(
                                IntStream.range(0, firstLength).map(i -> c[i]), IntStream.of(x)),
                            IntStream.range(firstLength, c.length).map(i -> c[i]))
                        .toArray()))
        .max()
        .getAsInt();
  }

  static int computeDestroyNum(int[] colors) {
    List<Integer> rest = new ArrayList<>();
    for (int i = 0; i <= colors.length; ++i) {
      if (i != colors.length && !rest.isEmpty() && colors[i] == rest.getLast()) {
        rest.add(colors[i]);
      } else {
        if (rest.size() >= 3
            && rest.get(rest.size() - 1).equals(rest.get(rest.size() - 2))
            && rest.get(rest.size() - 2).equals(rest.get(rest.size() - 3))) {
          int target = rest.getLast();
          while (!rest.isEmpty() && rest.getLast() == target) {
            rest.removeLast();
          }
        }

        if (i != colors.length) {
          rest.add(colors[i]);
        }
      }
    }

    return Math.max(0, colors.length - rest.size() - 1);
  }
}