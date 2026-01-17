import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, int k) {
    return check(k, a)
        || check(k, IntStream.range(0, a.length).map(i -> a[a.length - 1 - i]).toArray());
  }

  static boolean check(int k, int[] values) {
    int leftIndex = 0;
    MedianComputer leftMedianComputer = new MedianComputer();
    while (true) {
      if (leftIndex == values.length) {
        return false;
      }

      leftMedianComputer.add(values[leftIndex]);
      if (leftMedianComputer.computeMedian() <= k) {
        break;
      }

      ++leftIndex;
    }

    int rightIndex = values.length - 1;
    MedianComputer rightMedianComputer = new MedianComputer();
    while (true) {
      if (rightIndex == -1) {
        break;
      }

      rightMedianComputer.add(values[rightIndex]);
      if (rightMedianComputer.computeMedian() <= k) {
        break;
      }

      --rightIndex;
    }
    if (rightIndex > leftIndex + 1) {
      return true;
    }

    if (leftIndex != values.length - 1 && values[leftIndex + 1] > k && (leftIndex + 1) % 2 == 1) {
      ++leftIndex;
    }

    int middleIndex = leftIndex + 1;
    MedianComputer middleMedianComputer = new MedianComputer();
    while (true) {
      if (middleIndex == values.length) {
        return false;
      }

      middleMedianComputer.add(values[middleIndex]);
      if (middleMedianComputer.computeMedian() <= k) {
        return true;
      }

      ++middleIndex;
    }
  }
}

class MedianComputer {
  PriorityQueue<Integer> leftValues = new PriorityQueue<>(Comparator.reverseOrder());
  PriorityQueue<Integer> rightValues = new PriorityQueue<>();

  void add(int x) {
    if (leftValues.isEmpty() || x <= leftValues.peek()) {
      leftValues.offer(x);

      if (leftValues.size() == rightValues.size() + 2) {
        rightValues.offer(leftValues.poll());
      }
    } else {
      rightValues.offer(x);

      if (leftValues.size() == rightValues.size() - 1) {
        leftValues.offer(rightValues.poll());
      }
    }
  }

  int computeMedian() {
    return leftValues.peek();
  }
}
