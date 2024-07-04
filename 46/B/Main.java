import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final String[] SIZES = {"S", "M", "L", "XL", "XXL"};
  static final Map<String, Integer> SIZE_TO_INDEX =
      IntStream.range(0, SIZES.length).boxed().collect(Collectors.toMap(i -> SIZES[i], i -> i));

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int Ns = sc.nextInt();
    int Nm = sc.nextInt();
    int Nl = sc.nextInt();
    int Nxl = sc.nextInt();
    int Nxxl = sc.nextInt();
    int K = sc.nextInt();
    String[] sizes = new String[K];
    for (int i = 0; i < sizes.length; ++i) {
      sizes[i] = sc.next();
    }

    System.out.println(solve(Ns, Nm, Nl, Nxl, Nxxl, sizes));

    sc.close();
  }

  static String solve(int Ns, int Nm, int Nl, int Nxl, int Nxxl, String[] sizes) {
    String[] result = new String[sizes.length];
    int[] counts = {Ns, Nm, Nl, Nxl, Nxxl};
    for (int i = 0; i < result.length; ++i) {
      int i_ = i;
      int index =
          IntStream.range(0, SIZES.length)
              .filter(j -> counts[j] != 0)
              .boxed()
              .min(
                  Comparator.<Integer, Integer>comparing(
                          j -> Math.abs(j - SIZE_TO_INDEX.get(sizes[i_])))
                      .thenComparing(
                          Comparator.<Integer, Integer>comparing(
                                  j -> Integer.signum(j - SIZE_TO_INDEX.get(sizes[i_])))
                              .reversed()))
              .get();
      --counts[index];
      result[i] = SIZES[index];
    }

    return String.join("\n", result);
  }
}