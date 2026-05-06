import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int f = sc.nextInt();
    int[] e = new int[n];
    for (int i = 0; i < e.length; ++i) {
      e[i] = sc.nextInt();
    }

    System.out.println(solve(e, f));

    sc.close();
  }

  static String solve(int[] e, int f) {
    Set<Integer> targets = Arrays.stream(e).boxed().collect(Collectors.toSet());

    List<Integer> result = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    for (int ei : e) {
      if (!visited.contains(ei)) {
        int offset = (ei < f) ? -1 : 1;
        do {
          f += offset;
          if (targets.contains(f) && !visited.contains(f)) {
            result.add(f);
            visited.add(f);
          }

        } while (f != ei);
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }
}