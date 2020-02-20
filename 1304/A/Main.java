import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(solve(x, y, a, b));
        }

        sc.close();
    }

    static int solve(int x, int y, int a, int b) {
        return ((y - x) % (a + b) == 0) ? ((y - x) / (a + b)) : -1;
    }
}