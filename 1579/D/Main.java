import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    PriorityQueue<Element> pq =
        new PriorityQueue<>(Comparator.comparing((Element e) -> e.rest).reversed());
    for (int i = 0; i < a.length; ++i) {
      if (a[i] != 0) {
        pq.offer(new Element(i + 1, a[i]));
      }
    }

    List<String> talks = new ArrayList<>();
    while (pq.size() >= 2) {
      Element e1 = pq.poll();
      Element e2 = pq.poll();
      talks.add(String.format("%d %d", e1.personId, e2.personId));

      if (e1.rest != 1) {
        pq.offer(new Element(e1.personId, e1.rest - 1));
      }
      if (e2.rest != 1) {
        pq.offer(new Element(e2.personId, e2.rest - 1));
      }
    }

    return String.format("%d\n%s", talks.size(), String.join("\n", talks));
  }
}

class Element {
  int personId;
  int rest;

  Element(int personId, int rest) {
    this.personId = personId;
    this.rest = rest;
  }
}