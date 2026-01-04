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
    List<Long> result = new ArrayList<>();
    LazySegTree lazySegTree = new LazySegTree(a);
    for (String query : queries) {
      String[] parts = query.split(" ");
      if (parts[0].equals("1")) {
        int l = Integer.parseInt(parts[1]);
        int r = Integer.parseInt(parts[2]);

        long sum = 0;
        for (int b = 0; b < BIT_NUM; ++b) {
          sum += (1L << b) * lazySegTree.query(l - 1, r - 1, b);
        }

        result.add(sum);
      } else {
        int l = Integer.parseInt(parts[1]);
        int r = Integer.parseInt(parts[2]);
        int x = Integer.parseInt(parts[3]);

        for (int b = 0; b < BIT_NUM; ++b) {
          if (((x >> b) & 1) == 1) {
            lazySegTree.update(l - 1, r - 1, b);
          }
        }
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}

class LazySegTree {
  Node root;

  LazySegTree(int[] values) {
    root = buildNode(values, 0, values.length - 1);
  }

  private Node buildNode(int[] values, int beginIndex, int endIndex) {
    if (beginIndex == endIndex) {
      return new Node(
          beginIndex,
          endIndex,
          new boolean[Main.BIT_NUM],
          IntStream.range(0, Main.BIT_NUM).map(b -> 1 - ((values[beginIndex] >> b) & 1)).toArray(),
          IntStream.range(0, Main.BIT_NUM).map(b -> (values[beginIndex] >> b) & 1).toArray(),
          null,
          null);
    }

    int middleIndex = (beginIndex + endIndex) / 2;
    Node left = buildNode(values, beginIndex, middleIndex);
    Node right = buildNode(values, middleIndex + 1, endIndex);

    return new Node(
        beginIndex,
        endIndex,
        new boolean[Main.BIT_NUM],
        IntStream.range(0, Main.BIT_NUM).map(b -> left.num0s[b] + right.num0s[b]).toArray(),
        IntStream.range(0, Main.BIT_NUM).map(b -> left.num1s[b] + right.num1s[b]).toArray(),
        left,
        right);
  }

  void update(int beginIndex, int endIndex, int b) {
    update(beginIndex, endIndex, b, root);
  }

  private void update(int beginIndex, int endIndex, int b, Node node) {
    if (!(node.beginIndex > endIndex || node.endIndex < beginIndex)) {
      if (node.beginIndex >= beginIndex && node.endIndex <= endIndex) {
        node.apply(b);
      } else {
        node.pushDown(b);

        update(beginIndex, endIndex, b, node.left);
        update(beginIndex, endIndex, b, node.right);

        node.pull(b);
      }
    }
  }

  int query(int beginIndex, int endIndex, int b) {
    return query(beginIndex, endIndex, b, root);
  }

  private int query(int beginIndex, int endIndex, int b, Node node) {
    if (node.beginIndex > endIndex || node.endIndex < beginIndex) {
      return 0;
    }
    if (node.beginIndex >= beginIndex && node.endIndex <= endIndex) {
      return node.getComputedNum1(b);
    }

    node.pushDown(b);

    node.pull(b);

    return query(beginIndex, endIndex, b, node.left) + query(beginIndex, endIndex, b, node.right);
  }

  static class Node {
    int beginIndex;
    int endIndex;
    boolean[] flipped;
    int[] num0s;
    int[] num1s;
    Node left;
    Node right;

    public Node(
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

    int getComputedNum0(int b) {
      return flipped[b] ? num1s[b] : num0s[b];
    }

    int getComputedNum1(int b) {
      return flipped[b] ? num0s[b] : num1s[b];
    }

    void pushDown(int b) {
      if (flipped[b]) {
        left.apply(b);
        right.apply(b);

        flipped[b] = false;
      }
    }

    void apply(int b) {
      flipped[b] ^= true;
    }

    void pull(int b) {
      num0s[b] = left.getComputedNum0(b) + right.getComputedNum0(b);
      num1s[b] = left.getComputedNum1(b) + right.getComputedNum1(b);
    }
  }
}
