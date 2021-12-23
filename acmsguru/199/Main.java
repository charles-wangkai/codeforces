import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int[] S = new int[N];
    int[] B = new int[N];
    for (int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine());
      S[i] = Integer.parseInt(st.nextToken());
      B[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(S, B));
  }

  static String solve(int[] S, int[] B) {
    int N = S.length;

    Integer[] sortedIndices = new Integer[N];
    for (int i = 0; i < sortedIndices.length; ++i) {
      sortedIndices[i] = i;
    }
    Arrays.sort(
        sortedIndices,
        (i1, i2) ->
            (S[i1] != S[i2]) ? Integer.compare(S[i1], S[i2]) : -Integer.compare(B[i1], B[i2]));

    int[] sequence = new int[N];
    int length = 0;
    int[] prevIndices = new int[N];
    for (int index : sortedIndices) {
      if (length == 0 || B[index] > B[sequence[length - 1]]) {
        if (length != 0) {
          prevIndices[index] = sequence[length - 1];
        }

        sequence[length] = index;
        ++length;
      } else {
        int pos = findFirstGE(B, sequence, length, index);
        sequence[pos] = index;

        if (pos != 0) {
          prevIndices[index] = sequence[pos - 1];
        }
      }
    }

    int[] invited = new int[length];
    invited[invited.length - 1] = sequence[length - 1];
    for (int i = invited.length - 2; i >= 0; --i) {
      invited[i] = prevIndices[invited[i + 1]];
    }

    StringBuilder result = new StringBuilder().append(invited.length).append("\n");
    for (int i = 0; i < invited.length; ++i) {
      if (i != 0) {
        result.append(" ");
      }
      result.append(invited[i] + 1);
    }

    return result.toString();
  }

  static int findFirstGE(int[] B, int[] sequence, int length, int index) {
    int result = -1;
    int lower = 0;
    int upper = length - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (B[sequence[middle]] >= B[index]) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }
}