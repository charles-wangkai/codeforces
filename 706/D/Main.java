import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
  static final int BIT_NUM = 30;

  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int q = Integer.parseInt(st.nextToken());
    char[] types = new char[q];
    int[] xs = new int[q];
    for (int i = 0; i < q; ++i) {
      st = new StringTokenizer(br.readLine());
      types[i] = st.nextToken().charAt(0);
      xs[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(types, xs));
  }

  static String solve(char[] types, int[] xs) {
    List<Integer> result = new ArrayList<>();
    Node trie = new Node();
    update(1, 0, trie, BIT_NUM);
    for (int i = 0; i < types.length; ++i) {
      if (types[i] == '?') {
        result.add(query(trie, xs[i]));
      } else {
        update((types[i] == '+') ? 1 : -1, xs[i], trie, BIT_NUM);
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }

  static int query(Node trie, int x) {
    int result = 0;
    Node node = trie;
    for (int i = BIT_NUM; i >= 1; --i) {
      int digit = (x >> (i - 1)) & 1;
      int d = (node.children[1 - digit] == null) ? digit : (1 - digit);
      result += (digit ^ d) << (i - 1);
      node = node.children[d];
    }

    return result;
  }

  static void update(int delta, int x, Node node, int rest) {
    if (rest != 0) {
      int digit = (x >> (rest - 1)) & 1;
      if (node.children[digit] == null) {
        node.children[digit] = new Node();
      }

      Node child = node.children[digit];
      update(delta, x, child, rest - 1);
      child.count += delta;
      if (child.count == 0) {
        node.children[digit] = null;
      }
    }
  }
}

class Node {
  Node[] children = new Node[2];
  int count;
}