import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String N = sc.next();
    int K = sc.nextInt();

    System.out.println(solve(N, K));

    sc.close();
  }

  static String solve(String N, int K) {
    StringBuilder result = new StringBuilder();
    int beginIndex = 0;
    int endIndex = K;
    for (int i = 0; i < N.length() - K; ++i) {
      int chosenIndex = -1;
      for (int j = beginIndex; j <= endIndex; ++j) {
        if ((i != 0 || N.charAt(j) != '0')
            && (chosenIndex == -1 || N.charAt(j) > N.charAt(chosenIndex))) {
          chosenIndex = j;
        }
      }
      result.append(N.charAt(chosenIndex));

      beginIndex = chosenIndex + 1;
      ++endIndex;
    }

    return result.toString();
  }
}
