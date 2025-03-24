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
    List<Integer> result = new ArrayList<>();
    int left = 0;
    int right = n - 1;
    for (int i = 0; i < n; ++i) {
      if (i % 2 == 0) {
        result.add(left + 1);
        ++left;
      } else {
        result.add(right + 1);
        --right;
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }
}