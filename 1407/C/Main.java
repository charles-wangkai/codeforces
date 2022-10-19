import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] result = new int[n];
    int index1 = 0;
    for (int index2 = 1; index2 < n; ++index2) {
      System.out.println("? " + (index1 + 1) + " " + (index2 + 1));
      System.out.flush();
      int k1 = sc.nextInt();

      System.out.println("? " + (index2 + 1) + " " + (index1 + 1));
      System.out.flush();
      int k2 = sc.nextInt();

      if (k1 > k2) {
        result[index1] = k1;
        index1 = index2;
      } else {
        result[index2] = k2;
      }
    }

    result[index1] = n * (n + 1) / 2 - Arrays.stream(result).sum();
    System.out.println(
        String.format(
            "! %s",
            Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "))));
    System.out.flush();

    sc.close();
  }
}
