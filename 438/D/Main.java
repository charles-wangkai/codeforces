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
    List<Long> result = new ArrayList<>();
    SegTree segTree = new SegTree(a);
    for (String operation : operations) {
      int[] fields = Arrays.stream(operation.split(" ")).mapToInt(Integer::parseInt).toArray();
      int type = fields[0];
      if (type == 1) {
        int l = fields[1];
        int r = fields[2];

        result.add(segTree.query(l - 1, r - 1).sum());
      } else if (type == 2) {
        int l = fields[1];
        int r = fields[2];
        int x = fields[3];

        segTree.updateMod(l - 1, r - 1, x);
      } else {
        int k = fields[1];
        int x = fields[2];

        segTree.updateValue(k - 1, x);
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}

class SegTree {
  Node root;

  SegTree(int[] values) {
    root = buildNode(values, 0, values.length - 1);
  }

  private Node buildNode(int[] values, int beginIndex, int endIndex) {
    Node node = new Node(beginIndex, endIndex);

    if (beginIndex == endIndex) {
      node.element = new Element(values[beginIndex], values[beginIndex]);
    } else {
      int middleIndex = (beginIndex + endIndex) / 2;
      node.left = buildNode(values, beginIndex, middleIndex);
      node.right = buildNode(values, middleIndex + 1, endIndex);

      node.pull();
    }

    return node;
  }

  void updateValue(int index, int value) {
    updateValue(index, value, root);
  }

  private void updateValue(int index, int value, Node node) {
    if (node.beginIndex <= index && node.endIndex >= index) {
      if (node.beginIndex == node.endIndex) {
        node.element = new Element(value, value);
      } else {
        updateValue(index, value, node.left);
        updateValue(index, value, node.right);

        node.pull();
      }
    }
  }

  void updateMod(int beginIndex, int endIndex, int x) {
    updateMod(beginIndex, endIndex, x, root);
  }

  private void updateMod(int beginIndex, int endIndex, int x, Node node) {
    if (!(node.beginIndex > endIndex || node.endIndex < beginIndex)
        && query(beginIndex, endIndex, node).maxValue >= x) {
      if (node.beginIndex == node.endIndex) {
        node.element = new Element(node.element.maxValue % x, node.element.maxValue % x);
      } else {
        updateMod(beginIndex, endIndex, x, node.left);
        updateMod(beginIndex, endIndex, x, node.right);

        node.pull();
      }
    }
  }

  Element query(int beginIndex, int endIndex) {
    return query(beginIndex, endIndex, root);
  }

  private Element query(int beginIndex, int endIndex, Node node) {
    if (node.beginIndex > endIndex || node.endIndex < beginIndex) {
      return new Element(Integer.MIN_VALUE, 0);
    }
    if (node.beginIndex >= beginIndex && node.endIndex <= endIndex) {
      return node.element;
    }

    return Element.merge(
        query(beginIndex, endIndex, node.left), query(beginIndex, endIndex, node.right));
  }

  static class Node {
    int beginIndex;
    int endIndex;
    Element element;
    Node left;
    Node right;

    Node(int beginIndex, int endIndex) {
      this.beginIndex = beginIndex;
      this.endIndex = endIndex;
    }

    void pull() {
      element = Element.merge(left.element, right.element);
    }
  }

  record Element(int maxValue, long sum) {
    static Element merge(Element leftElement, Element rightElement) {
      return new Element(
          Math.max(leftElement.maxValue, rightElement.maxValue),
          leftElement.sum + rightElement.sum);
    }
  }
}
