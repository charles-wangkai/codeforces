// https://en.wikipedia.org/wiki/Cartesian_tree#Efficient_construction

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    Node[] nodes = new Node[N];
    for (int i = 0; i < nodes.length; ++i) {
      st = new StringTokenizer(br.readLine());
      int k = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());

      nodes[i] = new Node(i + 1, k, a);
    }

    System.out.println(solve(nodes));
  }

  static String solve(Node[] nodes) {
    Arrays.sort(nodes, Comparator.comparing(node -> node.k));

    for (int i = 1; i < nodes.length; ++i) {
      Node parent = nodes[i - 1];
      while (parent != null && parent.a > nodes[i].a) {
        parent = parent.parent;
      }

      if (parent == null) {
        Node root = nodes[i - 1];
        while (root.parent != null) {
          root = root.parent;
        }

        root.parent = nodes[i];
        nodes[i].left = root;
      } else if (parent.right == null) {
        parent.right = nodes[i];
        nodes[i].parent = parent;
      } else {
        Node oldRight = parent.right;

        parent.right = nodes[i];
        nodes[i].parent = parent;

        nodes[i].left = oldRight;
        oldRight.parent = nodes[i];
      }
    }

    String[] solution = new String[nodes.length];
    for (Node node : nodes) {
      solution[node.id - 1] =
          ((node.parent == null) ? 0 : node.parent.id)
              + " "
              + ((node.left == null) ? 0 : node.left.id)
              + " "
              + ((node.right == null) ? 0 : node.right.id);
    }

    return String.format("YES\n%s", String.join("\n", solution));
  }
}

class Node {
  int id;
  int k;
  int a;
  Node parent;
  Node left;
  Node right;

  Node(int id, int k, int a) {
    this.id = id;
    this.k = k;
    this.a = a;
  }
}
