import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static final int[] OFFSETS = {-1, 1};

  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int[] a = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < a.length; ++i) {
        a[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solve(a));
    }
  }

  static int solve(int[] a) {
    int[] sorted =
        Arrays.stream(a)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    Map<Integer, Queue<Integer>> valueToIndices = new HashMap<>();
    for (int i = 0; i < a.length; ++i) {
      valueToIndices.putIfAbsent(a[i], new ArrayDeque<>());
      valueToIndices.get(a[i]).offer(i);
    }

    int result = 0;
    Map<Integer, Queue<Integer>> valueToAdjIndices = new HashMap<>();
    boolean[] pressed = new boolean[a.length];
    for (int value : sorted) {
      int index = findFromAdj(valueToAdjIndices, pressed, value);
      if (index == -1) {
        ++result;

        while (true) {
          index = valueToIndices.get(value).poll();
          if (!pressed[index]) {
            break;
          }
        }
      }

      pressed[index] = true;
      for (int offset : OFFSETS) {
        int adjIndex = index + offset;
        if (adjIndex >= 0 && adjIndex < a.length && !pressed[adjIndex]) {
          valueToAdjIndices.putIfAbsent(a[adjIndex], new ArrayDeque<>());
          valueToAdjIndices.get(a[adjIndex]).offer(adjIndex);
        }
      }
    }

    return result;
  }

  static int findFromAdj(
      Map<Integer, Queue<Integer>> valueToAdjIndices, boolean[] pressed, int value) {
    if (!valueToAdjIndices.containsKey(value)) {
      return -1;
    }

    Queue<Integer> adjIndices = valueToAdjIndices.get(value);
    while (!adjIndices.isEmpty()) {
      int adjIndex = adjIndices.poll();
      if (!pressed[adjIndex]) {
        return adjIndex;
      }
    }

    return -1;
  }
}