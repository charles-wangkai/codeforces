import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n));

    sc.close();
  }

  static String solve(int n) {
    int total = (int) (n * (n + 1L) / 2);
    int diff = total % 2;
    int rest = total / 2;
    List<Integer> firstGroup = new ArrayList<>();
    for (int i = n; i >= 1; --i) {
      if (rest >= i) {
        firstGroup.add(i);
        rest -= i;
      }
    }

    return "%d\n%d %s"
        .formatted(
            diff,
            firstGroup.size(),
            firstGroup.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}