import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int src = sc.nextInt() - 1;
    int dest = sc.nextInt() - 1;
    int N = sc.nextInt();
    int M = sc.nextInt();
    char[] C = new char[N];
    int[] r = new int[N];
    int[] tB = new int[N];
    int[] tP = new int[N];
    for (int i = 0; i < N; ++i) {
      C[i] = sc.next().charAt(0);
      r[i] = sc.nextInt();
      tB[i] = sc.nextInt();
      tP[i] = sc.nextInt();
    }
    int[][] edges = new int[N][N];
    for (int i = 0; i < N; ++i) {
      Arrays.fill(edges[i], Integer.MAX_VALUE);
    }
    for (int i = 0; i < M; ++i) {
      int node1 = sc.nextInt() - 1;
      int node2 = sc.nextInt() - 1;
      int l = sc.nextInt();

      edges[node1][node2] = l;
      edges[node2][node1] = l;
    }

    System.out.println(solve(src, dest, C, r, tB, tP, edges));

    sc.close();
  }

  static String solve(int src, int dest, char[] C, int[] r, int[] tB, int[] tP, int[][] edges) {
    int N = C.length;

    int[] times = new int[N];
    Arrays.fill(times, Integer.MAX_VALUE);

    int[] prevs = new int[N];

    PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparing(e -> e.time));
    pq.offer(new Element(src, -1, 0));
    while (!pq.isEmpty()) {
      Element head = pq.poll();
      if (times[head.node] == Integer.MAX_VALUE) {
        times[head.node] = head.time;
        prevs[head.node] = head.prev;

        for (int nextNode = 0; nextNode < N; ++nextNode) {
          if (times[nextNode] == Integer.MAX_VALUE) {
            int nextTime = computeNextTime(C, r, tB, tP, edges, head.node, nextNode, head.time);
            if (nextTime != Integer.MAX_VALUE) {
              pq.offer(new Element(nextNode, head.node, nextTime));
            }
          }
        }
      }
    }

    if (times[dest] == Integer.MAX_VALUE) {
      return "0";
    }

    List<Integer> path = new ArrayList<>();
    int v = dest;
    while (true) {
      path.add(v + 1);
      if (v == src) {
        break;
      }

      v = prevs[v];
    }
    Collections.reverse(path);

    return String.format(
        "%d\n%s", times[dest], path.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }

  static int computeNextTime(
      char[] C, int[] r, int[] tB, int[] tP, int[][] edges, int fromNode, int toNode, int time) {
    if (edges[fromNode][toNode] == Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }

    char fromColor;
    int fromRest;
    if (time < r[fromNode]) {
      fromColor = C[fromNode];
      fromRest = r[fromNode] - time;
    } else if (C[fromNode] == 'B') {
      int m = (time - r[fromNode]) % (tP[fromNode] + tB[fromNode]);
      if (m < tP[fromNode]) {
        fromColor = 'P';
        fromRest = tP[fromNode] - m;
      } else {
        fromColor = 'B';
        fromRest = tP[fromNode] + tB[fromNode] - m;
      }
    } else {
      int m = (time - r[fromNode]) % (tB[fromNode] + tP[fromNode]);
      if (m < tB[fromNode]) {
        fromColor = 'B';
        fromRest = tB[fromNode] - m;
      } else {
        fromColor = 'P';
        fromRest = tB[fromNode] + tP[fromNode] - m;
      }
    }

    char toColor;
    int toRest;
    if (time < r[toNode]) {
      toColor = C[toNode];
      toRest = r[toNode] - time;
    } else if (C[toNode] == 'B') {
      int m = (time - r[toNode]) % (tP[toNode] + tB[toNode]);
      if (m < tP[toNode]) {
        toColor = 'P';
        toRest = tP[toNode] - m;
      } else {
        toColor = 'B';
        toRest = tP[toNode] + tB[toNode] - m;
      }
    } else {
      int m = (time - r[toNode]) % (tB[toNode] + tP[toNode]);
      if (m < tB[toNode]) {
        toColor = 'B';
        toRest = tB[toNode] - m;
      } else {
        toColor = 'P';
        toRest = tB[toNode] + tP[toNode] - m;
      }
    }

    if (fromColor != toColor
        && fromRest == toRest
        && tB[fromNode] == tP[toNode]
        && tB[toNode] == tP[fromNode]) {
      return Integer.MAX_VALUE;
    }

    while (fromColor != toColor) {
      int delta = Math.min(fromRest, toRest);
      time += delta;

      fromRest -= delta;
      if (fromRest == 0) {
        if (fromColor == 'B') {
          fromColor = 'P';
          fromRest = tP[fromNode];
        } else {
          fromColor = 'B';
          fromRest = tB[fromNode];
        }
      }

      toRest -= delta;
      if (toRest == 0) {
        if (toColor == 'B') {
          toColor = 'P';
          toRest = tP[toNode];
        } else {
          toColor = 'B';
          toRest = tB[toNode];
        }
      }
    }

    return time + edges[fromNode][toNode];
  }
}

class Element {
  int node;
  int prev;
  int time;

  Element(int node, int prev, int time) {
    this.node = node;
    this.prev = prev;
    this.time = time;
  }
}
