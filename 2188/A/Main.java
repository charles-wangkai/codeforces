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
    List<Integer> result = new ArrayList<>();
    int left = 1;
    int right = n;
    while (left <= right) {
      if (result.size() % 2 == 0) {
        result.add(left);
        ++left;
      } else {
        result.add(right);
        --right;
      }
    }
    Collections.reverse(result);

    return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }
}
