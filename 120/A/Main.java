import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws Throwable {
    Scanner sc = new Scanner(new File("input.txt"));
    PrintStream out = new PrintStream("output.txt");

    String door = sc.next();
    int a = sc.nextInt();

    out.println(solve(door, a));

    out.close();
    sc.close();
  }

  static char solve(String door, int a) {
    return (door.equals("front") == (a == 1)) ? 'L' : 'R';
  }
}