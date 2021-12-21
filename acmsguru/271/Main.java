import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    String[] names = new String[N];
    for (int i = 0; i < names.length; ++i) {
      names[i] = br.readLine();
    }
    String[] operations = new String[M];
    for (int i = 0; i < operations.length; ++i) {
      operations[i] = br.readLine();
    }

    System.out.println(solve(names, operations, K));
  }

  static String solve(String[] names, String[] operations, int K) {
    Deque<String> top = new ArrayDeque<>();
    Deque<String> bottom = new ArrayDeque<>();
    boolean rotated = false;
    for (int i = names.length - 1; i >= 0; --i) {
      add(K, top, rotated, bottom, names[i]);
    }

    for (String operation : operations) {
      if (operation.equals("ROTATE")) {
        rotated = !rotated;
      } else {
        add(K, top, rotated, bottom, operation.substring(4, operation.length() - 1));
      }
    }

    List<String> result = new ArrayList<>();
    Iterator<String> topIter = rotated ? top.descendingIterator() : top.iterator();
    while (topIter.hasNext()) {
      result.add(topIter.next());
    }
    for (String name : bottom) {
      result.add(name);
    }

    return String.join("\n", result);
  }

  static void add(int K, Deque<String> top, boolean rotated, Deque<String> bottom, String name) {
    if (rotated) {
      top.offerLast(name);
    } else {
      top.offerFirst(name);
    }

    if (top.size() == K + 1) {
      bottom.offerFirst(rotated ? top.pollFirst() : top.pollLast());
    }
  }
}