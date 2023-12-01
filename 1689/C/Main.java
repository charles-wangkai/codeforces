import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] u = new int[n - 1];
      int[] v = new int[n - 1];
      for (int i = 0; i < n - 1; ++i) {
        u[i] = sc.nextInt();
        v[i] = sc.nextInt();
      }

      System.out.println(solve(u, v));
    }

    sc.close();
  }

  static int solve(int[] u, int[] v) {
    int n = u.length + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      adjLists[u[i] - 1].add(v[i] - 1);
      adjLists[v[i] - 1].add(u[i] - 1);
    }

    int[] sizes = new int[n];
    int[] savedNums = new int[n];

    Deque<Task> stack = new ArrayDeque<>();
    stack.push(new Task(true, -1, 0));
    while (!stack.isEmpty()) {
      Task task = stack.pop();
      if (task.preOrPost()) {
        stack.push(new Task(false, task.parent(), task.node()));

        for (int adj : adjLists[task.node()]) {
          if (adj != task.parent()) {
            stack.push(new Task(true, task.node(), adj));
          }
        }
      } else {
        sizes[task.node()] = 1;
        List<Integer> children = new ArrayList<>();
        for (int adj : adjLists[task.node()]) {
          if (adj != task.parent()) {
            sizes[task.node()] += sizes[adj];
            children.add(adj);
          }
        }

        if (children.size() == 1) {
          savedNums[task.node()] = sizes[children.get(0)] - 1;
        } else if (children.size() == 2) {
          savedNums[task.node()] =
              Math.max(
                  sizes[children.get(0)] - 1 + savedNums[children.get(1)],
                  sizes[children.get(1)] - 1 + savedNums[children.get(0)]);
        }
      }
    }

    return savedNums[0];
  }
}

record Task(boolean preOrPost, int parent, int node) {}
