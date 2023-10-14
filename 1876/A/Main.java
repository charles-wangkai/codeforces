import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int p = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, p));
    }

    sc.close();
  }

  static long solve(int[] a, int[] b, int p) {
    PriorityQueue<Element> pq = new PriorityQueue<>(Comparator.comparing(Element::cost));
    pq.offer(new Element(p, a.length));

    long result = 0;
    int[] sortedIndices =
        IntStream.range(0, a.length)
            .boxed()
            .sorted(Comparator.comparing(i -> b[i]))
            .mapToInt(Integer::intValue)
            .toArray();
    for (int index : sortedIndices) {
      Element head = pq.poll();
      result += head.cost();
      if (head.count() != 1) {
        pq.offer(new Element(head.cost(), head.count() - 1));
      }

      pq.offer(new Element(b[index], a[index]));
    }

    return result;
  }
}

record Element(int cost, int count) {}
