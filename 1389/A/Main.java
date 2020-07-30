import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            System.out.println(solve(l, r));
        }

        sc.close();
    }

    static String solve(int l, int r) {
        return (l * 2 <= r) ? String.format("%d %d", l, l * 2) : "-1 -1";
    }
}