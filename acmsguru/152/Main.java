import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A));

    sc.close();
  }

  static String solve(int[] A) {
    int total = Arrays.stream(A).sum();
    int[] parts = Arrays.stream(A).map(x -> 100 * x / total).toArray();
    int[] indices =
        IntStream.range(0, A.length).filter(i -> parts[i] * total != 100 * A[i]).toArray();
    int diff = 100 - Arrays.stream(parts).sum();
    if (diff > indices.length) {
      return "No solution";
    }

    for (int i = 0; i < diff; ++i) {
      ++parts[indices[i]];
    }

    return Arrays.stream(parts).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}