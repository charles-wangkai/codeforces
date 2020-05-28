import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            char[][] squares = new char[n][m];
            for (int r = 0; r < n; ++r) {
                String line = sc.next();
                for (int c = 0; c < m; ++c) {
                    squares[r][c] = line.charAt(c);
                }
            }

            System.out.println(solve(squares, x, y));
        }

        sc.close();
    }

    static int solve(char[][] squares, int x, int y) {
        int n = squares.length;
        int m = squares[0].length;

        int result = 0;
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < m; ++c) {
                if (squares[r][c] == '.') {
                    squares[r][c] = ' ';

                    if (c + 1 < m && squares[r][c + 1] == '.' && y < 2 * x) {
                        squares[r][c + 1] = ' ';
                        result += y;
                    } else {
                        result += x;
                    }
                }
            }
        }

        return result;
    }
}