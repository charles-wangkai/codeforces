import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
    BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] a = new int[2 * n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < a.length; ++i) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    out.write(solve(a));

    out.close();
    br.close();
  }

  static String solve(int[] a) {
    int n = a.length / 2;

    int[] sortedIndices =
        IntStream.range(0, a.length)
            .boxed()
            .sorted(Comparator.comparing(i -> a[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < n; ++i) {
      if (a[sortedIndices[i * 2]] != a[sortedIndices[i * 2 + 1]]) {
        return "-1";
      }

      result
          .append(sortedIndices[i * 2] + 1)
          .append(" ")
          .append(sortedIndices[i * 2 + 1] + 1)
          .append("\n");
    }

    return result.toString();
  }
}