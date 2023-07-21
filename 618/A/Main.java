import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    System.out.println(solve(n).stream().map(String::valueOf).collect(Collectors.joining(" ")));

    sc.close();
  }

  static List<Integer> solve(int n) {
    List<Integer> row = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      row.add(1);

      while (row.size() >= 2 && row.get(row.size() - 2).equals(row.get(row.size() - 1))) {
        row.remove(row.size() - 1);
        row.add(row.remove(row.size() - 1) + 1);
      }
    }
    return row;
  }
}
