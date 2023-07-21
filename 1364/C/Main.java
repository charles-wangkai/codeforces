import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  static final int LIMIT = 100005;

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
    Deque<Integer> freeIndices = new ArrayDeque<>();
    int[] b = new int[a.length];
    Arrays.fill(b, LIMIT);
    for (int i = 0; i < b.length; ++i) {
      int diff = a[i] - ((i == 0) ? 0 : a[i - 1]);
      freeIndices.push(i);
      if (freeIndices.size() < diff) {
        return "-1";
      }

      for (int j = 0; j < diff; ++j) {
        b[freeIndices.pop()] = a[i] - 1 - (diff - 1 - j);
      }
    }

    return Arrays.stream(b).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
