import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String s = sc.next();
    int q = sc.nextInt();
    int[] a = new int[q];
    int[] b = new int[q];
    for (int i = 0; i < q; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(s, a, b));

    sc.close();
  }

  static String solve(String s, int[] a, int[] b) {
    int plusNum = (int) s.chars().filter(c -> c == '+').count();

    int smallStep = Math.min(plusNum, s.length() - plusNum);
    int largeStep = s.length() - smallStep;

    return IntStream.range(0, a.length)
        .mapToObj(
            i -> {
              int min = Math.min(a[i], b[i]);
              int max = Math.max(a[i], b[i]);

              if (min == max) {
                return smallStep == largeStep;
              }

              return (long) min * smallStep % (max - min) == (long) min * largeStep % (max - min)
                  && (long) min * largeStep <= (long) max * smallStep;
            })
        .map(x -> x ? "YES" : "NO")
        .collect(Collectors.joining("\n"));
  }
}