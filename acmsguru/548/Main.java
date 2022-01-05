import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    char[] types = new char[n - 1];
    int[] values = new int[n - 1];
    for (int i = 0; i < n - 1; ++i) {
      types[i] = sc.next().charAt(0);
      values[i] = sc.nextInt();
    }

    System.out.println(solve(types, values));

    sc.close();
  }

  static String solve(char[] types, int[] values) {
    PriorityQueue<Gold> pq = new PriorityQueue<>(Comparator.comparing(g -> g.amount));
    for (int i = 0; i < types.length - 1; ++i) {
      if (types[i] == 'd') {
        pq.offer(new Gold(i + 2, values[i]));
      } else {
        while (pq.size() >= values[i]) {
          pq.poll();
        }
      }
    }

    return (pq.size() < values[values.length - 1])
        ? "-1"
        : String.format(
            "%d\n%d\n%s",
            pq.stream().mapToInt(g -> g.amount).sum(),
            pq.size(),
            pq.stream()
                .map(g -> g.cell)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
  }
}

class Gold {
  int cell;
  int amount;

  Gold(int cell, int amount) {
    this.cell = cell;
    this.amount = amount;
  }
}