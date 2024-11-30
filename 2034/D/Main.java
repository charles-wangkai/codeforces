import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    @SuppressWarnings("unchecked")
    SortedSet<Integer>[] indexSets = new SortedSet[3];
    for (int i = 0; i < indexSets.length; ++i) {
      indexSets[i] = new TreeSet<>();
    }
    for (int i = 0; i < a.length; ++i) {
      indexSets[a[i]].add(i);
    }

    int[] sorted = Arrays.stream(a).sorted().toArray();

    List<String> moves = new ArrayList<>();
    for (int i = 0; i < a.length; ++i) {
      while (a[i] != sorted[i]) {
        int index = indexSets[a[i] - 1].last();
        moves.add("%d %d".formatted(i + 1, index + 1));

        indexSets[a[i]].remove(i);
        indexSets[a[i] - 1].add(i);

        indexSets[a[i] - 1].remove(index);
        indexSets[a[i]].add(index);

        --a[i];
        ++a[index];
      }
    }

    return "%d\n%s".formatted(moves.size(), String.join("\n", moves));
  }
}