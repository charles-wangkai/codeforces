import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int q = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    sc.nextLine();
    String[] queries = new String[q];
    for (int i = 0; i < queries.length; ++i) {
      queries[i] = sc.nextLine();
    }
    System.out.println(solve(a, queries));

    sc.close();
  }

  static String solve(int[] a, String[] queries) {
    List<Integer> result = new ArrayList<>();
    int oneCount = (int) Arrays.stream(a).filter(x -> x == 1).count();
    for (String query : queries) {
      String[] parts = query.split(" ");
      if (parts[0].equals("1")) {
        int x = Integer.parseInt(parts[1]) - 1;
        a[x] = 1 - a[x];
        if (a[x] == 0) {
          --oneCount;
        } else {
          ++oneCount;
        }
      } else {
        int k = Integer.parseInt(parts[1]);
        result.add((oneCount >= k) ? 1 : 0);
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}
