import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[][] a = new int[n][];
    for (int i = 0; i < a.length; ++i) {
      int m = sc.nextInt();
      a[i] = new int[m];
      for (int j = 0; j < a[i].length; ++j) {
        a[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(a));

    sc.close();
  }

  static String solve(int[][] a) {
    @SuppressWarnings("unchecked")
    Set<Integer>[] valueSets =
        Arrays.stream(a)
            .map(values -> Arrays.stream(values).boxed().collect(Collectors.toSet()))
            .toArray(Set[]::new);

    return IntStream.range(0, valueSets.length)
        .mapToObj(
            i ->
                !IntStream.range(0, valueSets.length)
                        .anyMatch(
                            j -> j != i && valueSets[j].stream().allMatch(valueSets[i]::contains))
                    ? "YES"
                    : "NO")
        .collect(Collectors.joining("\n"));
  }
}