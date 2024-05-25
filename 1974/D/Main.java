import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static String solve(String s) {
    int x = 0;
    int y = 0;
    List<Integer> nIndices = new ArrayList<>();
    List<Integer> sIndices = new ArrayList<>();
    List<Integer> eIndices = new ArrayList<>();
    List<Integer> wIndices = new ArrayList<>();
    for (int i = 0; i < s.length(); ++i) {
      char instruction = s.charAt(i);
      if (instruction == 'N') {
        ++y;
        nIndices.add(i);
      } else if (instruction == 'S') {
        --y;
        sIndices.add(i);
      } else if (instruction == 'E') {
        ++x;
        eIndices.add(i);
      } else {
        --x;
        wIndices.add(i);
      }
    }

    if (x % 2 != 0 || y % 2 != 0 || (x == 0 && y == 0 && s.length() == 2)) {
      return "NO";
    }

    char[] result = new char[s.length()];

    if (x < 0) {
      for (int i = 0; i < -x / 2; ++i) {
        result[wIndices.get(i)] = 'R';
      }

      for (int i = -x / 2; i < wIndices.size(); ++i) {
        result[wIndices.get(i)] = 'H';
      }
      for (int eIndex : eIndices) {
        result[eIndex] = 'H';
      }
    } else if (x > 0) {
      for (int i = 0; i < x / 2; ++i) {
        result[eIndices.get(i)] = 'R';
      }

      for (int i = x / 2; i < eIndices.size(); ++i) {
        result[eIndices.get(i)] = 'H';
      }
      for (int wIndex : wIndices) {
        result[wIndex] = 'H';
      }
    } else if (!eIndices.isEmpty()) {
      result[eIndices.get(0)] = 'R';
      result[wIndices.get(0)] = 'R';

      for (int i = 1; i < eIndices.size(); ++i) {
        result[eIndices.get(i)] = 'H';
      }
      for (int i = 1; i < wIndices.size(); ++i) {
        result[wIndices.get(i)] = 'H';
      }
    }

    if (y < 0) {
      for (int i = 0; i < -y / 2; ++i) {
        result[sIndices.get(i)] = 'R';
      }

      for (int i = -y / 2; i < sIndices.size(); ++i) {
        result[sIndices.get(i)] = 'H';
      }
      for (int nIndex : nIndices) {
        result[nIndex] = 'H';
      }
    } else if (y > 0) {
      for (int i = 0; i < y / 2; ++i) {
        result[nIndices.get(i)] = 'R';
      }

      for (int i = y / 2; i < nIndices.size(); ++i) {
        result[nIndices.get(i)] = 'H';
      }
      for (int sIndex : sIndices) {
        result[sIndex] = 'H';
      }
    } else if (!nIndices.isEmpty()) {
      result[nIndices.get(0)] = 'H';
      result[sIndices.get(0)] = 'H';

      for (int i = 1; i < nIndices.size(); ++i) {
        result[nIndices.get(i)] = 'R';
      }
      for (int i = 1; i < sIndices.size(); ++i) {
        result[sIndices.get(i)] = 'R';
      }
    }

    return new String(result);
  }
}