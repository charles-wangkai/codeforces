import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      String s1 = sc.next();
      long pos = sc.nextLong();

      System.out.print(solve(s1, pos));
    }

    sc.close();
  }

  static char solve(String s1, long pos) {
    int removeNeeded = 0;
    long rest = pos;
    int length = s1.length();
    while (rest > length) {
      rest -= length;
      --length;
      ++removeNeeded;
    }

    List<Character> letters = new ArrayList<>();
    int index = 0;
    while (index != s1.length()) {
      if (removeNeeded != 0
          && !letters.isEmpty()
          && s1.charAt(index) < letters.get(letters.size() - 1)) {
        letters.remove(letters.size() - 1);
        --removeNeeded;
      } else {
        letters.add(s1.charAt(index));
        ++index;
      }
    }

    return letters.get((int) rest - 1);
  }
}