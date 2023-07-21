import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(String S) {
    StringBuilder result = new StringBuilder();
    Deque<String> tags = new ArrayDeque<>();
    int index = 0;
    while (index != S.length()) {
      if (S.startsWith("<UP>", index)) {
        tags.push("UP");
        index += "<UP>".length();
      } else if (S.startsWith("</UP>", index)) {
        tags.pop();
        index += "</UP>".length();
      } else if (S.startsWith("<DOWN>", index)) {
        tags.push("DOWN");
        index += "<DOWN>".length();
      } else if (S.startsWith("</DOWN>", index)) {
        tags.pop();
        index += "</DOWN>".length();
      } else {
        if (tags.isEmpty()) {
          result.append(S.charAt(index));
        } else {
          if (tags.peek().equals("UP")) {
            result.append(Character.toUpperCase(S.charAt(index)));
          } else {
            result.append(Character.toLowerCase(S.charAt(index)));
          }
        }

        ++index;
      }
    }

    return result.toString();
  }
}
