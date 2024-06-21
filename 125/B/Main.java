import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String xml = sc.next();

    System.out.println(solve(xml));

    sc.close();
  }

  static String solve(String xml) {
    List<String> lines = new ArrayList<>();
    int fromIndex = 0;
    int level = -1;
    while (fromIndex != xml.length()) {
      int index = xml.indexOf('>', fromIndex);
      String tag = xml.substring(fromIndex, index + 1);
      if (tag.charAt(1) == '/') {
        lines.add(" ".repeat(level * 2) + tag);
        --level;
      } else {
        ++level;
        lines.add(" ".repeat(level * 2) + tag);
      }

      fromIndex = index + 1;
    }

    return String.join("\n", lines);
  }
}