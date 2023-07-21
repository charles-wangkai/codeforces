import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    int n = a.length;

    int[] sortedIndices =
        IntStream.range(0, a.length)
            .boxed()
            .sorted(Comparator.comparing((Integer i) -> a[i]).reversed())
            .mapToInt(Integer::intValue)
            .toArray();

    int[] p = new int[n];
    int[] q = new int[n];
    int pNext = n;
    int qNext = n;
    Deque<Integer> pFreeIndices = new ArrayDeque<>();
    Deque<Integer> qFreeIndices = new ArrayDeque<>();
    for (int index : sortedIndices) {
      while (pNext > a[index]) {
        if (pFreeIndices.isEmpty()) {
          return "NO";
        }

        p[pFreeIndices.pop()] = pNext;
        --pNext;
      }
      while (qNext > a[index]) {
        if (qFreeIndices.isEmpty()) {
          return "NO";
        }

        q[qFreeIndices.pop()] = qNext;
        --qNext;
      }

      if (pNext >= qNext) {
        if (pNext < a[index]) {
          return "NO";
        }

        p[index] = pNext;
        --pNext;
        qFreeIndices.push(index);
      } else {
        if (qNext < a[index]) {
          return "NO";
        }

        q[index] = qNext;
        --qNext;
        pFreeIndices.push(index);
      }
    }
    for (int i = pNext; i >= 1; --i) {
      p[pFreeIndices.pop()] = i;
    }
    for (int i = qNext; i >= 1; --i) {
      q[qFreeIndices.pop()] = i;
    }

    return String.format(
        "YES\n%s\n%s",
        Arrays.stream(p).mapToObj(String::valueOf).collect(Collectors.joining(" ")),
        Arrays.stream(q).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}
