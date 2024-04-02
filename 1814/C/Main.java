import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int s1 = sc.nextInt();
      int s2 = sc.nextInt();
      int[] r = new int[n];
      for (int i = 0; i < r.length; ++i) {
        r[i] = sc.nextInt();
      }

      System.out.println(solve(r, s1, s2));
    }

    sc.close();
  }

  static String solve(int[] r, int s1, int s2) {
    int[] sortedIndices =
        IntStream.range(0, r.length)
            .boxed()
            .sorted(Comparator.<Integer, Integer>comparing(i -> r[i]).reversed())
            .mapToInt(Integer::intValue)
            .toArray();

    List<Integer> a = new ArrayList<>();
    List<Integer> b = new ArrayList<>();
    int time1 = s1;
    int time2 = s2;
    for (int index : sortedIndices) {
      if (time1 <= time2) {
        a.add(index + 1);
        time1 += s1;
      } else {
        b.add(index + 1);
        time2 += s2;
      }
    }

    return String.format(
        "%d%s\n%d%s",
        a.size(),
        a.stream().map(ai -> " " + ai).collect(Collectors.joining()),
        b.size(),
        b.stream().map(bi -> " " + bi).collect(Collectors.joining()));
  }
}