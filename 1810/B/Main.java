import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(int n) {
    List<Integer> spells = new ArrayList<>();
    while (n != 1) {
      if (n % 2 == 0) {
        return "-1";
      }

      if ((n + 1) / 2 % 2 == 1) {
        spells.add(1);
        n = (n + 1) / 2;
      } else {
        spells.add(2);
        n = (n - 1) / 2;
      }
    }
    Collections.reverse(spells);

    return String.format(
        "%d\n%s",
        spells.size(), spells.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}
