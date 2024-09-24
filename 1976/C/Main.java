import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n + m + 1];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n + m + 1];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(n, m, a, b));
    }

    sc.close();
  }

  static String solve(int n, int m, int[] a, int[] b) {
    int[] programmerIndices = IntStream.range(0, a.length).filter(i -> a[i] > b[i]).toArray();
    long[] programmerPrefixSums = new long[programmerIndices.length + 1];
    for (int i = 1; i < programmerPrefixSums.length; ++i) {
      programmerPrefixSums[i] = programmerPrefixSums[i - 1] + a[programmerIndices[i - 1]];
    }

    int[] testerIndices = IntStream.range(0, a.length).filter(i -> a[i] < b[i]).toArray();
    long[] testerPrefixSums = new long[testerIndices.length + 1];
    for (int i = 1; i < testerPrefixSums.length; ++i) {
      testerPrefixSums[i] = testerPrefixSums[i - 1] + b[testerIndices[i - 1]];
    }

    long[] aSuffixSums = new long[a.length + 1];
    for (int i = 1; i < aSuffixSums.length; ++i) {
      aSuffixSums[i] = aSuffixSums[i - 1] + a[a.length - i];
    }

    long[] bSuffixSums = new long[b.length + 1];
    for (int i = 1; i < bSuffixSums.length; ++i) {
      bSuffixSums[i] = bSuffixSums[i - 1] + b[b.length - i];
    }

    return IntStream.range(0, a.length)
        .mapToLong(
            i ->
                computeTeamSkill(
                    n,
                    m,
                    a,
                    b,
                    programmerIndices,
                    programmerPrefixSums,
                    testerIndices,
                    testerPrefixSums,
                    aSuffixSums,
                    bSuffixSums,
                    i))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  static long computeTeamSkill(
      int n,
      int m,
      int[] a,
      int[] b,
      int[] programmerIndices,
      long[] programmerPrefixSums,
      int[] testerIndices,
      long[] testerPrefixSums,
      long[] aSuffixSums,
      long[] bSuffixSums,
      int index) {
    boolean programmerOrTester = a[index] > b[index];

    int length = -1;
    int lower = 0;
    int upper = n + m + 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (computeNum(programmerIndices, programmerOrTester ? index : Integer.MAX_VALUE, middle) >= n
          || computeNum(testerIndices, !programmerOrTester ? index : Integer.MAX_VALUE, middle)
              >= m) {
        length = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    int programmerNum =
        computeNum(programmerIndices, programmerOrTester ? index : Integer.MAX_VALUE, length);
    int testerNum =
        computeNum(testerIndices, !programmerOrTester ? index : Integer.MAX_VALUE, length);

    long result = 0;
    if (index < length) {
      if (programmerOrTester) {
        result +=
            (programmerPrefixSums[programmerNum + 1] - a[index]) + testerPrefixSums[testerNum];
      } else {
        result +=
            programmerPrefixSums[programmerNum] + (testerPrefixSums[testerNum + 1] - b[index]);
      }
    } else {
      result += programmerPrefixSums[programmerNum] + testerPrefixSums[testerNum];
    }
    if (programmerNum == n) {
      result += bSuffixSums[n + m + 1 - length] - ((index >= length) ? b[index] : 0);
    } else {
      result += aSuffixSums[n + m + 1 - length] - ((index >= length) ? a[index] : 0);
    }

    return result;
  }

  static int computeNum(int[] indices, int excluded, int size) {
    int index = Arrays.binarySearch(indices, size - 1);
    if (index < 0) {
      index = -index - 2;
    }

    int result = index + 1;
    if (index >= 0 && excluded <= indices[index]) {
      --result;
    }

    return result;
  }
}