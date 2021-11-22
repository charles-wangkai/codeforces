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
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    List<Integer> rest = Arrays.stream(a).boxed().collect(Collectors.toList());
    while (!rest.isEmpty()) {
      int index = rest.size() - 1;
      while (index != -1 && rest.get(index) % (index + 2) == 0) {
        --index;
      }
      if (index == -1) {
        return false;
      }

      rest.remove(index);
    }

    return true;
  }
}
