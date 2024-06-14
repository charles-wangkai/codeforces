import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] p = new int[n - 1];
    for (int i = 0; i < p.length; ++i) {
      p[i] = sc.nextInt();
    }

    System.out.println(solve(p));

    sc.close();
  }

  static String solve(int[] p) {
    int n = p.length + 1;

    List<Integer> result = new ArrayList<>();
    int current = n;
    while (true) {
      result.add(current);
      if (current == 1) {
        break;
      }

      current = p[current - 2];
    }
    Collections.reverse(result);

    return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }
}