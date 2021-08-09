import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] u = new int[m];
    int[] v = new int[m];
    for (int i = 0; i < m; ++i) {
      u[i] = sc.nextInt() - 1;
      v[i] = sc.nextInt() - 1;
    }
    int q = sc.nextInt();
    sc.nextLine();
    String[] queries = new String[q];
    for (int i = 0; i < queries.length; ++i) {
      queries[i] = sc.nextLine();
    }

    System.out.println(solve(n, u, v, queries));

    sc.close();
  }

  static String solve(int n, int[] u, int[] v, String[] queries) {
    int[] counts = new int[n];
    for (int i = 0; i < u.length; ++i) {
      if (u[i] < v[i]) {
        ++counts[u[i]];
      } else {
        ++counts[v[i]];
      }
    }

    int restNum = (int) Arrays.stream(counts).filter(count -> count == 0).count();

    List<Integer> result = new ArrayList<>();
    for (String query : queries) {
      int[] parts = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (parts[0] == 1) {
        int node1 = parts[1] - 1;
        int node2 = parts[2] - 1;

        if (node1 < node2) {
          if (counts[node1] == 0) {
            --restNum;
          }

          ++counts[node1];
        } else {
          if (counts[node2] == 0) {
            --restNum;
          }

          ++counts[node2];
        }
      } else if (parts[0] == 2) {
        int node1 = parts[1] - 1;
        int node2 = parts[2] - 1;

        if (node1 < node2) {
          --counts[node1];

          if (counts[node1] == 0) {
            ++restNum;
          }
        } else {
          --counts[node2];

          if (counts[node2] == 0) {
            ++restNum;
          }
        }
      } else {
        result.add(restNum);
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}
