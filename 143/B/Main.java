import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    boolean negative = s.startsWith("-");
    if (negative) {
      s = s.substring(1);
    }

    String integer;
    String fractional;
    int pointIndex = s.indexOf('.');
    if (pointIndex == -1) {
      integer = s;
      fractional = "00";
    } else {
      integer = s.substring(0, pointIndex);

      fractional = s.substring(pointIndex + 1);
      if (fractional.length() >= 2) {
        fractional = fractional.substring(0, 2);
      } else {
        fractional = fractional + "0".repeat(2 - fractional.length());
      }
    }

    String result = "$%s.%s".formatted(separate(integer), separate(fractional));
    if (negative) {
      result = "(%s)".formatted(result);
    }

    return result;
  }

  static String separate(String value) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < value.length(); ++i) {
      if (i != 0 && i % 3 == 0) {
        result.append(',');
      }
      result.append(value.charAt(value.length() - 1 - i));
    }

    return result.reverse().toString();
  }
}