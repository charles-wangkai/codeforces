import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int k = sc.nextInt();
    String leftWall = sc.next();
    String rightWall = sc.next();

    System.out.println(solve(leftWall, rightWall, k) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(String leftWall, String rightWall, int k) {
    int n = leftWall.length();

    String[] walls = {leftWall, rightWall};

    int[][] distances = new int[2][n];
    for (int i = 0; i < distances.length; ++i) {
      Arrays.fill(distances[i], -1);
    }
    distances[0][0] = 0;

    Queue<Element> queue = new ArrayDeque<>();
    queue.offer(new Element(0, 0));

    while (!queue.isEmpty()) {
      Element head = queue.poll();
      if (head.height() + k >= n) {
        return true;
      }

      update(
          walls,
          distances,
          queue,
          head.index(),
          head.height() - 1,
          distances[head.index()][head.height()] + 1);
      update(
          walls,
          distances,
          queue,
          head.index(),
          head.height() + 1,
          distances[head.index()][head.height()] + 1);
      update(
          walls,
          distances,
          queue,
          1 - head.index(),
          head.height() + k,
          distances[head.index()][head.height()] + 1);
    }

    return false;
  }

  static void update(
      String[] walls,
      int[][] distances,
      Queue<Element> queue,
      int index,
      int height,
      int distance) {
    if (height >= 0
        && walls[index].charAt(height) == '-'
        && distances[index][height] == -1
        && distance <= height) {
      distances[index][height] = distance;
      queue.offer(new Element(index, height));
    }
  }
}

record Element(int index, int height) {}
