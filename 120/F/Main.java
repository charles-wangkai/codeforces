import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws Throwable {
    Scanner sc = new Scanner(new File("input.txt"));
    PrintStream out = new PrintStream("output.txt");

    int n = sc.nextInt();
    int[][] spiders = new int[n][];
    for (int i = 0; i < spiders.length; ++i) {
      int beadNum = sc.nextInt();
      spiders[i] = new int[2 * (beadNum - 1)];
      for (int j = 0; j < spiders[i].length; ++j) {
        spiders[i][j] = sc.nextInt();
      }
    }

    out.println(solve(spiders));

    out.close();
    sc.close();
  }

  static int solve(int[][] spiders) {
    return Arrays.stream(spiders).mapToInt(Main::computeDiameter).sum();
  }

  static int computeDiameter(int[] spider) {
    int beadNum = spider.length / 2 + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[beadNum];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < beadNum - 1; ++i) {
      adjLists[spider[i * 2] - 1].add(spider[i * 2 + 1] - 1);
      adjLists[spider[i * 2 + 1] - 1].add(spider[i * 2] - 1);
    }

    return search(adjLists, -1, search(adjLists, -1, 0).node()).distance();
  }

  static Outcome search(List<Integer>[] adjLists, int parent, int node) {
    Outcome result = new Outcome(0, node);
    for (int adj : adjLists[node]) {
      if (adj != parent) {
        Outcome subResult = search(adjLists, node, adj);
        result = merge(result, new Outcome(subResult.distance() + 1, subResult.node()));
      }
    }

    return result;
  }

  static Outcome merge(Outcome o1, Outcome o2) {
    return (o1.distance() > o2.distance()) ? o1 : o2;
  }
}

record Outcome(int distance, int node) {}
