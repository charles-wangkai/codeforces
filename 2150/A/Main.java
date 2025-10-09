import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int m = sc.nextInt();
      String s = sc.next();
      int[] a = new int[m];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(s, a));
    }

    sc.close();
  }

  static String solve(String s, int[] a) {
    Set<Integer> blacks = Arrays.stream(a).boxed().collect(Collectors.toSet());
    int cell = 1;
    for (char command : s.toCharArray()) {
      if (command == 'A') {
        ++cell;
        blacks.add(cell);
      } else {
        while (true) {
          ++cell;
          if (!blacks.contains(cell)) {
            break;
          }
        }
        blacks.add(cell);

        while (true) {
          ++cell;
          if (!blacks.contains(cell)) {
            break;
          }
        }
      }
    }

    return "%d\n%s"
        .formatted(
            blacks.size(),
            blacks.stream().sorted().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}