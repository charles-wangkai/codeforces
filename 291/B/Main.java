import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.nextLine();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    char[] cs = s.toCharArray();
    boolean inQuote = false;
    for (int i = 0; i < cs.length; ++i) {
      if (cs[i] == '"') {
        cs[i] = inQuote ? '>' : '<';
        inQuote ^= true;
      } else if (cs[i] == ' ' && inQuote) {
        cs[i] = '_';
      }
    }

    return Arrays.stream(new String(cs).split(" "))
        .filter(part -> !part.isEmpty())
        .map(part -> (part.startsWith("<") ? "%s" : "<%s>").formatted(part.replace('_', ' ')))
        .collect(Collectors.joining("\n"));
  }
}