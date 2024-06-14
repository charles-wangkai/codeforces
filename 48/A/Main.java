import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String fGesture = sc.next();
    String mGesture = sc.next();
    String sGesture = sc.next();

    System.out.println(solve(fGesture, mGesture, sGesture));

    sc.close();
  }

  static String solve(String fGesture, String mGesture, String sGesture) {
    if (isWin(fGesture, mGesture) && isWin(fGesture, sGesture)) {
      return "F";
    }
    if (isWin(mGesture, fGesture) && isWin(mGesture, sGesture)) {
      return "M";
    }
    if (isWin(sGesture, fGesture) && isWin(sGesture, mGesture)) {
      return "S";
    }

    return "?";
  }

  static boolean isWin(String gesture1, String gesture2) {
    return (gesture1.equals("rock") && gesture2.equals("scissors"))
        || (gesture1.equals("scissors") && gesture2.equals("paper"))
        || (gesture1.equals("paper") && gesture2.equals("rock"));
  }
}