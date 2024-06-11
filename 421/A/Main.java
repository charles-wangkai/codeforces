import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int[] likes1 = new int[a];
    for (int i = 0; i < likes1.length; ++i) {
      likes1[i] = sc.nextInt();
    }
    int[] likes2 = new int[b];
    for (int i = 0; i < likes2.length; ++i) {
      likes2[i] = sc.nextInt();
    }

    System.out.println(solve(n, likes1, likes2));

    sc.close();
  }

  static String solve(int n, int[] likes1, int[] likes2) {
    int[] result = new int[n];
    Arrays.fill(result, 1);

    for (int like2 : likes2) {
      result[like2 - 1] = 2;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}