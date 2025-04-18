import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String[] words = new String[n];
    for (int i = 0; i < words.length; ++i) {
      words[i] = sc.next();
    }

    System.out.println(solve(words));

    sc.close();
  }

  static int solve(String[] words) {
    int result = 0;
    for (char letter1 = 'a'; letter1 <= 'z'; ++letter1) {
      for (char letter2 = letter1; letter2 <= 'z'; ++letter2) {
        result = Math.max(result, computeTotalSum(words, letter1, letter2));
      }
    }

    return result;
  }

  static int computeTotalSum(String[] words, char letter1, char letter2) {
    return Arrays.stream(words)
        .filter(word -> word.chars().allMatch(c -> c == letter1 || c == letter2))
        .mapToInt(String::length)
        .sum();
  }
}