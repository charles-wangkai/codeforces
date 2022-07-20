import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] c = new int[n];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt() - 1;
      }

      System.out.println(solve(c));
    }

    sc.close();
  }

  static String solve(int[] c) {
    @SuppressWarnings("unchecked")
    List<Integer>[] indexLists = new List[c.length];
    for (int i = 0; i < indexLists.length; ++i) {
      indexLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < c.length; ++i) {
      indexLists[c[i]].add(i);
    }

    return Arrays.stream(indexLists)
        .mapToInt(Main::computeTowerSize)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  static int computeTowerSize(List<Integer> indices) {
    int result = 0;
    int evenSize = 0;
    int oddSize = 0;
    for (int index : indices) {
      if (index % 2 == 0) {
        evenSize = Math.max(evenSize, oddSize + 1);
      } else {
        oddSize = Math.max(oddSize, evenSize + 1);
      }

      result = Math.max(result, Math.max(evenSize, oddSize));
    }

    return result;
  }
}