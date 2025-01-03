// https://www.hankcs.com/program/algorithm/codeforces-25e-test.html

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int BASE = 31;
  static final int MODULUS = 1_000_000_007;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String[] s = new String[3];
    for (int i = 0; i < s.length; ++i) {
      s[i] = sc.next();
    }

    System.out.println(solve(s));

    sc.close();
  }

  static int solve(String[] s) {
    Arrays.sort(s, Comparator.comparing(String::length));

    int[] basePowers = buildBasePowers(Arrays.stream(s).mapToInt(String::length).max().getAsInt());
    int[][] prefixHashes = Arrays.stream(s).map(Main::buildPrefixSums).toArray(int[][]::new);

    for (int i = 0; i < s.length; ++i) {
      for (int j = i + 1; j < s.length; ++j) {
        if (contain(basePowers, prefixHashes[j], prefixHashes[i])) {
          int k = 3 - i - j;

          if (contain(basePowers, prefixHashes[j], prefixHashes[k])) {
            return prefixHashes[j].length;
          }
          if (contain(basePowers, prefixHashes[k], prefixHashes[j])) {
            return prefixHashes[k].length;
          }

          return prefixHashes[j].length
              + prefixHashes[k].length
              - Math.max(
                  computeOverlapLength(basePowers, prefixHashes[j], prefixHashes[k]),
                  computeOverlapLength(basePowers, prefixHashes[k], prefixHashes[j]));
        }
      }
    }

    return search(basePowers, prefixHashes, IntStream.range(0, s.length).toArray(), 0);
  }

  static int search(int[] basePowers, int[][] prefixHashes, int[] indices, int depth) {
    if (depth == indices.length) {
      return prefixHashes[0].length
          + prefixHashes[1].length
          + prefixHashes[2].length
          - computeOverlapLength(basePowers, prefixHashes[indices[0]], prefixHashes[indices[1]])
          - computeOverlapLength(basePowers, prefixHashes[indices[1]], prefixHashes[indices[2]]);
    }

    int result = Integer.MAX_VALUE;
    for (int i = depth; i < indices.length; ++i) {
      swap(indices, depth, i);
      result = Math.min(result, search(basePowers, prefixHashes, indices, depth + 1));
      swap(indices, depth, i);
    }

    return result;
  }

  static void swap(int[] a, int index1, int index2) {
    int temp = a[index1];
    a[index1] = a[index2];
    a[index2] = temp;
  }

  static int computeOverlapLength(int[] basePowers, int[] prefixHashes1, int[] prefixHashes2) {
    return IntStream.rangeClosed(1, Math.min(prefixHashes1.length, prefixHashes2.length))
        .filter(
            overlapLength ->
                computeRangeHash(
                        basePowers,
                        prefixHashes1,
                        prefixHashes1.length - overlapLength,
                        prefixHashes1.length - 1)
                    == computeRangeHash(basePowers, prefixHashes2, 0, overlapLength - 1))
        .max()
        .orElse(0);
  }

  static boolean contain(int[] basePowers, int[] prefixHashes1, int[] prefixHashes2) {
    return prefixHashes1.length >= prefixHashes2.length
        && IntStream.rangeClosed(0, prefixHashes1.length - prefixHashes2.length)
            .anyMatch(
                beginIndex ->
                    computeRangeHash(
                            basePowers,
                            prefixHashes1,
                            beginIndex,
                            beginIndex + prefixHashes2.length - 1)
                        == prefixHashes2[prefixHashes2.length - 1]);
  }

  static int computeRangeHash(int[] basePowers, int[] prefixHashes, int beginIndex, int endIndex) {
    return addMod(
        prefixHashes[endIndex],
        (beginIndex == 0)
            ? 0
            : -multiplyMod(prefixHashes[beginIndex - 1], basePowers[endIndex - beginIndex + 1]));
  }

  static int[] buildBasePowers(int maxLength) {
    int[] result = new int[maxLength + 1];
    result[0] = 1;
    for (int i = 1; i < result.length; ++i) {
      result[i] = multiplyMod(result[i - 1], BASE);
    }

    return result;
  }

  static int[] buildPrefixSums(String str) {
    int[] result = new int[str.length()];
    for (int i = 0; i < result.length; ++i) {
      result[i] = addMod(multiplyMod((i == 0) ? 0 : result[i - 1], BASE), str.charAt(i) - 'a');
    }

    return result;
  }

  static int addMod(int x, int y) {
    return Math.floorMod(x + y, MODULUS);
  }

  static int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }
}