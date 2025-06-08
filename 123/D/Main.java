// https://blog.csdn.net/weixin_44178736/article/details/108007375

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static long solve(String s) {
    int n = s.length();

    int[] suffixArray = buildSuffixArray(s);
    int[] longestCommonPrefixes = buildLongestCommonPrefixes(s, suffixArray);

    long result = n * (n + 1L) / 2;
    Deque<Element> stack = new ArrayDeque<>();
    long area = 0;
    for (int height : longestCommonPrefixes) {
      int length = 1;
      while (!stack.isEmpty() && stack.peek().height() > height) {
        Element head = stack.pop();

        length += head.length();
        area -= (long) head.height() * head.length();
      }

      stack.push(new Element(height, length));
      area += (long) height * length;
      result += area;
    }

    return result;
  }

  static int[] buildLongestCommonPrefixes(String s, int[] suffixArray) {
    int n = s.length();

    int[] ranks = new int[n + 1];
    for (int i = 0; i <= n; ++i) {
      ranks[suffixArray[i]] = i;
    }

    int[] result = new int[n];
    int h = 0;
    for (int i = 0; i < n; ++i) {
      if (h != 0) {
        --h;
      }

      int j = suffixArray[ranks[i] - 1];
      while (j + h < n && i + h < n && s.charAt(j + h) == s.charAt(i + h)) {
        ++h;
      }

      result[ranks[i] - 1] = h;
    }

    return result;
  }

  static int[] buildSuffixArray(String s) {
    int n = s.length();

    Integer[] suffixArray = new Integer[n + 1];
    final int[] ranks = new int[n + 1];
    for (int i = 0; i <= n; ++i) {
      suffixArray[i] = i;
      ranks[i] = (i == n) ? -1 : s.charAt(i);
    }

    for (int k = 1; k <= n; k *= 2) {
      final int k_ = k;
      Comparator<Integer> comparator =
          (i1, i2) -> {
            if (ranks[i1] != ranks[i2]) {
              return ranks[i1] - ranks[i2];
            }

            return ((i1 + k_ < ranks.length) ? ranks[i1 + k_] : -1)
                - ((i2 + k_ < ranks.length) ? ranks[i2 + k_] : -1);
          };
      Arrays.sort(suffixArray, comparator);

      int[] nextRanks = new int[ranks.length];
      for (int i = 1; i <= n; ++i) {
        nextRanks[suffixArray[i]] =
            nextRanks[suffixArray[i - 1]]
                + ((comparator.compare(suffixArray[i - 1], suffixArray[i]) == 0) ? 0 : 1);
      }

      for (int i = 0; i < ranks.length; ++i) {
        ranks[i] = nextRanks[i];
      }
    }

    int[] result = new int[suffixArray.length];
    for (int i = 0; i < result.length; ++i) {
      result[i] = suffixArray[i];
    }

    return result;
  }
}

record Element(int height, int length) {}
