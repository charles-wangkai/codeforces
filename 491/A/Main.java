import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();

    System.out.println(solve(A, B));

    sc.close();
  }

  static String solve(int A, int B) {
    int[] result = new int[A + B + 1];
    for (int i = 0; i < B + 1; ++i) {
      result[i] = B + 1 - i;
    }
    for (int i = B + 1; i < result.length; ++i) {
      result[i] = i + 1;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}