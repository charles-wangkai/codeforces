import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  static final int DIGIT_NUM = 10;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static long solve(String s) {
    int[] digits = s.chars().map(c -> c - '0').toArray();

    long result = 0;
    for (int distinctNum = 1; distinctNum <= DIGIT_NUM; ++distinctNum) {
      Map<Integer, Queue<Integer>> digitToIndices = new HashMap<>();
      int lastIndex = -1;
      for (int i = 0; i < digits.length; ++i) {
        while (lastIndex + 1 != digits.length
            && digitToIndices.getOrDefault(digits[lastIndex + 1], new ArrayDeque<>()).size()
                != distinctNum
            && (digitToIndices.size() != distinctNum
                || digitToIndices.containsKey(digits[lastIndex + 1]))) {
          digitToIndices.putIfAbsent(digits[lastIndex + 1], new ArrayDeque<>());
          digitToIndices.get(digits[lastIndex + 1]).offer(lastIndex + 1);
          ++lastIndex;
        }

        if (digitToIndices.size() == distinctNum) {
          result +=
              lastIndex
                  - digitToIndices.values().stream().mapToInt(Queue::peek).max().getAsInt()
                  + 1;
        }

        digitToIndices.get(digits[i]).poll();
        if (digitToIndices.get(digits[i]).isEmpty()) {
          digitToIndices.remove(digits[i]);
        }
      }
    }

    return result;
  }
}
