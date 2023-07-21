import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String question = sc.nextLine();
    System.out.println(solve(question) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(String question) {
    return "aeiouy"
            .indexOf(
                new StringBuilder(question.toLowerCase().replaceAll("[ ?]", ""))
                    .reverse()
                    .charAt(0))
        >= 0;
  }
}
