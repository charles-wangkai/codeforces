import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static final int SIZE = 9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int[][] cells = new int[SIZE][SIZE];
            for (int r = 0; r < SIZE; ++r) {
                String line = sc.next();
                for (int c = 0; c < SIZE; ++c) {
                    cells[r][c] = line.charAt(c) - '0';
                }
            }

            System.out.println(solve(cells));
        }

        sc.close();
    }

    static String solve(int[][] cells) {
        for (int r = 0; r < SIZE; ++r) {
            int c = r % 3 * 3 + r / 3;
            cells[r][c] = cells[r][c] % 9 + 1;
        }

        return Arrays.stream(cells)
                .map(line -> Arrays.stream(line).mapToObj(String::valueOf).collect(Collectors.joining()))
                .collect(Collectors.joining("\n"));
    }
}