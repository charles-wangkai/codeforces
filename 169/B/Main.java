import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String a = sc.next();
    String s = sc.next();

    System.out.println(solve(a, s));

    sc.close();
  }

  static String solve(String a, String s) {
    PriorityQueue<Character> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for (char c : s.toCharArray()) {
      pq.offer(c);
    }

    StringBuilder result = new StringBuilder();
    for (char c : a.toCharArray()) {
      if (!pq.isEmpty() && pq.peek() > c) {
        result.append(pq.poll());
      } else {
        result.append(c);
      }
    }

    return result.toString();
  }
}