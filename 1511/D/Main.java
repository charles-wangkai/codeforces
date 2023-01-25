// https://en.wikipedia.org/wiki/De_Bruijn_sequence
// https://www.geeksforgeeks.org/hierholzers-algorithm-directed-graph

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();

    System.out.println(solve(n, k));

    sc.close();
  }

  static String solve(int n, int k) {
    String deBruijn = computeDeBruijnForTwoLength(k);

    return IntStream.range(0, n)
        .mapToObj(i -> deBruijn.charAt(i % deBruijn.length()))
        .map(String::valueOf)
        .collect(Collectors.joining());
  }

  static String computeDeBruijnForTwoLength(int k) {
    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[k];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < k; ++i) {
      for (int j = 0; j < k; ++j) {
        adjLists[i].add(j);
      }
    }

    List<Integer> path = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    int current = 0;
    while (!stack.empty()) {
      if (adjLists[current].isEmpty()) {
        path.add(current);
        current = stack.pop();
      } else {
        stack.push(current);
        current = adjLists[current].remove(adjLists[current].size() - 1);
      }
    }

    StringBuilder result = new StringBuilder();
    for (int i = path.size() - 2; i >= 0; --i) {
      result.append((char) (path.get(i) + 'a'));
    }

    return result.toString();
  }
}
