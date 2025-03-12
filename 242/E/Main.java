import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final int BIT_NUM = 20;

  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < a.length; ++i) {
      a[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    String[] queries = new String[m];
    for (int i = 0; i < queries.length; ++i) {
      queries[i] = br.readLine();
    }

    System.out.println(solve(a, queries));
  }

  static String solve(int[] a, String[] queries) {
    Node segmentTree = buildNode(a, 0, a.length - 1);

    List<Long> result = new ArrayList<>();
    for (String query : queries) {
      String[] parts = query.split(" ");
      if (parts[0].equals("1")) {
        int l = Integer.parseInt(parts[1]);
        int r = Integer.parseInt(parts[2]);

        long sum = 0;
        for (int b = 0; b < BIT_NUM; ++b) {
          sum += (1L << b) * query(l - 1, r - 1, b, segmentTree);
        }

        result.add(sum);
      } else {
        int l = Integer.parseInt(parts[1]);
        int r = Integer.parseInt(parts[2]);
        int x = Integer.parseInt(parts[3]);

        for (int b = 0; b < BIT_NUM; ++b) {
          if (((x >> b) & 1) == 1) {
            update(l - 1, r - 1, b, segmentTree);
          }
        }
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }

  static void update(int beginIndex, int endIndex, int b, Node node) {
    if (!(node.beginIndex > endIndex || node.endIndex < beginIndex)) {
      if (node.beginIndex >= beginIndex && node.endIndex <= endIndex) {
        node.flipped[b] ^= true;
      } else {
        if (node.flipped[b]) {
          node.flipped[b] = false;
          update(node.left.beginIndex, node.left.endIndex, b, node.left);
          update(node.right.beginIndex, node.right.endIndex, b, node.right);
        }

        update(beginIndex, endIndex, b, node.left);
        update(beginIndex, endIndex, b, node.right);

        updateNodeNums(node, b);
      }
    }
  }

  static int query(int beginIndex, int endIndex, int b, Node node) {
    if (node.beginIndex > endIndex || node.endIndex < beginIndex) {
      return 0;
    }
    if (node.beginIndex >= beginIndex && node.endIndex <= endIndex) {
      return node.flipped[b] ? node.num0s[b] : node.num1s[b];
    }

    if (node.flipped[b]) {
      node.flipped[b] = false;
      update(node.left.beginIndex, node.left.endIndex, b, node.left);
      update(node.right.beginIndex, node.right.endIndex, b, node.right);

      updateNodeNums(node, b);
    }

    return query(beginIndex, endIndex, b, node.left) + query(beginIndex, endIndex, b, node.right);
  }

  static void updateNodeNums(Node node, int b) {
    node.num0s[b] =
        (node.left.flipped[b] ? node.left.num1s[b] : node.left.num0s[b])
            + (node.right.flipped[b] ? node.right.num1s[b] : node.right.num0s[b]);
    node.num1s[b] =
        (node.left.flipped[b] ? node.left.num0s[b] : node.left.num1s[b])
            + (node.right.flipped[b] ? node.right.num0s[b] : node.right.num1s[b]);
  }

  static Node buildNode(int[] a, int beginIndex, int endIndex) {
    if (beginIndex == endIndex) {
      return new Node(
          beginIndex,
          endIndex,
          new boolean[BIT_NUM],
          IntStream.range(0, BIT_NUM).map(b -> 1 - ((a[beginIndex] >> b) & 1)).toArray(),
          IntStream.range(0, BIT_NUM).map(b -> (a[beginIndex] >> b) & 1).toArray(),
          null,
          null);
    }

    int middleIndex = (beginIndex + endIndex) / 2;
    Node left = buildNode(a, beginIndex, middleIndex);
    Node right = buildNode(a, middleIndex + 1, endIndex);

    return new Node(
        beginIndex,
        endIndex,
        new boolean[BIT_NUM],
        IntStream.range(0, BIT_NUM).map(b -> left.num0s[b] + right.num0s[b]).toArray(),
        IntStream.range(0, BIT_NUM).map(b -> left.num1s[b] + right.num1s[b]).toArray(),
        left,
        right);
  }
}

class Node {
  int beginIndex;
  int endIndex;
  boolean[] flipped;
  int[] num0s;
  int[] num1s;
  Node left;
  Node right;

  Node(
      int beginIndex,
      int endIndex,
      boolean[] flipped,
      int[] num0s,
      int[] num1s,
      Node left,
      Node right) {
    this.beginIndex = beginIndex;
    this.endIndex = endIndex;
    this.flipped = flipped;
    this.num0s = num0s;
    this.num1s = num1s;
    this.left = left;
    this.right = right;
  }
}