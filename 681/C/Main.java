import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    sc.nextLine();
    String[] operations = new String[n];
    for (int i = 0; i < operations.length; ++i) {
      operations[i] = sc.nextLine();
    }

    System.out.println(solve(operations));

    sc.close();
  }

  static String solve(String[] operations) {
    List<String> modified = new ArrayList<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (String operation : operations) {
      String[] fields = operation.split(" ");
      if (fields[0].equals("insert")) {
        int x = Integer.parseInt(fields[1]);

        pq.offer(x);
      } else if (fields[0].equals("getMin")) {
        int x = Integer.parseInt(fields[1]);

        while (!pq.isEmpty() && pq.peek() < x) {
          pq.poll();
          modified.add("removeMin");
        }

        if (pq.isEmpty() || pq.peek() != x) {
          pq.offer(x);
          modified.add("insert %d".formatted(x));
        }
      } else if (pq.isEmpty()) {
        modified.add("insert 0");
      } else {
        pq.poll();
      }

      modified.add(operation);
    }

    return "%d\n%s".formatted(modified.size(), String.join("\n", modified));
  }
}