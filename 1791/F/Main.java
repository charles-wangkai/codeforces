import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
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
    }

    sc.close();
  }

  static String solve(int[] a, String[] queries) {
    Node tree = buildNode(0, a.length - 1);

    List<Integer> result = new ArrayList<>();
    for (String query : queries) {
      int[] fields = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (fields[0] == 1) {
        update(fields[1] - 1, fields[2] - 1, tree);
      } else {
        int index = fields[1] - 1;
        result.add(computeValue(a[index], inquire(index, tree)));
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }

  static int computeValue(int x, int count) {
    return (count == 0 || x <= 9)
        ? x
        : computeValue(String.valueOf(x).chars().map(c -> c - '0').sum(), count - 1);
  }

  static int inquire(int index, Node node) {
    if (node.beginIndex == node.endIndex) {
      return node.count;
    }

    return node.count
        + ((index <= node.left.endIndex) ? inquire(index, node.left) : inquire(index, node.right));
  }

  static void update(int beginIndex, int endIndex, Node node) {
    if (!(node.endIndex < beginIndex || node.beginIndex > endIndex)) {
      if (node.beginIndex >= beginIndex && node.endIndex <= endIndex) {
        ++node.count;
      } else {
        update(beginIndex, endIndex, node.left);
        update(beginIndex, endIndex, node.right);
      }
    }
  }

  static Node buildNode(int beginIndex, int endIndex) {
    Node node = new Node(beginIndex, endIndex);
    if (beginIndex != endIndex) {
      int middleIndex = (beginIndex + endIndex) / 2;
      node.left = buildNode(beginIndex, middleIndex);
      node.right = buildNode(middleIndex + 1, endIndex);
    }

    return node;
  }
}

class Node {
  int beginIndex;
  int endIndex;
  int count;
  Node left;
  Node right;

  Node(int beginIndex, int endIndex) {
    this.beginIndex = beginIndex;
    this.endIndex = endIndex;
  }
}
