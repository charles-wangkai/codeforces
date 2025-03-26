// https://www.hankcs.com/program/algorithm/codeforces-86c-genetic-engineering.html
// https://github.com/charles-wangkai/aoj/blob/main/2212/Main.java

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  static final char[] LETTERS = {'A', 'C', 'G', 'T'};
  static final int MODULUS = 1_000_000_009;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    String[] collection = new String[m];
    for (int i = 0; i < collection.length; ++i) {
      collection[i] = sc.next();
    }

    System.out.println(solve(n, collection));

    sc.close();
  }

  static int solve(int n, String[] collection) {
    int maxLength = Arrays.stream(collection).mapToInt(String::length).max().getAsInt();

    List<Node> nodes = new ArrayList<>();
    buildAcAutomaton(nodes, collection);

    Map<State, Integer> dp = Map.of(new State(0, 0), 1);
    for (int i = 0; i < n; ++i) {
      Map<State, Integer> nextDp = new HashMap<>();
      for (State state : dp.keySet()) {
        Node current = nodes.get(state.nodeIndex());

        for (char letter : LETTERS) {
          Node next = findNextNode(current, letter);
          int nextK = (next.maxMatchLength >= state.k() + 1) ? 0 : (state.k() + 1);
          if (nextK + 1 <= maxLength) {
            State nextState = new State(next.index, nextK);
            nextDp.put(nextState, addMod(nextDp.getOrDefault(nextState, 0), dp.get(state)));
          }
        }
      }

      dp = nextDp;
    }

    return dp.keySet().stream()
        .filter(state -> state.k() == 0)
        .mapToInt(dp::get)
        .reduce(Main::addMod)
        .orElse(0);
  }

  static Node findNextNode(Node node, char letter) {
    Node result = node;
    while (!result.letterToChild.containsKey(letter)) {
      result = result.fail;
    }
    result = result.letterToChild.get(letter);

    return result;
  }

  static Node buildAcAutomaton(List<Node> nodes, String[] collection) {
    Node root = createNode(nodes);
    root.fail = root;
    for (int i = 0; i < collection.length; ++i) {
      Node p = root;
      for (char letter : collection[i].toCharArray()) {
        if (!p.letterToChild.containsKey(letter)) {
          p.letterToChild.put(letter, createNode(nodes));
        }
        p = p.letterToChild.get(letter);
      }

      p.matches.add(i);
      p.maxMatchLength = collection[i].length();
    }

    Queue<Node> queue = new ArrayDeque<>();
    for (char letter : LETTERS) {
      if (root.letterToChild.containsKey(letter)) {
        root.letterToChild.get(letter).fail = root;
        queue.offer(root.letterToChild.get(letter));
      } else {
        root.letterToChild.put(letter, root);
      }
    }
    while (!queue.isEmpty()) {
      Node head = queue.poll();
      for (char letter : head.letterToChild.keySet()) {
        Node child = head.letterToChild.get(letter);

        queue.offer(child);

        Node f = head.fail;
        while (!f.letterToChild.containsKey(letter)) {
          f = f.fail;
        }
        child.fail = f.letterToChild.get(letter);
        child.maxMatchLength = Math.max(child.maxMatchLength, child.fail.maxMatchLength);

        child.matches.addAll(child.fail.matches);
      }
    }

    return root;
  }

  static Node createNode(List<Node> nodes) {
    Node node = new Node(nodes.size());
    nodes.add(node);

    return node;
  }

  static int addMod(int x, int y) {
    return Math.floorMod(x + y, MODULUS);
  }
}

class Node {
  int index;
  Map<Character, Node> letterToChild = new HashMap<>();
  Node fail;
  List<Integer> matches = new ArrayList<>();
  int maxMatchLength;

  Node(int index) {
    this.index = index;
  }
}

record State(int nodeIndex, int k) {}
