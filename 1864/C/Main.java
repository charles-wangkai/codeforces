import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int x = sc.nextInt();

      System.out.println(solve(x));
    }

    sc.close();
  }

  static String solve(int x) {
    List<Integer> a = new ArrayList<>();
    a.add(x);
    while (x != 1) {
      int lowest = Integer.lowestOneBit(x);
      if (lowest == x) {
        x /= 2;
      } else {
        x -= lowest;
      }

      a.add(x);
    }

    return String.format(
        "%d\n%s", a.size(), a.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}
