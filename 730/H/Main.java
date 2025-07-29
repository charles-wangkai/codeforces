import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    String[] filenames = new String[n];
    for (int i = 0; i < filenames.length; ++i) {
      filenames[i] = sc.next();
    }
    int[] a = new int[m];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(filenames, a));

    sc.close();
  }

  static String solve(String[] filenames, int[] a) {
    Set<Integer> deletedIndices =
        Arrays.stream(a).map(ai -> ai - 1).boxed().collect(Collectors.toSet());
    String[] deleted =
        deletedIndices.stream().map(deletedIndex -> filenames[deletedIndex]).toArray(String[]::new);
    String pattern =
        IntStream.range(0, Arrays.stream(deleted).mapToInt(String::length).min().getAsInt())
            .mapToObj(
                i ->
                    (Arrays.stream(deleted)
                                .mapToInt(filename -> filename.charAt(i))
                                .distinct()
                                .count()
                            == 1)
                        ? deleted[0].charAt(i)
                        : '?')
            .map(String::valueOf)
            .collect(Collectors.joining());

    return (IntStream.range(0, filenames.length)
            .allMatch(i -> isMatch(pattern, filenames[i]) == deletedIndices.contains(i)))
        ? "Yes\n%s".formatted(pattern)
        : "No";
  }

  static boolean isMatch(String pattern, String filename) {
    return pattern.length() == filename.length()
        && IntStream.range(0, pattern.length())
            .allMatch(i -> pattern.charAt(i) == '?' || pattern.charAt(i) == filename.charAt(i));
  }
}