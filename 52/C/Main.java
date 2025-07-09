import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int m = sc.nextInt();
    sc.nextLine();
    String[] operations = new String[m];
    for (int i = 0; i < operations.length; ++i) {
      operations[i] = sc.nextLine();
    }

    System.out.println(solve(a, operations));

    sc.close();
  }

  static String solve(int[] a, String[] operations) {
    Node segmentTree = buildNode(a, 0, a.length - 1);

    List<Long> result = new ArrayList<>();
    for (String operation : operations) {
      int[] fields = Arrays.stream(operation.split(" ")).mapToInt(Integer::parseInt).toArray();
      int left = fields[0];
      int right = fields[1];

      if (fields.length == 3) {
        int v = fields[2];

        if (left <= right) {
          updateSegmentTree(left, right, v, segmentTree);
        } else {
          updateSegmentTree(left, a.length - 1, v, segmentTree);
          updateSegmentTree(0, right, v, segmentTree);
        }
      } else if (left <= right) {
        result.add(querySegmentTree(left, right, segmentTree));
      } else {
        result.add(
            Math.min(
                querySegmentTree(left, a.length - 1, segmentTree),
                querySegmentTree(0, right, segmentTree)));
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }

  static void updateSegmentTree(int beginIndex, int endIndex, int delta, Node node) {
    if (!(node.beginIndex > endIndex || node.endIndex < beginIndex)) {
      if (node.beginIndex >= beginIndex && node.endIndex <= endIndex) {
        node.delta += delta;
      } else {
        if (node.delta != 0) {
          node.left.delta += node.delta;
          node.right.delta += node.delta;
          node.delta = 0;
        }

        updateSegmentTree(beginIndex, endIndex, delta, node.left);
        updateSegmentTree(beginIndex, endIndex, delta, node.right);

        node.minValue =
            Math.min(node.left.delta + node.left.minValue, node.right.delta + node.right.minValue);
      }
    }
  }

  static long querySegmentTree(int beginIndex, int endIndex, Node node) {
    if (node.beginIndex > endIndex || node.endIndex < beginIndex) {
      return Long.MAX_VALUE;
    }

    if (node.beginIndex >= beginIndex && node.endIndex <= endIndex) {
      return node.delta + node.minValue;
    }

    if (node.delta != 0) {
      node.left.delta += node.delta;
      node.right.delta += node.delta;
      node.minValue += node.delta;
      node.delta = 0;
    }

    return Math.min(
        querySegmentTree(beginIndex, endIndex, node.left),
        querySegmentTree(beginIndex, endIndex, node.right));
  }

  static Node buildNode(int[] a, int beginIndex, int endIndex) {
    if (beginIndex == endIndex) {
      return new Node(beginIndex, endIndex, 0, a[beginIndex], null, null);
    }

    int middleIndex = (beginIndex + endIndex) / 2;
    Node left = buildNode(a, beginIndex, middleIndex);
    Node right = buildNode(a, middleIndex + 1, endIndex);

    return new Node(beginIndex, endIndex, 0, Math.min(left.minValue, right.minValue), left, right);
  }
}

class Node {
  int beginIndex;
  int endIndex;
  long delta;
  long minValue;
  Node left;
  Node right;

  Node(int beginIndex, int endIndex, long delta, long minValue, Node left, Node right) {
    this.beginIndex = beginIndex;
    this.endIndex = endIndex;
    this.delta = delta;
    this.minValue = minValue;
    this.left = left;
    this.right = right;
  }
}