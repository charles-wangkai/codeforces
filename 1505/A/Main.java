import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (sc.hasNextLine()) {
      sc.nextLine();

      System.out.println("NO");
      System.out.flush();
    }

    sc.close();
  }
}
