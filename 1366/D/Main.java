import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
  static final int LIMIT = 10_000_000;

  static int[] primeFactors;

  public static void main(String[] args) throws Throwable {
    precompute();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < a.length; ++i) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(a));
  }

  static void precompute() {
    primeFactors = new int[LIMIT + 1];
    for (int i = 2; i < primeFactors.length; ++i) {
      if (primeFactors[i] == 0) {
        for (int j = i; j < primeFactors.length; j += i) {
          primeFactors[j] = i;
        }
      }
    }
  }

  static String solve(int[] a) {
    int n = a.length;

    int[] d1 = new int[n];
    int[] d2 = new int[n];
    for (int i = 0; i < n; ++i) {
      d1[i] = findD1(a[i]);
      d2[i] = (d1[i] == -1) ? -1 : (a[i] / d1[i]);
    }

    return String.format(
        "%s\n%s",
        Arrays.stream(d1).mapToObj(String::valueOf).collect(Collectors.joining(" ")),
        Arrays.stream(d2).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }

  static int findD1(int x) {
    int result = 1;
    int rest = x;
    while (rest % primeFactors[x] == 0) {
      result *= primeFactors[x];
      rest /= primeFactors[x];
    }

    return (rest == 1) ? -1 : result;
  }
}