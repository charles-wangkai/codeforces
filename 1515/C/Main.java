import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      int[] h = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < h.length; ++i) {
        h[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solve(h, m, x));
    }
  }

  static String solve(int[] h, int m, int x) {
    PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparing(e -> e.height));
    for (int i = 1; i <= m; ++i) {
      pq.offer(new Element(i, 0));
    }

    int[] result = new int[h.length];
    for (int i = 0; i < result.length; ++i) {
      Element element = pq.poll();

      result[i] = element.tower;

      pq.offer(new Element(element.tower, element.height + h[i]));
    }

    return String.format(
        "YES\n%s",
        Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}

class Element {
  int tower;
  int height;

  Element(int tower, int height) {
    this.tower = tower;
    this.height = height;
  }
}
