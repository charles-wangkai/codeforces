import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    sc.nextLine();
    String[] operations = new String[m];
    for (int i = 0; i < operations.length; ++i) {
      operations[i] = sc.nextLine();
    }

    System.out.println(solve(a, operations));

    sc.close();
  }

  static String solve(int[] a, String[] operations) {
    List<Integer> result = new ArrayList<>();
    int delta = 0;
    for (String operation : operations) {
      String[] parts = operation.split(" ");
      if (parts[0].equals("1")) {
        int v = Integer.parseInt(parts[1]);
        int x = Integer.parseInt(parts[2]);

        a[v - 1] = x - delta;
      } else if (parts[0].equals("2")) {
        int y = Integer.parseInt(parts[1]);

        delta += y;
      } else {
        int q = Integer.parseInt(parts[1]);

        result.add(a[q - 1] + delta);
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}