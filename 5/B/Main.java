import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    List<String> lines = new ArrayList<>();
    while (sc.hasNextLine()) {
      lines.add(sc.nextLine());
    }

    System.out.println(solve(lines));

    sc.close();
  }

  static String solve(List<String> lines) {
    int width = lines.stream().mapToInt(String::length).max().getAsInt();

    char[][] result = new char[lines.size() + 2][width + 2];
    for (int r = 0; r < result.length; ++r) {
      for (int c = 0; c < result[r].length; ++c) {
        result[r][c] =
            (r == 0 || r == result.length - 1 || c == 0 || c == result[r].length - 1) ? '*' : ' ';
      }
    }

    boolean leftOrRight = true;
    for (int i = 0; i < lines.size(); ++i) {
      int space = width - lines.get(i).length();
      int indentation = space / 2;
      if (space % 2 == 1) {
        if (!leftOrRight) {
          ++indentation;
        }
        leftOrRight ^= true;
      }

      for (int j = 0; j < lines.get(i).length(); ++j) {
        result[i + 1][indentation + 1 + j] = lines.get(i).charAt(j);
      }
    }

    return Arrays.stream(result).map(String::new).collect(Collectors.joining("\n"));
  }
}