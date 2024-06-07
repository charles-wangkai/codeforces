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

    int index = 0;
    for (int i = 0; i < n - 1; ++i) {
      index = (index + i + 1) % n;
      result.add(index + 1);
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }
}