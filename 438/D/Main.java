// https://codeforces.com/blog/entry/12513

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
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
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
      int type = fields[0];
      if (type == 1) {
        int l = fields[1];
        int r = fields[2];

        result.add(querySum(l - 1, r - 1, segmentTree));
      } else if (type == 2) {
        int l = fields[1];
        int r = fields[2];
        int x = fields[3];

        updateMod(l - 1, r - 1, x, segmentTree);
      } else {
        int k = fields[1];
        int x = fields[2];

        updateValue(k - 1, x, segmentTree);
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }

  static void updateValue(int index, int value, Node node) {
    if (node.beginIndex <= index && node.endIndex >= index) {
      if (node.beginIndex == node.endIndex) {
        node.maxValue = value;
        node.sum = node.maxValue;
      } else {
        updateValue(index, value, node.left);
        updateValue(index, value, node.right);

        node.maxValue = Math.max(node.left.maxValue, node.right.maxValue);
        node.sum = node.left.sum + node.right.sum;
      }
    }
  }

  static void updateMod(int beginIndex, int endIndex, int x, Node node) {
    if (!(node.beginIndex > endIndex || node.endIndex < beginIndex)
        && queryMaxValue(beginIndex, endIndex, node) >= x) {
      if (node.beginIndex == node.endIndex) {
        node.maxValue %= x;
        node.sum = node.maxValue;
      } else {
        updateMod(beginIndex, endIndex, x, node.left);
        updateMod(beginIndex, endIndex, x, node.right);

        node.maxValue = Math.max(node.left.maxValue, node.right.maxValue);
        node.sum = node.left.sum + node.right.sum;
      }
    }
  }

  static int queryMaxValue(int beginIndex, int endIndex, Node node) {
    if (node.beginIndex > endIndex || node.endIndex < beginIndex) {
      return Integer.MIN_VALUE;
    }
    if (node.beginIndex >= beginIndex && node.endIndex <= endIndex) {
      return node.maxValue;
    }

    return Math.max(
        queryMaxValue(beginIndex, endIndex, node.left),
        queryMaxValue(beginIndex, endIndex, node.right));
  }

  static long querySum(int beginIndex, int endIndex, Node node) {
    if (node.beginIndex > endIndex || node.endIndex < beginIndex) {
      return 0;
    }
    if (node.beginIndex >= beginIndex && node.endIndex <= endIndex) {
      return node.sum;
    }

    return querySum(beginIndex, endIndex, node.left) + querySum(beginIndex, endIndex, node.right);
  }

  static Node buildNode(int[] a, int beginIndex, int endIndex) {
    if (beginIndex == endIndex) {
      return new Node(beginIndex, endIndex, a[beginIndex], a[beginIndex], null, null);
    }

    int middleIndex = (beginIndex + endIndex) / 2;
    Node left = buildNode(a, beginIndex, middleIndex);
    Node right = buildNode(a, middleIndex + 1, endIndex);

    return new Node(
        beginIndex,
        endIndex,
        Math.max(left.maxValue, right.maxValue),
        left.sum + right.sum,
        left,
        right);
  }
}

class Node {
  int beginIndex;
  int endIndex;
  int maxValue;
  long sum;
  Node left;
  Node right;

  Node(int beginIndex, int endIndex, int maxValue, long sum, Node left, Node right) {
    this.beginIndex = beginIndex;
    this.endIndex = endIndex;
    this.maxValue = maxValue;
    this.sum = sum;
    this.left = left;
    this.right = right;
  }
}
