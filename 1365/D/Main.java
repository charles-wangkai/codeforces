import java.util.Scanner;

public class Main {
    static final int[] R_OFFSETS = { -1, 0, 1, 0 };
    static final int[] C_OFFSETS = { 0, 1, 0, -1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] maze = new char[n][m];
            for (int r = 0; r < n; ++r) {
                String line = sc.next();
                for (int c = 0; c < m; ++c) {
                    maze[r][c] = line.charAt(c);
                }
            }

            System.out.println(solve(maze) ? "Yes" : "No");
        }

        sc.close();
    }

    static boolean solve(char[][] maze) {
        int n = maze.length;
        int m = maze[0].length;

        int goodCount = 0;
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < m; ++c) {
                if (maze[r][c] == 'B') {
                    for (int i = 0; i < R_OFFSETS.length; ++i) {
                        int adjR = r + R_OFFSETS[i];
                        int adjC = c + C_OFFSETS[i];
                        if (adjR >= 0 && adjR < n && adjC >= 0 && adjC < m) {
                            if (maze[adjR][adjC] == '.') {
                                maze[adjR][adjC] = '#';
                            } else if (maze[adjR][adjC] == 'G') {
                                return false;
                            }
                        }
                    }
                } else if (maze[r][c] == 'G') {
                    ++goodCount;
                }
            }
        }

        return search(maze, new boolean[n][m], n - 1, m - 1) == goodCount;
    }

    static int search(char[][] maze, boolean[][] visited, int r, int c) {
        int n = maze.length;
        int m = maze[0].length;

        if (maze[r][c] == '#') {
            return 0;
        }

        visited[r][c] = true;

        int result = (maze[r][c] == 'G') ? 1 : 0;
        for (int i = 0; i < R_OFFSETS.length; ++i) {
            int adjR = r + R_OFFSETS[i];
            int adjC = c + C_OFFSETS[i];
            if (adjR >= 0 && adjR < n && adjC >= 0 && adjC < m && !visited[adjR][adjC]) {
                result += search(maze, visited, adjR, adjC);
            }
        }

        return result;
    }
}