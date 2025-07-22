import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.nextLine();

    System.out.println(solve(s));

    sc.close();
  }

  static String solve(String s) {
    return s.replaceAll(" +(?=[.,!?])", "").replaceAll("(?<=[.,!?])", " ").replaceAll(" +", " ");
  }
}