import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(solve(n));

        sc.close();
    }

    static String solve(int n) {
        List<String> cells = new ArrayList<>();

        cells.add(formatCell(0, 0));
        cells.add(formatCell(n + 1, n + 1));

        for (int i = 1; i <= n; ++i) {
            cells.add(formatCell(i, i));
        }

        for (int i = 1; i <= n + 1; ++i) {
            cells.add(formatCell(i - 1, i));
            cells.add(formatCell(i, i - 1));
        }

        return String.format("%d\n%s", cells.size(), String.join("\n", cells));
    }

    static String formatCell(int x, int y) {
        return String.format("%d %d", x, y);
    }
}