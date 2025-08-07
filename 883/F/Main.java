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
    return (int)
        Arrays.stream(words)
            .map(word -> word.replace("u", "oo").replaceAll("k+h", "h"))
            .distinct()
            .count();
  }
}