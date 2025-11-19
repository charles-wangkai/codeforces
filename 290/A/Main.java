// https://clintonwhitehouse3.archives.gov/WH/glimpse/presidents/html/presidents.html

import java.util.Scanner;

public class Main {
  static final String[] PRESIDENTS = {
    "Washington",
    "Adams",
    "Jefferson",
    "Madison",
    "Monroe",
    "Adams",
    "Jackson",
    "Van Buren",
    "Harrison",
    "Tyler",
    "Polk",
    "Taylor",
    "Fillmore",
    "Pierce",
    "Buchanan",
    "Lincoln",
    "Johnson",
    "Grant",
    "Hayes",
    "Garfield",
    "Arthur",
    "Cleveland",
    "Harrison",
    "Cleveland",
    "McKinley",
    "Roosevelt",
    "Taft",
    "Wilson",
    "Harding",
    "Coolidge",
    "Hoover",
    "Roosevelt",
    "Truman",
    "Eisenhower",
    "Kennedy",
    "Johnson",
    "Nixon",
    "Ford",
    "Carter",
    "Reagan"
  };

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();

    System.out.println(solve(a));

    sc.close();
  }

  static String solve(int a) {
    return PRESIDENTS[a - 1];
  }
}