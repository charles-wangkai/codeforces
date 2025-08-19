import java.util.Scanner;

public class Main {
  static final int LIMIT = 2_000_000_000;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String[] signs = new String[n];
    int[] xs = new int[n];
    String[] answers = new String[n];
    for (int i = 0; i < n; ++i) {
      signs[i] = sc.next();
      xs[i] = sc.nextInt();
      answers[i] = sc.next();
    }

    System.out.println(solve(signs, xs, answers));

    sc.close();
  }

  static String solve(String[] signs, int[] xs, String[] answers) {
    int min = -LIMIT;
    int max = LIMIT;
    for (int i = 0; i < signs.length; ++i) {
      String relation = buildRelation(signs[i], answers[i]);
      if (relation.equals(">")) {
        min = Math.max(min, xs[i] + 1);
      } else if (relation.equals("<")) {
        max = Math.min(max, xs[i] - 1);
      } else if (relation.equals(">=")) {
        min = Math.max(min, xs[i]);
      } else {
        max = Math.min(max, xs[i]);
      }
    }

    return (min <= max) ? String.valueOf(min) : "Impossible";
  }

  static String buildRelation(String sign, String answer) {
    if (answer.equals("Y")) {
      return sign;
    }

    if (sign.equals(">")) {
      return "<=";
    }
    if (sign.equals("<")) {
      return ">=";
    }
    if (sign.equals(">=")) {
      return "<";
    }

    return ">";
  }
}