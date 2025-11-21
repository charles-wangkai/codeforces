import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int d = sc.nextInt();
    String[] A = new String[n];
    String[] B = new String[n];
    int[] t = new int[n];
    for (int i = 0; i < n; ++i) {
      A[i] = sc.next();
      B[i] = sc.next();
      t[i] = sc.nextInt();
    }

    System.out.println(solve(A, B, t, d));

    sc.close();
  }

  static String solve(String[] A, String[] B, int[] t, int d) {
    Set<String> pairs = new HashSet<>();
    for (int i = 0; i < A.length; ++i) {
      for (int j = i + 1; j < A.length; ++j) {
        if (t[j] != t[i] && t[j] - t[i] <= d && A[i].equals(B[j]) && B[i].equals(A[j])) {
          String user1 = (A[i].compareTo(B[i]) < 0) ? A[i] : B[i];
          String user2 = (A[i].compareTo(B[i]) < 0) ? B[i] : A[i];

          pairs.add("%s %s".formatted(user1, user2));
        }
      }
    }

    return "%d\n%s".formatted(pairs.size(), String.join("\n", pairs));
  }
}