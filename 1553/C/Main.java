import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static int solve(String s) {
    return search(s, 0, 0, 0, 5, 5);
  }

  static int search(
      String s, int index, int currentScore, int nextScore, int currentRest, int nextRest) {
    if (index == s.length()) {
      return s.length();
    }

    int result = Integer.MAX_VALUE;
    char prediction = s.charAt(index);
    if (prediction == '1' || prediction == '?') {
      if (isEnd(currentScore + 1, nextScore, currentRest - 1, nextRest)) {
        result = Math.min(result, index + 1);
      } else {
        result =
            Math.min(
                result,
                search(s, index + 1, nextScore, currentScore + 1, nextRest, currentRest - 1));
      }
    }
    if (prediction == '0' || prediction == '?') {
      if (isEnd(currentScore, nextScore, currentRest - 1, nextRest)) {
        result = Math.min(result, index + 1);
      } else {
        result =
            Math.min(
                result, search(s, index + 1, nextScore, currentScore, nextRest, currentRest - 1));
      }
    }

    return result;
  }

  static boolean isEnd(int currentScore, int nextScore, int currentRest, int nextRest) {
    return currentScore + currentRest < nextScore || nextScore + nextRest < currentScore;
  }
}
