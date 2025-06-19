import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int m = sc.nextInt();

    System.out.println(solve(m));

    sc.close();
  }

  static String solve(int m) {
    List<Integer> ns = new ArrayList<>();
    int zeroNum = 0;
    for (int i = 1; zeroNum <= m; ++i) {
      int rest = i;
      while (rest % 5 == 0) {
        ++zeroNum;
        rest /= 5;
      }

      if (zeroNum == m) {
        ns.add(i);
      }
    }

    return "%d\n%s"
        .formatted(ns.size(), ns.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}