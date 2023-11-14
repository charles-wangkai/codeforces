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
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      String s = sc.next();
      int q = sc.nextInt();
      String[] queries = new String[q];
      sc.nextLine();
      for (int i = 0; i < queries.length; ++i) {
        queries[i] = sc.nextLine();
      }

      System.out.println(solve(a, s, queries));
    }

    sc.close();
  }

  static String solve(int[] a, String s, String[] queries) {
    Node segmentTree = buildSegmentTree(a, s, 0, a.length - 1);

    List<Integer> result = new ArrayList<>();
    for (String query : queries) {
      int[] parts = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (parts[0] == 1) {
        update(parts[1] - 1, parts[2] - 1, segmentTree);
      } else {
        result.add(segmentTree.getXor(parts[1]));
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }

  static void update(int beginIndex, int endIndex, Node node) {
    if (!(node.beginIndex > endIndex || node.endIndex < beginIndex)) {
      if (node.beginIndex >= beginIndex && node.endIndex <= endIndex) {
        node.flipped ^= true;
      } else {
        if (node.flipped) {
          node.flipped = false;
          node.left.flipped ^= true;
          node.right.flipped ^= true;
        }

        update(beginIndex, endIndex, node.left);
        update(beginIndex, endIndex, node.right);

        for (int i = 0; i < node.xors.length; ++i) {
          node.xors[i] = node.left.getXor(i) ^ node.right.getXor(i);
        }
      }
    }
  }

  static Node buildSegmentTree(int[] a, String s, int beginIndex, int endIndex) {
    Node node = new Node(beginIndex, endIndex);
    if (beginIndex == endIndex) {
      node.xors[s.charAt(beginIndex) - '0'] = a[beginIndex];
    } else {
      int middleIndex = (beginIndex + endIndex) / 2;

      node.left = buildSegmentTree(a, s, beginIndex, middleIndex);
      node.right = buildSegmentTree(a, s, middleIndex + 1, endIndex);

      for (int i = 0; i < node.xors.length; ++i) {
        node.xors[i] = node.left.xors[i] ^ node.right.xors[i];
      }
    }

    return node;
  }
}

class Node {
  int beginIndex;
  int endIndex;
  int[] xors = new int[2];
  boolean flipped;
  Node left;
  Node right;

  Node(int beginIndex, int endIndex) {
    this.beginIndex = beginIndex;
    this.endIndex = endIndex;
  }

  int getXor(int b) {
    return flipped ? xors[1 - b] : xors[b];
  }
}
