import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int k = sc.nextInt();
    String slogan = sc.next();

    System.out.println(solve(slogan, k));

    sc.close();
  }

  static String solve(String slogan, int k) {
    List<String> actions = new ArrayList<>();
    if (k == 1) {
      for (int i = 0; i < slogan.length(); ++i) {
        if (i != 0) {
          actions.add("RIGHT");
        }
        actions.add(String.format("PRINT %c", slogan.charAt(i)));
      }
    } else if (k == slogan.length()) {
      for (int i = slogan.length() - 1; i >= 0; --i) {
        if (i != slogan.length() - 1) {
          actions.add("LEFT");
        }
        actions.add(String.format("PRINT %c", slogan.charAt(i)));
      }
    } else if (k - 1 <= slogan.length() - k) {
      for (int i = k - 1; i >= 0; --i) {
        if (i != k - 1) {
          actions.add("LEFT");
        }
        actions.add(String.format("PRINT %c", slogan.charAt(i)));
      }
      for (int i = 0; i < slogan.length(); ++i) {
        if (i != 0) {
          actions.add("RIGHT");
        }
        if (i >= k) {
          actions.add(String.format("PRINT %c", slogan.charAt(i)));
        }
      }
    } else {
      for (int i = k - 1; i < slogan.length(); ++i) {
        if (i != k - 1) {
          actions.add("RIGHT");
        }
        actions.add(String.format("PRINT %c", slogan.charAt(i)));
      }
      for (int i = slogan.length() - 1; i >= 0; --i) {
        if (i != slogan.length() - 1) {
          actions.add("LEFT");
        }
        if (i <= k - 2) {
          actions.add(String.format("PRINT %c", slogan.charAt(i)));
        }
      }
    }

    return String.join("\n", actions);
  }
}