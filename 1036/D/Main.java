import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < a.length; ++i) {
      a[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int[] b = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < b.length; ++i) {
      b[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(a, b));
  }

  static int solve(int[] a, int[] b) {
    if (Arrays.stream(a).asLongStream().sum() != Arrays.stream(b).asLongStream().sum()) {
      return -1;
    }

    int result = 0;
    int indexA = 0;
    long sumA = 0;
    int indexB = 0;
    long sumB = 0;
    while (indexA != a.length || indexB != b.length) {
      if (sumA <= sumB) {
        sumA += a[indexA];
        ++indexA;
      } else {
        sumB += b[indexB];
        ++indexB;
      }

      if (sumA == sumB) {
        ++result;
      }
    }

    return result;
  }
}