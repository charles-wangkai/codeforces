import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] s = new int[n - 1];
    int[] t = new int[n - 1];
    for (int i = 0; i < n - 1; ++i) {
      s[i] = sc.nextInt();
      t[i] = sc.nextInt();
    }

    System.out.println(solve(s, t));

    sc.close();
  }

  static String solve(int[] s, int[] t) {
    int n = s.length + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] edgeLists = new List[n];
    for (int i = 0; i < edgeLists.length; ++i) {
      edgeLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < s.length; ++i) {
      edgeLists[s[i] - 1].add(i);
      edgeLists[t[i] - 1].add(i);
    }

    int[] subtreeInverseNums = new int[n];
    buildSubtreeInverseNums(subtreeInverseNums, s, t, edgeLists, -1, 0);

    int[] inverseNums = new int[n];
    buildInverseNums(inverseNums, s, t, edgeLists, subtreeInverseNums, 0, -1, 0);

    int minInverseNum = Arrays.stream(inverseNums).min().getAsInt();

    return "%d\n%s"
        .formatted(
            minInverseNum,
            IntStream.range(0, inverseNums.length)
                .filter(i -> inverseNums[i] == minInverseNum)
                .map(i -> i + 1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
  }

  static void buildInverseNums(
      int[] inverseNums,
      int[] s,
      int[] t,
      List<Integer>[] edgeLists,
      int[] subtreeInverseNums,
      int inverseNumFromParent,
      int parent,
      int node) {
    inverseNums[node] = inverseNumFromParent + subtreeInverseNums[node];

    for (int edge : edgeLists[node]) {
      int other = (s[edge] - 1 == node) ? (t[edge] - 1) : (s[edge] - 1);
      if (other != parent) {
        buildInverseNums(
            inverseNums,
            s,
            t,
            edgeLists,
            subtreeInverseNums,
            inverseNumFromParent
                + (subtreeInverseNums[node] - subtreeInverseNums[other])
                + ((t[edge] - 1 == node) ? -1 : 1),
            node,
            other);
      }
    }
  }

  static void buildSubtreeInverseNums(
      int[] subtreeInverseNums, int[] s, int[] t, List<Integer>[] edgeLists, int parent, int node) {
    for (int edge : edgeLists[node]) {
      int other = (s[edge] - 1 == node) ? (t[edge] - 1) : (s[edge] - 1);
      if (other != parent) {
        buildSubtreeInverseNums(subtreeInverseNums, s, t, edgeLists, node, other);
      }
    }

    for (int edge : edgeLists[node]) {
      int other = (s[edge] - 1 == node) ? (t[edge] - 1) : (s[edge] - 1);
      if (other != parent) {
        if (t[edge] - 1 == node) {
          ++subtreeInverseNums[node];
        }
        subtreeInverseNums[node] += subtreeInverseNums[other];
      }
    }
  }
}