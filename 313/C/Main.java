import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int size = Integer.parseInt(st.nextToken());
    int[] a = new int[size];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < a.length; ++i) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(a));
  }

  static long solve(int[] a) {
    Arrays.sort(a);

    int size = 1;
    long sum = a[a.length - 1];
    long result = sum;
    while (size != a.length) {
      for (int i = size; i < 4 * size; ++i) {
        sum += a[a.length - 1 - i];
      }
      result += sum;

      size *= 4;
    }

    return result;
  }
}