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
    sc.nextLine();
    String[] queries = new String[q];
    for (int i = 0; i < queries.length; ++i) {
      queries[i] = sc.nextLine();
    }

    System.out.println(solve(n, queries));

    sc.close();
  }

  static String solve(int n, String[] queries) {
    int[] rowCounts = new int[n];
    int[] rowBinaryIndexedTree = new int[Integer.highestOneBit(n) * 2 + 1];
    int[] colCounts = new int[n];
    int[] colBinaryIndexedTree = new int[Integer.highestOneBit(n) * 2 + 1];

    List<Boolean> result = new ArrayList<>();
    for (String query : queries) {
      int[] parts = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (parts[0] == 1) {
        int x = parts[1];
        int y = parts[2];

        if (rowCounts[x - 1] == 0) {
          add(rowBinaryIndexedTree, x, 1);
        }
        ++rowCounts[x - 1];

        if (colCounts[y - 1] == 0) {
          add(colBinaryIndexedTree, y, 1);
        }
        ++colCounts[y - 1];
      } else if (parts[0] == 2) {
        int x = parts[1];
        int y = parts[2];

        --rowCounts[x - 1];
        if (rowCounts[x - 1] == 0) {
          add(rowBinaryIndexedTree, x, -1);
        }

        --colCounts[y - 1];
        if (colCounts[y - 1] == 0) {
          add(colBinaryIndexedTree, y, -1);
        }
      } else {
        int x1 = parts[1];
        int y1 = parts[2];
        int x2 = parts[3];
        int y2 = parts[4];

        result.add(
            computeSum(rowBinaryIndexedTree, x2) - computeSum(rowBinaryIndexedTree, x1 - 1)
                    == x2 - x1 + 1
                || computeSum(colBinaryIndexedTree, y2) - computeSum(colBinaryIndexedTree, y1 - 1)
                    == y2 - y1 + 1);
      }
    }

    return result.stream().map(x -> x ? "Yes" : "No").collect(Collectors.joining("\n"));
  }

  static void add(int[] binaryIndexedTree, int i, int x) {
    while (i < binaryIndexedTree.length) {
      binaryIndexedTree[i] += x;
      i += i & -i;
    }
  }

  static int computeSum(int[] binaryIndexedTree, int i) {
    int result = 0;
    while (i != 0) {
      result += binaryIndexedTree[i];
      i -= i & -i;
    }

    return result;
  }
}