import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(p));
    }

    sc.close();
  }

  static String solve(int[] p) {
    int[] solution = IntStream.rangeClosed(1, p.length).toArray();
    boolean found = search(p, solution, 0);

    return found
        ? Arrays.stream(solution).mapToObj(String::valueOf).collect(Collectors.joining(" "))
        : "-1";
  }

  static boolean search(int[] p, int[] solution, int index) {
    if (index == solution.length) {
      return true;
    }

    int[] sortedIndices =
        IntStream.range(index, solution.length)
            .boxed()
            .sorted(Comparator.comparing(i -> solution[i]))
            .mapToInt(x -> x)
            .toArray();
    for (int sortedIndex : sortedIndices) {
      swap(solution, index, sortedIndex);
      if (solution[index] != p[index] && search(p, solution, index + 1)) {
        return true;
      }
      swap(solution, index, sortedIndex);
    }

    return false;
  }

  static void swap(int[] a, int index1, int index2) {
    int temp = a[index1];
    a[index1] = a[index2];
    a[index2] = temp;
  }
}