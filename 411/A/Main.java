import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String password = sc.next();

    System.out.println(solve(password) ? "Correct" : "Too weak");

    sc.close();
  }

  static boolean solve(String password) {
    return password.length() >= 5
        && password.chars().anyMatch(Character::isUpperCase)
        && password.chars().anyMatch(Character::isLowerCase)
        && password.chars().anyMatch(Character::isDigit);
  }
}