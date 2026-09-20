import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
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

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static String solve(int[] a, int k) {
    int n = a.length;

    Set<Integer> rests = new HashSet<>();
    for (int i = 1; i <= n; ++i) {
      rests.add(i);
    }

    int[] result = new int[k];

    Set<Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());

    result[0] =
        (set.size() == a.length)
            ? rests.stream()
                .filter(rest -> rest != a[a.length - 1] && rest != a[a.length - 2])
                .findAny()
                .get()
            : IntStream.rangeClosed(1, n).filter(x -> !set.contains(x)).findAny().getAsInt();
    rests.remove(result[0]);

    if (result.length >= 2) {
      result[1] = rests.stream().filter(rest -> rest != a[a.length - 1]).findAny().get();
      rests.remove(result[1]);
    }

    int[] restValues = rests.stream().mapToInt(Integer::intValue).toArray();
    int index = 0;
    for (int i = 2; i < result.length; ++i) {
      result[i] = restValues[index];
      ++index;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}