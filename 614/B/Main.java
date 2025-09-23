import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    String[] a = new String[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < a.length; ++i) {
      a[i] = st.nextToken();
    }

    System.out.println(solve(a));
  }

  static String solve(String[] a) {
    String prefix = "1";
    int zeroNum = 0;
    for (String ai : a) {
      if (ai.equals("0")) {
        return "0";
      }

      int endIndex = ai.length() - 1;
      while (ai.charAt(endIndex) == '0') {
        --endIndex;
      }

      String p = ai.substring(0, endIndex + 1);
      zeroNum += ai.length() - endIndex - 1;

      if (!p.equals("1")) {
        prefix = p;
      }
    }

    return prefix + "0".repeat(zeroNum);
  }
}