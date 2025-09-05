import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int[] a = new int[n];
    int sum01 = query(sc, 0, 1);
    int sum12 = query(sc, 1, 2);
    int sum20 = query(sc, 2, 0);
    int sum012 = (sum01 + sum12 + sum20) / 2;
    a[0] = sum012 - sum12;
    a[1] = sum012 - sum20;
    a[2] = sum012 - sum01;
    for (int i = 3; i < a.length; ++i) {
      a[i] = query(sc, 0, i) - a[0];
    }

    System.out.println(
        "! %s"
            .formatted(
                Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "))));
    System.out.flush();

    sc.close();
  }

  static int query(Scanner sc, int index1, int index2) {
    System.out.println("? %d %d".formatted(index1 + 1, index2 + 1));
    System.out.flush();

    return sc.nextInt();
  }
}