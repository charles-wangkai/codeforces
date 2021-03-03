import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String fileName = sc.next();
    System.out.println(solve(fileName));

    sc.close();
  }

  static int solve(String fileName) {
    int result = 0;
    int count = 0;
    for (int i = 0; i <= fileName.length(); ++i) {
      if (i >= 1 && i < fileName.length() && fileName.charAt(i) == fileName.charAt(i - 1)) {
        ++count;
      } else {
        if (i >= 1 && fileName.charAt(i - 1) == 'x') {
          result += Math.max(0, count - 2);
        }

        count = 1;
      }
    }

    return result;
  }
}
