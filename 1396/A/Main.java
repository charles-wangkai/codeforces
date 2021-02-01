import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
    int n = a.length;

    List<String> lines = new ArrayList<>();

    long[] current = Arrays.stream(a).asLongStream().toArray();

    if (n == 1) {
      lines.add("1 1");
      lines.add("0");
      lines.add("1 1");
      lines.add("0");
    } else {
      lines.add(String.format("1 %d", n - 1));
      long[] b1 = new long[n - 1];
      for (int i = 0; i < b1.length; ++i) {
        b1[i] = Math.floorMod(current[i], n) * (n - 1L);
        current[i] += b1[i];
      }
      lines.add(Arrays.stream(b1).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

      lines.add(String.format("2 %d", n));
      long[] b2 = new long[n - 1];
      for (int i = 0; i < b2.length; ++i) {
        b2[i] = Math.floorMod(current[i + 1], n) * (n - 1L);
        current[i + 1] += b2[i];
      }
      lines.add(Arrays.stream(b2).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

    lines.add(String.format("1 %d", n));
    long[] b3 = new long[n];
    for (int i = 0; i < b3.length; ++i) {
      b3[i] = -current[i];
    }
    lines.add(Arrays.stream(b3).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

    return String.join("\n", lines);
  }
}
