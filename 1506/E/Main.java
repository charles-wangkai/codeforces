import java.util.Arrays;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] q = new int[n];
      for (int i = 0; i < q.length; ++i) {
        q[i] = sc.nextInt();
      }

      System.out.println(solve(q));
    }

    sc.close();
  }

  static String solve(int[] q) {
    int n = q.length;

    NavigableSet<Integer> rests = new TreeSet<>();
    for (int i = 1; i <= n; ++i) {
      rests.add(i);
    }

    int[] minPermutation = new int[n];
    int[] maxPermutation = new int[n];
    for (int i = 0; i < q.length; ++i) {
      if (i == 0 || q[i] != q[i - 1]) {
        minPermutation[i] = q[i];
        maxPermutation[i] = q[i];
        rests.remove(q[i]);
      }
    }

    int[] restIndices =
        IntStream.range(0, minPermutation.length).filter(i -> minPermutation[i] == 0).toArray();

    int index = 0;
    for (int rest : rests) {
      minPermutation[restIndices[index]] = rest;
      ++index;
    }

    for (int restIndex : restIndices) {
      maxPermutation[restIndex] = rests.lower(q[restIndex]);
      rests.remove(maxPermutation[restIndex]);
    }

    return String.format(
        "%s\n%s",
        Arrays.stream(minPermutation).mapToObj(String::valueOf).collect(Collectors.joining(" ")),
        Arrays.stream(maxPermutation).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}