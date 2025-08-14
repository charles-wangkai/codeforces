import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int q = sc.nextInt();
    String[] types = new String[q];
    int[] ids = new int[q];
    for (int i = 0; i < q; ++i) {
      types[i] = sc.next();
      ids[i] = sc.nextInt();
    }

    System.out.println(solve(types, ids));

    sc.close();
  }

  static String solve(String[] types, int[] ids) {
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < types.length; ++i) {
      if (types[i].equals("L")) {
        deque.offerFirst(ids[i]);
      } else if (types[i].equals("R")) {
        deque.offerLast(ids[i]);
      }
    }

    int[] books = deque.stream().mapToInt(Integer::intValue).toArray();
    Map<Integer, Integer> bookToIndex =
        IntStream.range(0, books.length).boxed().collect(Collectors.toMap(i -> books[i], i -> i));

    List<Integer> result = new ArrayList<>();
    int leftIndex = 0;
    int rightIndex = books.length - 1;
    for (int i = types.length - 1; i >= 0; --i) {
      if (types[i].equals("L")) {
        ++leftIndex;
      } else if (types[i].equals("R")) {
        --rightIndex;
      } else {
        int index = bookToIndex.get(ids[i]);
        result.add(Math.min(index - leftIndex, rightIndex - index));
      }
    }
    Collections.reverse(result);

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}