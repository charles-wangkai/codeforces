import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int p = sc.nextInt();
    int q = sc.nextInt();
    String s = sc.next();

    System.out.println(solve(s, p, q));

    sc.close();
  }

  static String solve(String s, int p, int q) {
    for (int pCount = 0; pCount * p <= s.length(); ++pCount) {
      if ((s.length() - pCount * p) % q == 0) {
        int qCount = (s.length() - pCount * p) / q;
        int index = 0;
        List<String> partition = new ArrayList<>();
        for (int i = 0; i < pCount; ++i) {
          partition.add(s.substring(index, index + p));
          index += p;
        }
        for (int i = 0; i < qCount; ++i) {
          partition.add(s.substring(index, index + q));
          index += q;
        }

        return "%d\n%s".formatted(partition.size(), String.join("\n", partition));
      }
    }

    return "-1";
  }
}