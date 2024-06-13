import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static final String[] MONTHS = {
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "September",
    "October",
    "November",
    "December"
  };

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String currentMonth = sc.next();
    int k = sc.nextInt();

    System.out.println(solve(currentMonth, k));

    sc.close();
  }

  static String solve(String currentMonth, int k) {
    return MONTHS[(Arrays.asList(MONTHS).indexOf(currentMonth) + k) % MONTHS.length];
  }
}