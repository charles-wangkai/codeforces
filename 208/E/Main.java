import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] r = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      r[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int[] v = new int[m];
    int[] p = new int[m];
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      v[i] = Integer.parseInt(st.nextToken());
      p[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(r, v, p));
  }

  static String solve(int[] r, int[] v, int[] p) {
    int n = r.length;

    @SuppressWarnings("unchecked")
    List<Integer>[] childLists = new List[n + 1];
    for (int i = 0; i < childLists.length; ++i) {
      childLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < r.length; ++i) {
      childLists[r[i]].add(i + 1);
    }

    int[][] ancestors = new int[n + 1][Integer.toBinaryString(n + 1).length()];
    ancestors[0][0] = -1;
    for (int i = 0; i < r.length; ++i) {
      ancestors[i + 1][0] = r[i];
    }
    for (int exponent = 1; exponent < ancestors[0].length; ++exponent) {
      for (int node = 0; node < ancestors.length; ++node) {
        ancestors[node][exponent] =
            (ancestors[node][exponent - 1] == -1)
                ? -1
                : ancestors[ancestors[node][exponent - 1]][exponent - 1];
      }
    }

    int[] depths = new int[n + 1];
    List<List<Integer>> layers = new ArrayList<>();
    search(depths, layers, childLists, 0, 0);

    Map<Integer, Integer> nodeToIndexInLayer = new HashMap<>();
    for (List<Integer> layer : layers) {
      for (int i = 0; i < layer.size(); ++i) {
        nodeToIndexInLayer.put(layer.get(i), i);
      }
    }

    return IntStream.range(0, v.length)
        .map(
            i ->
                computeCousinNum(
                    ancestors, layers.get(depths[v[i]]), nodeToIndexInLayer.get(v[i]), v[i], p[i]))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  static int computeCousinNum(
      int[][] ancestors, List<Integer> layer, int indexInLayer, int node, int upDistance) {
    int ancestor = findAncestor(ancestors, node, upDistance);
    if (ancestor <= 0) {
      return 0;
    }

    return findRightIndex(ancestors, layer, indexInLayer, upDistance, ancestor)
        - findLeftIndex(ancestors, layer, indexInLayer, upDistance, ancestor);
  }

  static int findLeftIndex(
      int[][] ancestors,
      List<Integer> layer,
      int indexInLayer,
      int upDistance,
      int targetAncestor) {
    int result = -1;
    int lower = 0;
    int upper = indexInLayer;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (findAncestor(ancestors, layer.get(middle), upDistance) == targetAncestor) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static int findRightIndex(
      int[][] ancestors,
      List<Integer> layer,
      int indexInLayer,
      int upDistance,
      int targetAncestor) {
    int result = -1;
    int lower = indexInLayer;
    int upper = layer.size() - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (findAncestor(ancestors, layer.get(middle), upDistance) == targetAncestor) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }

  static int findAncestor(int[][] ancestors, int node, int upDistance) {
    for (int i = ancestors[node].length - 1; i >= 0; --i) {
      if (((upDistance >> i) & 1) == 1) {
        node = ancestors[node][i];
        if (node == -1) {
          return -1;
        }
      }
    }

    return node;
  }

  static void search(
      int[] depths, List<List<Integer>> layers, List<Integer>[] childLists, int depth, int node) {
    depths[node] = depth;

    if (depth == layers.size()) {
      layers.add(new ArrayList<>());
    }
    layers.get(depth).add(node);

    for (int child : childLists[node]) {
      search(depths, layers, childLists, depth + 1, child);
    }
  }
}
