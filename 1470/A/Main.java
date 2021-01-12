import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      int[] k = new int[n];
      for (int i = 0; i < k.length; ++i) {
        k[i] = Integer.parseInt(st.nextToken()) - 1;
      }
      st = new StringTokenizer(br.readLine());
      int[] c = new int[m];
      for (int i = 0; i < c.length; ++i) {
        c[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solve(k, c));
    }
  }

  static long solve(int[] k, int[] c) {
    k = Arrays.stream(k).boxed().sorted().mapToInt(x -> x).toArray();
    long result = 0;
    int prevIndex = -1;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int index : k) {
      while (prevIndex != index) {
        ++prevIndex;
        pq.offer(c[prevIndex]);
      }
      pq.offer(c[index]);

      result += pq.poll();
    }

    return result;
  }
}
