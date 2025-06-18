import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();

    System.out.println(solve(n, k));

    sc.close();
  }

  static String solve(int n, int k) {
    List<Integer> skewers = new ArrayList<>();
    int skewer = n - k;
    while (skewer + k >= 1) {
      skewers.add(skewer);
      skewer -= 2 * k + 1;
    }

    int offset = Math.max(0, 1 - skewers.getLast());
    for (int i = 0; i < skewers.size(); ++i) {
      skewers.set(i, skewers.get(i) + offset);
    }

    return "%d\n%s"
        .formatted(
            skewers.size(), skewers.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}